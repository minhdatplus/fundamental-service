package com.bkhn.master.config;

import feign.Logger;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CommonInfoFeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return CustomFeignLogging.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomFeignErrorDecoder();
    }

    @Bean
    public Decoder decoder() {
        return new CustomFeignDecoder();
    }

    @Bean
    public CommonInfoFeignInterceptor commonRequestInterceptor() {
        return new CommonInfoFeignInterceptor();
    }
}
