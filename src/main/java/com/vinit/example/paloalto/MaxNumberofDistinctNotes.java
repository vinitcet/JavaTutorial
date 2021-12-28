package com.vinit.example.paloalto;

import java.util.HashSet;
import java.util.Set;

public class MaxNumberofDistinctNotes {

    public int solution(Tree T) {
       return traverse(T,new HashSet<Integer>());
    }

    private  int traverse(Tree root, Set<Integer> mSet) {
        if (root == null || mSet.contains(root.x)) {
            return mSet.size();
        }
        mSet.add(root.x);
        int le = traverse(root.l, mSet);
        int ri = traverse(root.r, mSet);
        mSet.remove(root.x);
        return Math.max(le, ri);
    }
}

class Tree{
    public int x;
    public Tree l;
    public Tree r;
}
