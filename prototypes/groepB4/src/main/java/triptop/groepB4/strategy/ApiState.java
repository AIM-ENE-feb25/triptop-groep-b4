package triptop.groepB4.strategy;

import org.springframework.http.ResponseEntity;

public interface ApiState {
    ResponseEntity<String> execute(ApiGateway apiGateway, String url);
}
