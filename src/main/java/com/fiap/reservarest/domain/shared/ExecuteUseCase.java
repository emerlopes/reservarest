package com.fiap.reservarest.domain.shared;

public interface ExecuteUseCase<T, J> {
    T execute(J j);
}
