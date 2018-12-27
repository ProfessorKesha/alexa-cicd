package com.keysoft.alex.alexacicd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlexaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void message() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/message", String.class);

        int status = responseEntity.getStatusCodeValue();
        String message = responseEntity.getBody();

        assertEquals(status, HttpStatus.OK.value());
        assertEquals(message, "Hello World");
    }
}