package com.enfocat.audiolibro.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}