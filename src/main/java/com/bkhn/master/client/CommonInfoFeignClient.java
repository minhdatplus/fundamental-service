package com.bkhn.master.client;

import com.bkhn.master.config.CommonInfoFeignConfig;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Component
@FeignClient(name = "CommonInfoFeignClient", url = "https://iboard.ssi.com.vn", configuration = CommonInfoFeignConfig.class)
public interface CommonInfoFeignClient {

    @GetMapping(value = "dchart/api/1.1/defaultAllStocks")
    @Headers("Content-Type:application/json")
    Map<String, Object> commonInfo();

}