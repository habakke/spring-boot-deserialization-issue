package no.acme.domain.product;

import no.acme.domain.service.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SUBSCRIPTION")
public class SubscriptionProduct extends Product {

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    protected List<Service> services;

    private SubscriptionProduct() {
        super();
    }

    public SubscriptionProduct(String name ) {
        super(name);
        this.type = ProductType.SUBSCRIPTION;
    }

    public SubscriptionProduct(String name, List<Service> services) {
        super(name);
        this.type = ProductType.SUBSCRIPTION;
        this.setServices(services);
    }

    public List<Service> getServices() {
        return new ArrayList<>(this.services);
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
