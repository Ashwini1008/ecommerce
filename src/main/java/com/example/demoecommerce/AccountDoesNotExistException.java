package com.example.demoecommerce;

public class AccountDoesNotExistException extends RuntimeException{
    public AccountDoesNotExistException(String message){
        super(message);
    }
}
