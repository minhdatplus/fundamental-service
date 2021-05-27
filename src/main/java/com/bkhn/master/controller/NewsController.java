package com.bkhn.master.controller;

import com.bkhn.master.client.CompanyProfileFeignClient;
import com.bkhn.master.model.OperationRequest;
import com.bkhn.master.model.request.NewsRequest;
import com.bkhn.master.model.request.variable.VariablesNewsRangeRequest;
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
public class NewsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private CompanyProfileFeignClient profileFeignClient;

    @CrossOrigin(origins = "*")
    @PostMapping("news")
    public Map<String, Object> news(@Valid @RequestBody NewsRequest newsRequest) {
        LOGGER.info("calling news");
        OperationRequest companyProfile = new OperationRequest();
        if (newsRequest.getFromDate() != null && newsRequest.getToDate() != null) {
            VariablesNewsRangeRequest variablesNewsRangeRequest = new VariablesNewsRangeRequest();
            variablesNewsRangeRequest.setSymbol(newsRequest.getSymbol());
            variablesNewsRangeRequest.setOffset(newsRequest.getOffset());
            variablesNewsRangeRequest.setSize(newsRequest.getSize());
            variablesNewsRangeRequest.setFromDate(newsRequest.getFromDate());
            variablesNewsRangeRequest.setToDate(newsRequest.getToDate());
            variablesNewsRangeRequest.setLanguage("vn");
            companyProfile.setVariables(variablesNewsRangeRequest);
        } else {
            VariablesSimilarRequest variablesSimilarRequest = new VariablesSimilarRequest();
            variablesSimilarRequest.setSymbol(newsRequest.getSymbol());
            variablesSimilarRequest.setOffset(newsRequest.getOffset());
            variablesSimilarRequest.setSize(newsRequest.getSize());
            variablesSimilarRequest.setLanguage("vn");
            companyProfile.setVariables(variablesSimilarRequest);
        }
        companyProfile.setOperationName("news");
        companyProfile.setQuery("query news($symbol: String!, $sourceCode: String, $isWorldNews: String, $size: Int, $offset: Int, $order: String, $orderBy: String, $fromDate: String, $toDate: String) {\n  news(symbol: $symbol, sourceCode: $sourceCode, isWorldNews: $isWorldNews, size: $size, offset: $offset, order: $order, orderBy: $orderBy, fromDate: $fromDate, toDate: $toDate)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }
}
