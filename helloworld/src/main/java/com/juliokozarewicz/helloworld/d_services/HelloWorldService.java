package com.juliokozarewicz.helloworld.d_services;

import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

// locale
import org.springframework.context.MessageSource;
import java.util.Locale;

// logger
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class HelloWorldService {

    private final MessageSource messageSource;

    public HelloWorldService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Map<String, Object> execute(
        String message,
        String language
    ) {

        Locale locale = new Locale(language);

        // response (json)
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("statusCode", 200);
        response.put(
            "statusMessage",
            messageSource.getMessage(
                "get_data_success", null, locale
            )
        );
        response.put("message", message);
        return response;

    }

}
