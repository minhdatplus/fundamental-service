package com.bkhn.master.controller;

import com.bkhn.master.client.CompanyProfileFeignClient;
import com.bkhn.master.model.OperationRequest;
import com.bkhn.master.model.request.CompanyProfileRequest;
import com.bkhn.master.model.request.LeadershipRequest;
import com.bkhn.master.model.request.SimilarIndustryCompanyRequest;
import com.bkhn.master.model.request.SubCompanyRequest;
import com.bkhn.master.model.request.variable.VariablesCompanyProfileRequest;
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
public class CompanyProfileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyProfileController.class);

    @Autowired
    private CompanyProfileFeignClient profileFeignClient;

    @CrossOrigin(origins = "*")
    @PostMapping("companyProfile")
    public Map<String, Object> companyProfile(@Valid @RequestBody CompanyProfileRequest companyProfileRequest) {
        LOGGER.info("calling companyProfile");
        VariablesCompanyProfileRequest variablesCompanyProfileRequest = new VariablesCompanyProfileRequest();
        variablesCompanyProfileRequest.setSymbol(companyProfileRequest.getSymbol());
        variablesCompanyProfileRequest.setLanguage("vn");
        OperationRequest companyProfile = new OperationRequest();
        companyProfile.setOperationName("companyProfile");
        companyProfile.setVariables(variablesCompanyProfileRequest);
        companyProfile.setQuery("query companyProfile($symbol: String!, $language: String) {\n  companyProfile(symbol: $symbol, language: $language) {\n    symbol\n    subsectorcode\n    industryname\n    supersector\n    sector\n    subsector\n    foundingdate\n    chartercapital\n    numberofemployee\n    banknumberofbranch\n    companyprofile\n    listingdate\n    exchange\n    firstprice\n    issueshare\n    listedvalue\n    companyname\n    __typename\n  }\n  companyStatistics(symbol: $symbol) {\n    symbol\n    ttmtype\n    marketcap\n    sharesoutstanding\n    bv\n    beta\n    eps\n    dilutedeps\n    pe\n    pb\n    dividendyield\n    totalrevenue\n    profit\n    asset\n    roe\n    roa\n    npl\n    financialleverage\n    __typename\n  }\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("subCompany")
    public Map<String, Object> subCompany(@Valid @RequestBody SubCompanyRequest subCompanyRequest) {
        LOGGER.info("calling subCompany");
        VariablesSimilarRequest variablesSimilarRequest = new VariablesSimilarRequest();
        variablesSimilarRequest.setSymbol(subCompanyRequest.getSymbol());
        variablesSimilarRequest.setOffset(subCompanyRequest.getOffset());
        variablesSimilarRequest.setSize(subCompanyRequest.getSize());
        variablesSimilarRequest.setLanguage("vn");
        OperationRequest companyProfile = new OperationRequest();
        companyProfile.setOperationName("subCompanies");
        companyProfile.setVariables(variablesSimilarRequest);
        companyProfile.setQuery("query subCompanies($symbol: String!, $size: Int, $offset: Int, $language: String) {\n  subCompanies(symbol: $symbol, size: $size, offset: $offset, language: $language) {\n    datas {\n      parentsymbol\n      parentcompanyname\n      roleid\n      childsymbol\n      childcompanyname\n      chartercapital\n      percentage\n      rolename\n      __typename\n    }\n    paging {\n      pagesize\n      currentpage\n      totalpage\n      totalrow\n      __typename\n    }\n    __typename\n  }\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("similarIndustryCompany")
    public Map<String, Object> similarIndustryCompany(@Valid @RequestBody SimilarIndustryCompanyRequest similarIndustryCompanyRequest) {
        LOGGER.info("calling similarIndustryCompany");
        VariablesSimilarRequest variablesSimilarRequest = new VariablesSimilarRequest();
        variablesSimilarRequest.setSymbol(similarIndustryCompanyRequest.getSymbol());
        variablesSimilarRequest.setOffset(similarIndustryCompanyRequest.getOffset());
        variablesSimilarRequest.setSize(similarIndustryCompanyRequest.getSize());
        variablesSimilarRequest.setLanguage("vn");
        OperationRequest companyProfile = new OperationRequest();
        companyProfile.setOperationName("similarIndustryCompanies");
        companyProfile.setVariables(variablesSimilarRequest);
        companyProfile.setQuery("query similarIndustryCompanies($symbol: String!, $size: Int, $offset: Int, $language: String) {\n  similarIndustryCompanies(symbol: $symbol, size: $size, offset: $offset, language: $language)\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("leadership")
    public Map<String, Object> leadership(@Valid @RequestBody LeadershipRequest leadershipRequest) {
        LOGGER.info("calling leadership");
        VariablesSimilarRequest variablesSimilarRequest = new VariablesSimilarRequest();
        variablesSimilarRequest.setSymbol(leadershipRequest.getSymbol());
        variablesSimilarRequest.setOffset(leadershipRequest.getOffset());
        variablesSimilarRequest.setSize(leadershipRequest.getSize());
        variablesSimilarRequest.setLanguage("vn");
        OperationRequest companyProfile = new OperationRequest();
        companyProfile.setOperationName("leaderships");
        companyProfile.setVariables(variablesSimilarRequest);
        companyProfile.setQuery("query leaderships($symbol: String!, $size: Int, $offset: Int, $order: String, $orderBy: String) {\n  leaderships(symbol: $symbol, size: $size, offset: $offset, order: $order, orderBy: $orderBy) {\n    datas {\n      symbol\n      fullname\n      positionname\n      positionlevel\n      __typename\n    }\n    __typename\n  }\n}\n");
        return profileFeignClient.companyProfile(companyProfile);
    }
}
