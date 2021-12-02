package com.vinit.example.google;

public class Test {

    public static void main(String[] args) {
        System.out.println(fib(100,2000));
        System.out.println(100%2000);
    }

    static int fib(int a, int b) {
if(b==0){
    return a;
}
      return fib(b,a%b);
    }

}




