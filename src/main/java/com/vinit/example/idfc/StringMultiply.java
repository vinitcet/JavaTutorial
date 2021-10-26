package com.vinit.example.idfc;

public class StringMultiply {

    public static void main(String[] args) {
        String a = "24";
        String b = "5";
        System.out.println(numericRepresentation(a) * numericRepresentation(b));
    }

    static int numericRepresentation(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 10 + s.charAt(i) - 48;
        }
        return result;
    }
}
