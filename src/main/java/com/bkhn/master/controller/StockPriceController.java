package com.bkhn.master.controller;

import com.bkhn.master.client.CompanyProfileFeignClient;
import com.bkhn.master.model.OperationRequest;
import com.bkhn.master.model.request.NewsRequest;
import com.bkhn.master.model.request.variable.VariablesSimilarRequest;
import com.bkhn.master.model.request.variable.VariablesStockPriceRequest;
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
public class StockPriceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockPriceController.class);

    @Autowired
    private CompanyProfileFeignClient profileFeignClient;

    @CrossOrigin(origins = "*")
    @PostMapping("stockPrice")
    public Map<String, Object> stockPrice(@Valid @RequestBody NewsRequest newsRequest) {
        LOGGER.info("calling stockPrice");
        OperationRequest companyProfile = new OperationRequest();
        if (newsRequest.getFromDate() != null && newsRequest.getToDate() != null) {
            VariablesStockPriceRequest variablesStockPriceRequest = new VariablesStockPriceRequest();
            variablesStockPriceRequest.setSymbol(newsRequest.getSymbol());
            variablesStockPriceRequest.setOffset(newsRequest.getOffset());
            variablesStockPriceRequest.setSize(newsRequest.getSize());
            variablesStockPriceRequest.setFromDate(newsRequest.getFromDate());
            variablesStockPriceRequest.setToDate(newsRequest.getToDate());
            companyProfile.setVariables(variablesStockPriceRequest);
        } else {
            VariablesSimilarRequest variablesSimilarRequest = new VariablesSimilarRequest();
            variablesSimilarRequest.setSymbol(newsRequest.getSymbol());
            variablesSimilarRequest.setOffset(newsRequest.getOffset());
            variablesSimilarRequest.setSize(newsRequest.getSize());
            companyProfile.setVariables(variablesSimilarRequest);
        }
        companyProfile.setOperationName("stockPrice");
        companyProfile.setQuery("query stockPrice($symbol: String!, $size: Int, $offset: Int, $fromDate: String, $toDate: String) {\n  stockPrice(symbol: $symbol, size: $size, offset: $offset, fromDate: $fromDate, toDate: $toDate)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }
}
