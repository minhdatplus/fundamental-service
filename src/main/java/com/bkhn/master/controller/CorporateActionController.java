package com.bkhn.master.controller;

import com.bkhn.master.client.CompanyProfileFeignClient;
import com.bkhn.master.model.OperationRequest;
import com.bkhn.master.model.entity.CorporateActionsDateType;
import com.bkhn.master.model.entity.CorporateActionsType;
import com.bkhn.master.model.request.CorporateActionRequest;
import com.bkhn.master.model.request.variable.VariablesCorporateActionRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class CorporateActionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CorporateActionController.class);

    @Autowired
    private CompanyProfileFeignClient profileFeignClient;

    @CrossOrigin(origins = "*")
    @PostMapping("corporateActions")
    public Map<String, Object> corporateActions(@Valid @RequestBody CorporateActionRequest corporateActionRequest) {
        LOGGER.info("calling corporateActions");
        OperationRequest companyProfile = new OperationRequest();
        VariablesCorporateActionRequest variablesCorporateActionRequest = new VariablesCorporateActionRequest();
        variablesCorporateActionRequest.setSymbol(corporateActionRequest.getSymbol());
        variablesCorporateActionRequest.setOffset(corporateActionRequest.getOffset());
        variablesCorporateActionRequest.setSize(corporateActionRequest.getSize());
        variablesCorporateActionRequest.setFromDate(corporateActionRequest.getFromDate());
        variablesCorporateActionRequest.setToDate(corporateActionRequest.getToDate());
        variablesCorporateActionRequest.setEventcode(CorporateActionsType.from(corporateActionRequest.getEventCode()).getEventCode());
        variablesCorporateActionRequest.setDatetype(CorporateActionsDateType.from(corporateActionRequest.getDateType()).getDateType());
        variablesCorporateActionRequest.setLanguage("vn");
        companyProfile.setVariables(variablesCorporateActionRequest);
        companyProfile.setOperationName("corporateActions");
        companyProfile.setQuery("query corporateActions($symbol: String, $size: Int, $offset: Int, $order: String, $orderBy: String, $fromDate: String, $toDate: String, $eventcode: String, $datetype: String) {\n  corporateActions(symbol: $symbol, size: $size, offset: $offset, order: $order, orderBy: $orderBy, fromDate: $fromDate, toDate: $toDate, eventcode: $eventcode, datetype: $datetype)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }
}
