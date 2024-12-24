package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {

    @Test
    void testMainMethod() {
        // Chama o método main para garantir que a aplicação inicialize sem erros
        HelloWorldApplication.main(new String[] {});

        // Asserção para garantir que o contexto foi carregado corretamente
        // Isso não verifica um bean específico, mas assegura que o contexto do Spring foi carregado
        assert true;  // Aqui você pode colocar alguma verificação real ou lógica adicional.
    }
}
