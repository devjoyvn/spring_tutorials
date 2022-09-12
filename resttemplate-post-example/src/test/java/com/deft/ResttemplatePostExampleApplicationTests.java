package com.deft;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResttemplatePostExampleApplicationTests {


    private RestTemplate restTemplate;

    private HttpHeaders headers;

    private JSONObject personJsonObject;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private String createPersonUrl;


    @BeforeAll
    void setup() {
        createPersonUrl = "http://localhost:8080/person";
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        personJsonObject.put("id", 1);
        personJsonObject.put("name", "John");
    }


    @Test
    void postForObjectTest()
            throws IOException {
        HttpEntity<String> request = new HttpEntity<>(personJsonObject.toString(), headers);

        String personResultAsJsonStr =
                restTemplate.postForObject(createPersonUrl, request, String.class);
        JsonNode root = objectMapper.readTree(personResultAsJsonStr);

        assertNotNull(personResultAsJsonStr);
        assertNotNull(root);
        assertNotNull(root.path("name").asText());
    }

    @Test
    void postForEntityTest()
            throws IOException {
        HttpEntity<String> request =
                new HttpEntity<>(personJsonObject.toString(), headers);

        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity(createPersonUrl, request, String.class);
        JsonNode root = objectMapper.readTree(responseEntityStr.getBody());

        assertNotNull(responseEntityStr.getBody());
        assertNotNull(root.path("name").asText());
    }

    @Test
    void postForLocationTest() {
        HttpEntity<String> request = new HttpEntity<>(personJsonObject.toString(), headers);
        URI locationHeader = restTemplate.postForLocation(createPersonUrl, request);

        assertNotNull(locationHeader);
    }

}
