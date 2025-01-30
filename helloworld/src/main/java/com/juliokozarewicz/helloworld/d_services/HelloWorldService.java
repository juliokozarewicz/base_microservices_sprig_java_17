package com.juliokozarewicz.helloworld.d_services;

import com.juliokozarewicz.helloworld.f_utils.ErrorHandler;
import jdk.jfr.Event;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

// locale
import org.springframework.context.MessageSource;
import java.util.Locale;

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

        if ( true ) {
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("customError", true);
            errorDetails.put("errorCode", 404);
            errorDetails.put("message", "*** Mensagem de erro2 ***");
            throw new RuntimeException(errorDetails.toString());
        }

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