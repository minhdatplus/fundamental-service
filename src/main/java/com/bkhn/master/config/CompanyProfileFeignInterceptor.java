package com.bkhn.master.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompanyProfileFeignInterceptor implements RequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyProfileFeignInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        template.header("Connection", "keep-alive");
        template.header("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
        template.header("sec-ch-ua-mobile", "?0");
        template.header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
        template.header("Accept", "*/*");
        template.header("Content-Type", "application/json");
        template.header("Sec-Fetch-Site", "same-origin");
        template.header("Sec-Fetch-Mode", "cors");
        template.header("Sec-Fetch-Dest", "empty");
        template.header("Referer", "https://iboard.ssi.com.vn/fundamental-analysis");
        template.header("Accept-Language", "vi,en-US;q=0.9,en;q=0.8,la;q=0.7");
        template.header("Cookie", "__utma=81962004.594960733.1615465489.1615465489.1615465489.1; __utmc=81962004; __utmz=81962004.1615465489.1.1.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); _ga=GA1.3.594960733.1615465489; _gcl_au=1.1.2037733516.1615465492; _fbp=fb.2.1615465492228.956988022; _gid=GA1.3.1734386014.1618169741; _gat_gtag_UA_143755249_2=1");
        template.header("If-None-Match", "W/\"7b8ac-Nj5ciEP4+z9YRJDDC1D3OKs7594\"");
        LOGGER.info("apply interceptor");
    }
}
