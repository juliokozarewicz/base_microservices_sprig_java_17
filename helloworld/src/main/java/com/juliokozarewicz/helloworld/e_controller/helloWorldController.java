package com.juliokozarewicz.helloworld.e_controller;

import com.juliokozarewicz.helloworld.c_validation.HelloWorldValidation;
import com.juliokozarewicz.helloworld.d_services.HelloWorldService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping()
class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("${BASE_URL_HELLOWORLD:default}/helloworld")
    public Map<String, Object> handle(

        // validation errors
        @Valid HelloWorldValidation helloWorldValidation,
        BindingResult bindingResult,

        @RequestParam(
            value = "message", defaultValue = "Hello World!"
        ) String message

    ) {

        // return validation errors
        if (bindingResult.hasErrors()) {
            return Map.of("error", "Validation failed", "details", bindingResult.getAllErrors());
        }

        return helloWorldService.execute(message);

    }
}