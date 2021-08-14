package com.pe.rappi.service.utils;

public enum WebServiceEndpoints {
    USERS("/api/users");
    private final String url;

    WebServiceEndpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
