package no.acme.dto.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.acme.domain.service.LiveService;
import no.acme.domain.service.ServiceType;

/**
 * Created by Håvard Bakke
 */
public class LiveLinearServiceView extends ServiceView {

    public String logoURL;

    protected LiveLinearServiceView() {
        super();
    }

    @JsonCreator
    public LiveLinearServiceView(@JsonProperty("id")Long id, @JsonProperty("type")ServiceType type, @JsonProperty("name")String name, @JsonProperty("logoURL")String logoURL) {
        super(id, type, name);
        this.logoURL = logoURL;
    }

    public LiveLinearServiceView(LiveService service) {
        super(service);
        this.logoURL = service.getLogoURL().toString();
    }
}
