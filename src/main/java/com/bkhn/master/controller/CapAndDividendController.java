package com.bkhn.master.controller;

import com.bkhn.master.client.CompanyProfileFeignClient;
import com.bkhn.master.model.OperationRequest;
import com.bkhn.master.model.request.CompanyFinancialRequest;
import com.bkhn.master.model.request.variable.VariablesRequest;
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
public class CapAndDividendController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CapAndDividendController.class);

    @Autowired
    private CompanyProfileFeignClient profileFeignClient;

    @CrossOrigin(origins = "*")
    @PostMapping("capAndDividend")
    public Map<String, Object> capAndDividend(@Valid @RequestBody CompanyFinancialRequest newsRequest) {
        LOGGER.info("calling capAndDividend");
        OperationRequest companyProfile = new OperationRequest();
        VariablesRequest variablesRequest = new VariablesRequest();
        variablesRequest.setSymbol(newsRequest.getSymbol());
        companyProfile.setVariables(variablesRequest);
        companyProfile.setOperationName("capAndDividend");
        companyProfile.setQuery("query capAndDividend($symbol: String!) {\n  capAndDividend(symbol: $symbol)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }
}
