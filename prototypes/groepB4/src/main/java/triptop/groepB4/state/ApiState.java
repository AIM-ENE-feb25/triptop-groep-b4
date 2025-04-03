package triptop.groepB4.state;

import org.springframework.http.ResponseEntity;
import triptop.groepB4.service.ApiGateway;

public interface ApiState {
    ResponseEntity<String> execute(ApiGateway apiGateway, String url);
}
