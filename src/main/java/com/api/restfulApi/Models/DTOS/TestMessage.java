package com.api.restfulApi.Models.DTOS;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMessage {
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;

    public TestMessage() {
        this.status = "";
        this.message = "";
    }

    public TestMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
