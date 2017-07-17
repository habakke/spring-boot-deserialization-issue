package no.acme.domain.product;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name="PRODUCTS", indexes = {@Index(name="PRODUCT_ID_INDEX", columnList="id")})
public abstract class Product {

    protected @Version Long version;
    protected @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    protected ProductType type;

    @NotNull
    @Column(unique = true)
    protected String name;

    protected Product() {
    }

    public Product(String name, String description) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public ProductType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
