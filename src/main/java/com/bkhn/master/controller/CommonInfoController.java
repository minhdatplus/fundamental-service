package com.bkhn.master.controller;

import com.bkhn.master.client.CommonInfoFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "/common", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommonInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonInfoController.class);

    @Autowired
    private CommonInfoFeignClient commonInfoFeignClient;

    @CrossOrigin(origins = "*")
    @GetMapping("defaultAllStocks")
    public Map<String, Object> defaultAllStocks() {
        LOGGER.info("calling defaultAllStocks");
        return commonInfoFeignClient.commonInfo();
    }
}
