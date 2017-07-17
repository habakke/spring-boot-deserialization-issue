package no.acme.dto.service;

import com.fasterxml.jackson.annotation.*;
import no.acme.domain.service.Service;
import no.acme.domain.service.ServiceType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Håvard Bakke
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LiveLinearServiceView.class, name = "LIVE"),
        @JsonSubTypes.Type(value = OnDemandServiceView.class, name = "ONDEMAND")
})
public abstract class ServiceView {

    public Long id;

    @Enumerated(EnumType.STRING)
    public ServiceType type;

    public String name;

    protected ServiceView() {
    }

    @JsonCreator
    public ServiceView(@JsonProperty("id")Long id, @JsonProperty("type")ServiceType type, @JsonProperty("name")String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public ServiceView(Service service) {
        this.id = service.getId();
        this.type = service.getType();
        this.name = service.getName();
    }
}
