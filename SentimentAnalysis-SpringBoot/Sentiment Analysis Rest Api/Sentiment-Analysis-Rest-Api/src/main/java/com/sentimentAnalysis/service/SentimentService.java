package com.sentimentAnalysis.service;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class SentimentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String PYTHON_API_URL = "http://localhost:5000/analyze";

    public String analyzeSentiment(String text) {
        // Create request payload
        Map<String, String> request = new HashMap<>();
        request.put("text", text);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                PYTHON_API_URL, HttpMethod.POST, entity, String.class
        );

        return response.getBody();
    }
}
