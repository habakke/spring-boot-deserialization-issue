package no.acme.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {
    SUBSCRIPTION("SUBSCRIPTION"),
    PHYSICAL("PHYSICAL");

    private String text;

    ProductType(String text) {
        this.text = text;
    }

    @JsonCreator
    public static ProductType fromString(String text) {
        if (text != null) {
            for (ProductType e : ProductType.values()) {
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

