package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloWorldTest() {
        // Realiza uma solicitação GET para o endpoint "/"
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

        // Verifica se o status da resposta é 200 (OK) e se o corpo da resposta é "Hello, World!"
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hello, World!", response.getBody());
    }
}
