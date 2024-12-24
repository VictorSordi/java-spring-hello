import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

class YourTestClass {

    @Test
    private void testGetRequest() {
        // Cria uma instância do RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Realiza uma solicitação GET para o endpoint "/"
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

        // Verifica se o status da resposta é 200 (OK) e se o corpo da resposta é "Hello, World!"
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello, World!", response.getBody());
    }
}
