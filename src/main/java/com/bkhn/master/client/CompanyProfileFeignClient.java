package com.bkhn.master.client;

import com.bkhn.master.config.CompanyProfileFeignConfig;
import com.bkhn.master.model.OperationRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
@FeignClient(name = "CompanyInformationClient", url = "https://finfo-iboard.ssi.com.vn", configuration = CompanyProfileFeignConfig.class)
public interface CompanyProfileFeignClient {

    @PostMapping(value = "graphql")
    @Headers("Content-Type:application/json")
    Map<String, Object> companyProfile(@RequestBody OperationRequest payload);

}