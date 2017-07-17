package no.acme.dto.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import no.acme.domain.product.Product;
import no.acme.domain.product.ProductType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhysicalProductView.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = SubscriptionProductView.class, name = "SUBSCRIPTION")
})
public abstract class ProductView {

    public Long id;

    @Enumerated(EnumType.STRING)
    public ProductType type;
    public String name;

    protected ProductView() {
    }

    public ProductView(Product product) {
        this.id = product.getId();
        this.type = product.getType();
        this.name = product.getName();
    }
}
