package no.acme.dto.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.acme.domain.service.ServiceType;
import no.acme.domain.service.OnDemandService;

/**
 * Created by Håvard Bakke
 */
public class OnDemandServiceView extends ServiceView {

    protected OnDemandServiceView() {
        super();
    }

    @JsonCreator
    public OnDemandServiceView(@JsonProperty("id")Long id, @JsonProperty("type")ServiceType type, @JsonProperty("name")String name) {
        super(id, type, name);
    }

    public OnDemandServiceView(OnDemandService service) {
        super(service);
    }
}
