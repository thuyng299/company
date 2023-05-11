package com.example.demo.entity;

public enum Gender {
    OTHERS(-1),
    FEMALE(0),
    MALE(1);

    private int value;
    Gender(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
