package no.acme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import no.acme.domain.product.SubscriptionProduct;
import no.acme.domain.service.LiveService;
import no.acme.domain.service.Service;

import no.acme.dto.product.SubscriptionProductView;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerializationTest {

    private static final Logger log = LoggerFactory.getLogger(SerializationTest.class);

    @Before
    public void setup() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void testSerializeAndDeserializeSubscriptionProduct() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.registerModule(new JavaTimeModule());

        LiveService service = new LiveService("Test Service", new URL("http://localhost:8080/test.png"));
        List<Service> services = new ArrayList<>();
        services.add(service);
        SubscriptionProduct product = new SubscriptionProduct("Test Product");
        product.setServices(services);

        SubscriptionProductView productView = new SubscriptionProductView(product);

        String jsonString = mapper.writeValueAsString(productView);
        log.info(jsonString);

        SubscriptionProductView mappedProductView = mapper.readValue(jsonString, SubscriptionProductView.class);
        Assert.assertEquals("Test Product", mappedProductView.name);
        Assert.assertEquals(1, mappedProductView.services.size());
    }
}