package com.vinit.example.opentext;

public class Test {
    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(solution(a));
    }

    static int solution(int[] A) {
        if (A.length < 1 || A.length > 100) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            if (!(A[i] == 0 || A[i] == 1)) {
                return 0;
            }
        }
        return Math.min(flipsRequired(A, 0),
                flipsRequired(A, 1));
    }

    public static int flip(int n) {
        return (n == 0) ? 1 : 0;
    }

    public static int flipsRequired(int[] A, int num) {
        int flipCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != num)
                flipCount++;
            num = flip(num);
        }
        return flipCount;
    }
}
