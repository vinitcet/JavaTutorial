package com.vinit.example.morganstanley;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class Main {


    public static void main(String[] args) {
        B b = new B();
        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
        System.out.println(b instanceof C);
    }
}

class base {
    final public void show() {
        System.out.println("Base Show");
    }
}

class derived extends base {
    /* public void show() {
        System.out.println("derived Show");
    }*/
}

class A{}
class B extends A{}
class C extends  B{}