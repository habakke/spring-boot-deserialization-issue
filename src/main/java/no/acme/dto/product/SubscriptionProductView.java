package no.acme.dto.product;

import no.acme.domain.service.Service;
import no.acme.domain.product.SubscriptionProduct;
import no.acme.domain.service.LiveService;
import no.acme.domain.service.OnDemandService;
import no.acme.dto.service.LiveLinearServiceView;
import no.acme.dto.service.OnDemandServiceView;
import no.acme.dto.service.ServiceView;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionProductView extends ProductView {

    public List<ServiceView> services;

    protected SubscriptionProductView() {
        super();
    }

    public SubscriptionProductView(SubscriptionProduct product) {
        super(product);
        this.setServices(product.getServices());
    }

    public void setServices(List<Service> services) {
        this.services = new ArrayList<>();
        for (Service service : services) {
            switch (service.getType()) {
                case ONDEMAND:
                    this.services.add(new OnDemandServiceView((OnDemandService)service));
                    break;
                case LIVE:
                    this.services.add(new LiveLinearServiceView((LiveService)service));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown service type: " + service.getType());
            }
        }
    }
}
