package com.vinit.example.goldman;

import java.util.ArrayList;
import java.util.List;

public class Islands {

    public static void main(String[] args) {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        Islands I = new Islands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }

    public int countIslands(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        int count = 0;
        List<String> visited = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
                if (a[i][j] == 1 && !visited.contains("" + i + "" + j)) {
                    count++;
                    visited = updateVisited(a, i, j, visited);
                }
            }
            System.out.println();
        }
        visited.stream().forEach(System.out::println);
        return count;
    }

    public List<String> updateVisited(int[][] a, int row, int column, List<String> visited) {
        //adjacent locations
        //-1,-1   -1,0   -1,1
        //0,-1     0,0   0,1
        //1,-1     1,0    1,1
        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int j = 0; j < 8; j++) {
            int r = row + x[j];
            int c = column + y[j];
            if (r >= 0 && r < a.length && c >= 0 && c < a[0].length && a[r][c] == 1 && !visited.contains("" + r + "" + c)) {
                //
                visited.add("" + r + "" + c);
                //updated next for visited
                updateVisited(a, r, c, visited);
            }
        }
        return visited;
    }
}
