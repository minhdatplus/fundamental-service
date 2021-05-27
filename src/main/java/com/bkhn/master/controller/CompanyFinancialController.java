package com.bkhn.master.controller;

import com.bkhn.master.client.CompanyProfileFeignClient;
import com.bkhn.master.model.OperationRequest;
import com.bkhn.master.model.request.CompanyFinancialRequest;
import com.bkhn.master.model.request.variable.VariablesCompanyFinancialRequest;
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
public class CompanyFinancialController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFinancialController.class);

    @Autowired
    private CompanyProfileFeignClient profileFeignClient;

    @CrossOrigin(origins = "*")
    @PostMapping("companyFinancial")
    public Map<String, Object> companyFinancial(@Valid @RequestBody CompanyFinancialRequest newsRequest) {
        LOGGER.info("calling companyFinancial");
        OperationRequest companyProfile = new OperationRequest();
        VariablesCompanyFinancialRequest variablesCompanyFinancialRequest = new VariablesCompanyFinancialRequest();
        variablesCompanyFinancialRequest.setSymbol(newsRequest.getSymbol());
        variablesCompanyFinancialRequest.setSize(newsRequest.getSize());
        companyProfile.setVariables(variablesCompanyFinancialRequest);
        companyProfile.setOperationName("financialIndicator");
        companyProfile.setQuery("query financialIndicator($symbol: String!, $yearReport: String, $lengthReport: String, $size: Int, $offset: Int) {\n  financialIndicator(symbol: $symbol, yearReport: $yearReport, lengthReport: $lengthReport, size: $size, offset: $offset)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }
}
