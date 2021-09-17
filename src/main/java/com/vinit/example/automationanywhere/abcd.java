package com.vinit.example.automationanywhere;

public class abcd {
    public static void main(String[] args) {
        //abcd -> abbcccddddddddcccbba
        String str = "abcd";
       /* StringBuffer sb = new StringBuffer();
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = -1; j < i; j++) {
                sb.append(a[i]);
            }
        }
        System.out.print(sb);
        System.out.print(sb.reverse());*/
        char[] a = str.toCharArray();
        for (int i = 1; i <= a.length; i++) {
            for (int j = 0; j < 2*i; j++) {
                System.out.print(a[i-1]);
            }
        }
    }
}
