package no.acme.domain.service;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ONDEMAND_SERVICE")
public class OnDemandService extends Service {

    private OnDemandService() {
        super();
    }

}
