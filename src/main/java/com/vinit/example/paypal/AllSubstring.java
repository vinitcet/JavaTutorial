package com.vinit.example.paypal;

public class AllSubstring {
    public static void main(String[] args) {
        String a = "vinit";
        //possibleSubstring(a);
        //permute(a, "");
        System.out.println(numSub("0110111"));
        System.out.println(stringCount("0110111"));
    }

    static void possibleSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    static public int numSub(String s) {
        if (!s.contains("1")) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                System.out.println(s.substring(i, j));
                if (!s.substring(i, j).contains("0")) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int stringCount(String str) {
        int answer = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count += 1;
            } else {
                answer += (1 + count) * count / 2;
                count = 0;
            }
        }
        if (count != 0) {
            answer += (1 + count) * count / 2;
        }

        return answer;
    }

    static void permute(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ls = s.substring(0, i);
            String rs = s.substring(i + 1);
            String res = ls + rs;
            permute(res, ans + ch);
        }

    }

    public int stringCount2(String str) {
        char[] c = str.toCharArray();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < c.length; i++) {

            if (c[i] == '1') {
                count++;
            } else {

                sum += count * (count + 1) / 2;
                count = 0;
            }
        }
        if (count > 0) {
            sum += count * (count + 1) / 2;
        }
        return sum;
    }

}
