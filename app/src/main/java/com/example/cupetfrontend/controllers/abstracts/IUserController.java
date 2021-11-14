package com.example.cupetfrontend.controllers.abstracts;

public interface IUserController {
    void createUser(String firstName, String lastName, String email, String password, String homeAddress);
}
