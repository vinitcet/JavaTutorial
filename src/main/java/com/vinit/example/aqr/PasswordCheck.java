package com.vinit.example.aqr;

public class PasswordCheck {

    //abc good
    //xxx bad
    //axyxybxy good
    //ab xyz xyz xyzc bad


    public static void main(String[] args) {
        // System.out.println(validatePassword("abc"));
        // System.out.println(validatePassword("xxx"));
        System.out.println(validatePassword("axyxybxy"));
        System.out.println(validatePassword("abxyzxyzxyzc"));

    }

    public static boolean validatePassword(String password) {
        for (int i = 1; i < password.length() / 3 + 1; i++) {
            if (!validatePassword(password, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validatePassword(String password, int compare) {
        int passLen = password.length();
        for (int i = 0; i < password.length() - 3 * compare + 1; i++) {
            if (password.substring(i, i + compare).equalsIgnoreCase(password.substring(i + compare, i + 2 * compare)) &&
                    password.substring(i + compare, i + 2 * compare).equalsIgnoreCase(password.substring(i + compare, i + 3 * compare))) {
                return false;
            }
        }
        return true;
    }

}

