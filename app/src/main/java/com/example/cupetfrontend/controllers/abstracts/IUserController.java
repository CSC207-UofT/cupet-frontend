package com.example.cupetfrontend.controllers.abstracts;

public interface IUserController {
    void createUser(String firstName, String lastName, String homeAddress, String password, String email);
}
