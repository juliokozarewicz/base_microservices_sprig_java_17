package com.juliokozarewicz.helloworld.c_validation;

import jakarta.validation.constraints.Size;

public class HelloWorldValidation {

    @Size(min=1, max=100, message="{many_characters}")
    private String message;

    // Getters e Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}