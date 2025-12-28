package com.example.demo.service;

public interface AuthService {

    void register(String username, String password);

    void login(String username, String password);
}
