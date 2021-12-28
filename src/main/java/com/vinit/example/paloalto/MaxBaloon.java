package com.vinit.example.paloalto;

public class MaxBaloon {
    public static void main(String args[]) {
        String text = "blloona";
        System.out.println(maxNumberOfBalloons(text));
    }

    static int maxNumberOfBalloons(String S) {
        if(S.length()<7){
            return 0;
        }
        int B = 0, A = 0, L = 0, O = 0, N = 0;
        char chr;
        for (int i = 0; i < S.length(); i++) {
            chr = S.charAt(i);
            switch (chr) {
                case 'B':
                    B++;
                    break;
                case 'A':
                    A++;
                    break;
                case 'L':
                    L++;
                    break;
                case 'O':
                    O++;
                    break;
                case 'N':
                    N++;
                    break;
                default:
                    break;
            }
        }
        L /= 2;
        O /= 2;
        return Math.min(B, Math.min(A, Math.min(L, Math.min(O, N))));
    }
}
