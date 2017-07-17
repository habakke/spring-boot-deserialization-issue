package no.acme.domain.service;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.net.URL;

@Entity
@DiscriminatorValue("LIVE")
public class LiveService extends Service {

    @NotNull
    private URL logoURL;

    private LiveService() {
        super();
    }

    public LiveService(String name, URL logoURL) {
        super(name, ServiceType.LIVE);
        this.logoURL = logoURL;
    }

    public URL getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(URL logoURL) {
        this.logoURL = logoURL;
    }

}
