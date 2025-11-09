package edu.iuh.fit.se.fep1.services;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    private final RestTemplate rest = new RestTemplate();
    // ✅ Gửi GET request
    public ResponseEntity<String> get(String url) {
        System.out.println("🌐 [GET] " + url);
        return rest.exchange(url, HttpMethod.GET, null, String.class);
    }
    // ✅ Gửi POST request
    public <B> ResponseEntity<String> post(String url, B body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<B> entity = new HttpEntity<>(body, headers);

        System.out.println("🟢 [POST] " + url);
        return rest.exchange(url, HttpMethod.POST, entity, String.class);
    }
    // ✅ Gửi PUT request
    public <B> ResponseEntity<String> put(String url, B body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<B> entity = new HttpEntity<>(body, headers);

        System.out.println("🟡 [PUT] " + url);
        return rest.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    // ✅ Gửi DELETE request
    public ResponseEntity<String> delete(String url) {
        System.out.println("🔴 [DELETE] " + url);
        return rest.exchange(url, HttpMethod.DELETE, null, String.class);
    }
}
