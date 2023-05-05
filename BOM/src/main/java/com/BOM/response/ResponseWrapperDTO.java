package com.BOM.response;

import lombok.Data;

@Data
public class ResponseWrapperDTO {
    private Integer status;
    private String message;
    private Object data;

    private String path;

    public ResponseWrapperDTO() {
    }

    public ResponseWrapperDTO(Integer status, String path, String message) {
        this.status = status;
        this.path = path;
        this.message = message;
    }

    public ResponseWrapperDTO(Integer status, String path, String message, Object data) {
        super();
        this.status = status;
        this.path = path;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
