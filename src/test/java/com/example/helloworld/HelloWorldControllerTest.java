package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloWorldTest() {
        // Realiza uma solicitação GET para o endpoint "/"
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

        // Verifica se o status da resposta é 200 (OK) e se o corpo da resposta é "Hello, World!"
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello, World!", response.getBody());
    }
}
