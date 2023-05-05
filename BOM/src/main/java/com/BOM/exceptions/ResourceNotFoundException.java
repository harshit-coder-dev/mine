package com.BOM.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private String resource;
    private Integer errorCode;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, String resource) {
        super(message);
        this.resource = resource;
    }

    public ResourceNotFoundException(String message, String resource, Integer errorCode) {
        super(message);
        this.resource = resource;
        this.errorCode = errorCode;
    }

    public ResourceNotFoundException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
