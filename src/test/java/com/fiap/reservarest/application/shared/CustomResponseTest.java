package com.fiap.reservarest.application.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class CustomResponseTest {

    private CustomResponse<Object> customResponse;

    @BeforeEach
    void setUp() {
        customResponse = new CustomResponse<>();
    }

    @Test
    void shouldReturnNullWhenDataIsNotSet() {
        assertNull(customResponse.getData());
    }

    @Test
    void shouldReturnDataWhenDataSet() {
        Object data = new Object();
        customResponse.setData(data);
        assertSame(data, customResponse.getData());
    }

    @Test
    void shouldReturnSameInstanceWhenDataSet() {
        assertSame(customResponse, customResponse.setData(new Object()));
    }
}