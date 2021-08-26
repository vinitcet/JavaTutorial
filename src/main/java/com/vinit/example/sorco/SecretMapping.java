package com.vinit.example.sorco;

public class SecretMapping {
    public static void main(String[] args) {
        String[] st = {"b", "b", "d", "d", "f", "f", "f", "h", "j", "j", "l", "l", "n", "n", "p", "p", "r", "r", "t", "t", "v", "v", "x", "x", "z", "z"};
        String[] str = {"food", "good", "zap", "yap"};
        count(str, st);
    }

    static void count(String[] str, String[] st) {
        for (int i = 0; i < str.length; i++) {
            String word = str[i];
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < word.length(); j++) {
                int characterNumber = Integer.valueOf(word.charAt(j)) - 97;
                sb.append(String.valueOf(st[characterNumber]));
            }
            System.out.println(sb);
        }
    }
}
