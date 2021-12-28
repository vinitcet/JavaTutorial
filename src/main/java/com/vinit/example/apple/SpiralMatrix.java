package com.vinit.example.apple;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printSpiral(a, 0, 0, 4, 4);
    }

    static void printSpiral(int[][] arr, int h, int v, int r, int c) {
        if (h >= r || v >= c) {
            return;
        }
        for (int i = h; i < c; ++i) {
            System.out.print(arr[h][i] + " ");
        }
        for (int i = h + 1; i < r; i++) {
            System.out.print(arr[i][c - 1] + " ");
        }
        // Print Last Row, if Last and First Row are not same
        if (h != (r - 1)) {
            for (int i = c - 2; i >= v; i--) {
                System.out.print(arr[r - 1][i] + " ");
            }
        }
        // Print First Column, if Last and First Column are not same
        if (c - 1 != v) {
            for (int i = r - 2; i >= h + 1; i--) {
                System.out.print(arr[i][v] + " ");
            }
        }
        printSpiral(arr, h + 1, v + 1, r - 1, c - 1);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int i = 0, j = 0;
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (j = left; j <= right && up <= down; j++) {
                result.add(matrix[up][j]);
            }
            up++;

            for (i = up; i <= down && left <= right; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            for (j = right; j >= left && up <= down; j--) {
                result.add(matrix[down][j]);
            }
            down--;

            for (i = down; i >= up && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
