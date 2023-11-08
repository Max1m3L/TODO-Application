package com.maxlvshv.todoapp.exeptions;

public class TheSameTodoAlreadyExistExeption extends Exception{
    public TheSameTodoAlreadyExistExeption(String message) {
        super(message);
    }
}
