package com.vinit.example.microsoft;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k];
        int a=0;
        Deque<Integer> qmax = new LinkedList<Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(!qmax.isEmpty() && nums[i] > nums[qmax.getLast()])
                qmax.removeLast();
            if(!qmax.isEmpty() && i - qmax.getFirst() >= k)
                qmax.removeFirst();

            qmax.addLast(i);

            if(i >= k - 1) {
                ans[a++]=nums[qmax.getFirst()];
            }
        }
        return ans;

    }
}
