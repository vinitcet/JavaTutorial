package com.vinit.example.paloalto;

public class GeneratePalindrome {
    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }

    public static String solution(int N, int K) {
        if (N < 2 || N > 200 || K < 1 || K > 26 || N < K) {
            return "";
        }
        String res = "";
        for (int i = 0; i < K; i++)
            res = res + (char) ('a' + i);
        char[] str = new char[N];
        int count = 0;
        for (int i = 0; i < N / 2; i++) {
            str[i] = res.charAt(count);
            str[N - 1 - i] = res.charAt(count);
            count++;
            if (count == K)
                count = 0;
        }
        if (N % 2 != 0) {
            str[N / 2] = res.charAt(count);
        }
        return String.valueOf(str);
    }
}
