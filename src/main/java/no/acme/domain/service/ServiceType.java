package no.acme.domain.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceType {
    ONDEMAND("ONDEMAND"),
    LIVE("LIVE");

    private String text;

    ServiceType(String text) {
        this.text = text;
    }

    @JsonCreator
    public static ServiceType fromString(String text) {
        if (text != null) {
            for (ServiceType e : ServiceType.values()) {
                if (text.equalsIgnoreCase(e.text)) {
                    return e;
                }
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }

    @JsonValue
    public String getText() {
        return text;
    }
}

