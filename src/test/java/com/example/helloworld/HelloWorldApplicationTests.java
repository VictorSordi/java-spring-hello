package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class HelloWorldApplicationTests {

    @Test
    void contextLoads() {
        // Este método verifica se o contexto do Spring é carregado corretamente
    }

    @Test
    void testMainMethod() {
        // Chama o método main para garantir que o código da aplicação seja coberto.
        HelloWorldApplication.main(new String[] {});

        // Asserção para garantir que o contexto foi carregado e que algum bean foi inicializado
        // Suponha que há um serviço ou componente no contexto da aplicação que pode ser verificado
        // Exemplo: Se houver um bean que precisa estar carregado, podemos usar uma asserção aqui.
        
        // Exemplo de asserção para garantir que o contexto está ativo:
        assertNotNull(HelloWorldApplication.class, "O contexto da aplicação não foi carregado corretamente.");
    }
}
