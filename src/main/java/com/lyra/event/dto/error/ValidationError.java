package com.lyra.event.dto.error;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


public class ValidationError extends StandardError {

    private Set<FieldError> errors = new HashSet<>();


    public ValidationError() {
    }

    public ValidationError(Instant instant, Integer staus, String error, String message, String path) {
        super(instant, staus, error, message, path);
    }

    public void addFieldError(FieldError error) {
        this.errors.add(error);
    }

    public Set<FieldError> getErrors() {
        return errors;
    }
}
