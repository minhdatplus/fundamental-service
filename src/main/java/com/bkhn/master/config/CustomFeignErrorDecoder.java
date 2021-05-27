package com.bkhn.master.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.IOException;


@Slf4j
public class CustomFeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();
        log.error("Method key: " + methodKey);
        log.error("Response: " + response.toString());
        log.error("Status: " + status);
        try {
            String body = IOUtils.toString(response.body().asInputStream());
            log.error("Body: " + body, Charsets.UTF_8);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return new Exception("Error Feign Exception");
    }


}

