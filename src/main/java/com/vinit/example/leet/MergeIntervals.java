package com.vinit.example.leet;

import java.util.Arrays;
import java.util.LinkedList;

/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
        and return an array of the non-overlapping intervals that cover all the intervals in the input.*/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{8, 10}, {15, 18}, {1, 3}, {2, 6}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.stream(intervals).forEach(s -> Arrays.stream(s).forEach(System.out::println));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
