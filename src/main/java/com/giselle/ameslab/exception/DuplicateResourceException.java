package com.giselle.ameslab.exception;

import jakarta.validation.constraints.NotBlank;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message){
        super(message);
    }
}
