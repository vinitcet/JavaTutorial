package com.vinit.example.leet;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int myTry(String s) {
        Integer[] chars = new Integer[128];
        int l = 0;
        int r = 0;
        int res = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (r < s.length()) {
            Integer index = mp.get(s.charAt(r));
            if (index != null && index >= l && index < r) {
                l = mp.get(s.charAt(r)) + 1;
            }

            mp.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

    public int lengthOfLongestSubstringFaster(String s) {
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }
}
