package com.example.helloworld;

import org.junit.jupiter.api.Test;

class HelloWorldApplicationTests {

    @Test
    void testMainMethod() {
        // Chama o método main para garantir que a aplicação inicialize sem erros
        HelloWorldApplication.main(new String[] {});

        // Se o Spring Boot iniciar corretamente, o teste não falhará. Para uma verificação mais explícita,
        // você pode adicionar alguma lógica aqui, como verificar a presença de um bean específico no contexto.
        // No caso, estamos assumindo que o método main iniciou o contexto do Spring corretamente.
    }
}
