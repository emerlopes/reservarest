package com.fiap.reservarest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ReservarestApplication.class)
class ReservarestApplicationTests {

    @MockBean
    private ApplicationContext context;

    @Test
    void shouldLoadApplicationContext() {
        assertNotNull(context);
    }
}