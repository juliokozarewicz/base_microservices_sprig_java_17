package com.juliokozarewicz.helloworld.e_controller;

import com.juliokozarewicz.helloworld.d_services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping()
class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("${BASE_URL_HELLOWORLD:default}/helloworld")
    public Map<String, Object> handle(
        @RequestParam(
            value = "message", defaultValue = "Hello World!"
        ) String message
    ) {
        return helloWorldService.execute(message);

    }
}