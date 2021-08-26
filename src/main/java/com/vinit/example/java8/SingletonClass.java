package com.vinit.example.java8;

import java.io.Serializable;

public class SingletonClass implements Serializable {

    private static SingletonClass instance = null;

    private SingletonClass() {

    }


    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                return new SingletonClass();
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return getInstance();
    }

}
