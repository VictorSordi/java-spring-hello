package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class HelloWorldApplicationTests {

    @Test
    public void main() {
        HelloWorldApplication.main(new String[] {});
   }
}
