package com.bkhn.master.controller;

import com.bkhn.master.client.CompanyProfileFeignClient;
import com.bkhn.master.model.OperationRequest;
import com.bkhn.master.model.request.CompanyProfileRequest;
import com.bkhn.master.model.request.SimilarIndustryCompanyRequest;
import com.bkhn.master.model.request.variable.VariablesRequest;
import com.bkhn.master.model.request.variable.VariablesSimilarRequest;
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
public class ShareHolderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShareHolderController.class);

    @Autowired
    private CompanyProfileFeignClient profileFeignClient;

    @CrossOrigin(origins = "*")
    @PostMapping("shareholders")
    public Map<String, Object> shareholders(@Valid @RequestBody SimilarIndustryCompanyRequest similarIndustryCompanyRequest) {
        LOGGER.info("calling shareholders");
        OperationRequest companyProfile = new OperationRequest();
        VariablesSimilarRequest variablesSimilarRequest = new VariablesSimilarRequest();
        variablesSimilarRequest.setSymbol(similarIndustryCompanyRequest.getSymbol());
        variablesSimilarRequest.setOffset(similarIndustryCompanyRequest.getOffset());
        variablesSimilarRequest.setSize(similarIndustryCompanyRequest.getSize());
        companyProfile.setVariables(variablesSimilarRequest);
        companyProfile.setOperationName("shareholders");
        companyProfile.setQuery("query shareholders($symbol: String!, $size: Int, $offset: Int, $order: String, $orderBy: String, $type: String, $language: String) {\n  shareholders(symbol: $symbol, size: $size, offset: $offset, order: $order, orderBy: $orderBy, type: $type, language: $language)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("shareholderStructure")
    public Map<String, Object> shareholderStructure(@Valid @RequestBody CompanyProfileRequest companyProfileRequest) {
        LOGGER.info("calling shareholderStructure");
        OperationRequest companyProfile = new OperationRequest();
        VariablesRequest variablesRequest = new VariablesRequest();
        variablesRequest.setSymbol(companyProfileRequest.getSymbol());
        companyProfile.setVariables(variablesRequest);
        companyProfile.setOperationName("shareholderStructure");
        companyProfile.setQuery("query shareholderStructure($symbol: String!) {\n  shareholderStructure(symbol: $symbol)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }
}
