package com.bkhn.master.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

@Slf4j
public class CustomFeignDecoder implements Decoder {


    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        int status = response.status();
        log.error("Response: " + response.toString());
        log.error("Status: " + status);
        try {
            String body = IOUtils.toString(response.body().asInputStream());
            log.info("Body: " + body, Charsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
//            Map<String, String> map = mapper.readValue(body, Map.class);
            // it works
            Map<String, Object> map = mapper.readValue(body, new TypeReference<Map<String, Object>>() {});
            System.out.println(map);
            return map;
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return new Exception("Error Feign Exception");
    }
}
