package com.vinit.example.paypal;

import java.util.LinkedList;
import java.util.Queue;

public class ShortedPathBinarymatrixSolution {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(arr));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int row = grid.length;
        int colum = grid[0].length;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer[] point = queue.poll();
                //point[0]-row point[1]-column  point[2]-value/visited
                if (point[0] == row - 1 && point[1] == colum - 1) {
                    return point[2]; //reached destination
                }
                for (int[] d : dir) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];
                    if (r >= 0 && c >= 0 && r < row && c < colum && grid[r][c] == 0) {
                        queue.add(new Integer[]{r, c, point[2] + 1});
                        grid[r][c] = 1;
                    }
                }
            }
        }
         return -1;
    }
}
