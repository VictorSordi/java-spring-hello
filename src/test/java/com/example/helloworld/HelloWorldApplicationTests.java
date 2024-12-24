package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class HelloWorldApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMainMethod() {
        // Chama o método main diretamente para garantir que o código seja coberto
        HelloWorldApplication.main(new String[] {});
    }
}