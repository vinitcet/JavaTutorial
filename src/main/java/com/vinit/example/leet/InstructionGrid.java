package com.vinit.example.leet;

import java.util.Arrays;

public class InstructionGrid {
    public static void main(String[] args) {
        int n = 3;
        int[] startPos = {0, 1};
        String s = "RRDDLU";
        int[] op = executeInstructions(n, startPos, s);
        Arrays.stream(op).forEach(System.out::println);
    }

    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int[] op = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int x = startPos[0];
            int y = startPos[1];
            int mov = 0;
            for (char c : s.substring(i).toCharArray()) {
                switch (c) {
                    case 'L':
                        y--;
                        break;
                    case 'R':
                        y++;
                        break;
                    case 'U':
                        x--;
                        break;
                    case 'D':
                        x++;
                        break;
                }
                if (x >= n || y >= n || x < 0 || y < 0) {
                    op[i] = mov;
                    break;
                }
                mov++;
            }
            op[i] = mov;
        }
        return op;
    }
}
