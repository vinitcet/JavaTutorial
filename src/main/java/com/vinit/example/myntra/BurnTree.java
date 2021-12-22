package com.vinit.example.myntra;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */

class Dis {
    int dis;

    Dis(int dis) {
        this.dis = dis;
    }
}

public class BurnTree {
    static int result = -1;

    public static int burnTree(TreeNode A, int B, Dis dis) {
        if (A == null)
            return 0;
        if (B == A.val) {
            dis.dis = 0;
            return 1;
        }
        Dis ldis = new Dis(-1), rdis = new Dis(-1);
        int lh = burnTree(A.left, B, ldis);
        int rh = burnTree(A.right, B, rdis);
        if (ldis.dis != -1) {
            dis.dis = ldis.dis + 1;
            result = (result > dis.dis + rh) ? result : dis.dis + rh;
        } else if (rdis.dis != -1) {
            dis.dis = rdis.dis + 1;
            result = (result > dis.dis + lh) ? result : dis.dis + lh;
        }
        return (lh > rh) ? lh + 1 : rh + 1;
    }


    public int solve(TreeNode A, int B) {
        result = 0;
        burnTree(A, B, new Dis(-1));
        return result;

    }
}
