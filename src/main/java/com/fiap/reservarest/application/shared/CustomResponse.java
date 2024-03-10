package com.fiap.reservarest.application.shared;

public class CustomResponse<T> {
    private T data;

    public T getData() {
        return data;
    }

    public CustomResponse<T> setData(T data) {
        this.data = data;
        return this;
    }
}
