package com.vinit.example.cvent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        //n >=3 and n<100000
        //k=1<n-1
        //each element 0---1000000000


        int A[] = {8, 8, 4, 3};
        int k = 2;
        System.out.println(solution(A, k));
    }

    public static int solution(int[] A, int K) {
        if (A.length < 2 || A.length > 100000) {
            return -1;
        }
        if (K <= 0 || K > A.length - 1) {
            return -1;
        }
        for (int i : A) {
            if (i < 0 || i > 1000000000) {
                return -1;
            }
        }

        List<Integer> newList = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList());
        newList.addAll(newList);
        int n = A.length;
        int res = Integer.MAX_VALUE;
        for (int start = K; start <= n; start++) {
            int m = n - K;
            //get the min and max after ignoring particular k consecutive elements
            int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
            //int mx = Integer.MAX_VALUE, mn = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                int idx = start + j;
                mn = Math.min(mn, newList.get(idx));
                mx = Math.max(mx, newList.get(idx));
            }
            //res will contain the smallest of all possible values..
            res = Math.min(res, mx - mn);
        }
        return res;
    }
}
