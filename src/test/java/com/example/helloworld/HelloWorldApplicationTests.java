package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {

    @Test
    void testMainMethod() {
        // Chama o método main para garantir que a aplicação inicialize sem erros
        HelloWorldApplication.main(new String[] {});

        // Asserção de teste: apenas garantindo que a aplicação não falhe ao iniciar
        assert true; // Adiciona uma asserção válida aqui, caso necessário
    }
}
