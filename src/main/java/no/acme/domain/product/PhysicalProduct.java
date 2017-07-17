package no.acme.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("PHYSICAL")
public class PhysicalProduct extends Product {

    @NotNull
    private int stock;

    private PhysicalProduct() {
        super();
    }

    public PhysicalProduct(String name, int stock) {
        super(name);
        this.stock = stock;
        this.type = ProductType.PHYSICAL;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
