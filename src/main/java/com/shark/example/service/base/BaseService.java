package com.shark.example.service.base;

public abstract class BaseService<Input, Output> {
    public abstract Output start(Input input);
}
