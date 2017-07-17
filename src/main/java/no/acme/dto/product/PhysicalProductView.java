package no.acme.dto.product;

import no.acme.domain.product.PhysicalProduct;

public class PhysicalProductView extends ProductView {

    public int stock;

    protected PhysicalProductView() {
        super();
    }

    public PhysicalProductView(PhysicalProduct product) {
        super(product);
        this.stock = product.getStock();
    }
}
