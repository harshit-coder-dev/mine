package com.BOM.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseErrorDTO extends ResponseWrapperDTO {
    private String error;

    public ResponseErrorDTO() {
    }

    public ResponseErrorDTO(Integer status, String path, String error) {
        super.setStatus(status);
        super.setPath(path);
        this.error = error;
    }

    public ResponseErrorDTO(Integer status, String path, String error,String message) {
        super.setStatus(status);
        super.setMessage(message);
        super.setPath(path);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
