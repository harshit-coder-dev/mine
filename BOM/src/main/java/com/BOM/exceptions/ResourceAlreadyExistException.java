package com.BOM.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceAlreadyExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private String resource;
    private Integer errorCode;

    public ResourceAlreadyExistException() {
        super();
    }

    public ResourceAlreadyExistException(String message) {
        super(message);
    }

    public ResourceAlreadyExistException(String message, String resource) {
        super(message);
        this.resource = resource;
    }

    public ResourceAlreadyExistException(String message, String resource, Integer errorCode) {
        super(message);
        this.resource = resource;
        this.errorCode = errorCode;
    }

    public ResourceAlreadyExistException(String message, int errorCode) {

        super(message);
        this.errorCode = errorCode;
    }


}
