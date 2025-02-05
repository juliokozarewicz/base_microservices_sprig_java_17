package com.juliokozarewicz.helloworld.c_validation;

import jakarta.validation.constraints.Size;

public record HelloWorldValidation(

        @Size(min=1, max=100, message="{many_characters}")
        String message

) {}