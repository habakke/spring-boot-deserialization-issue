package no.acme.domain.service;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name="SERVICES", indexes = {@Index(name="SERVICE_ID_INDEX", columnList="id")})
public abstract class Service {

    protected @Version Long version;
    protected @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    protected ServiceType type;

    @NotNull
    @Column(unique = true)
    protected String name;

    protected Service() {

    }

    public Service(String name, ServiceType type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
