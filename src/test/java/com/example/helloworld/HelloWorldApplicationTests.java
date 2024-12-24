package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {

    @Autowired
    private HelloWorldController helloWorldController;  // Supondo que você tenha um controller

    @Test
    void testMainMethod() {
        // Chama o método main para garantir que a aplicação inicialize sem erros
        HelloWorldApplication.main(new String[] {});

        // Verifica se o controller foi inicializado corretamente
        // Caso contrário, o Spring Boot não terá carregado corretamente o contexto
        assertNotNull(helloWorldController, "O controller não foi inicializado corretamente.");
    }
}
