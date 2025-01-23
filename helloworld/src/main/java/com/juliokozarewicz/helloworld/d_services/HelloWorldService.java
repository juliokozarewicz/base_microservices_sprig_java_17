package com.juliokozarewicz.helloworld.d_services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class HelloWorldService {

    @Value("${DOMAIN_BACKEND:null2}")
    private String domainBackend;

    public Map<String, Object> execute(String message) {

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("statusCode", 200);
        response.put("statusMessage", "success");
        response.put("message", message);
        response.put("domainBackend", domainBackend);

        return response;
    }
}