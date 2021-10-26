package com.vinit.example.vonage;

public interface Test {

    public static void main(String[] args) {
        System.out.println(getDuplicate("Bccdz"));
    }

    static String getDuplicate(String S) {
        if (S.length() < 2 || S.length() > 27) {
            return "";
        }
        for (int i = 0; i < S.length(); i++) {
            if (Character.isUpperCase(S.charAt(i))) {
                return "";
            }
        }
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j < S.length(); j++) {
                if (S.charAt(i) == S.charAt(j)) {
                    return String.valueOf(S.charAt(i));
                }
            }
        }
        return "";
    }
}

/*
for(int i=0; i < charArray.length; i++){

        //if any character is not in upper case, return false
        if( !Character.isUpperCase( charArray[i] ))
        return false;
        }*/
