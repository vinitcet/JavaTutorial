package com.vinit.example.paloalto;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
*/

public class NQueen {
    public static void main(String[] args) {
        List<List<String>> ls = solveNQueens(4);
        for (List<String> l : ls) {
            l.stream().forEach(System.out::println);
            System.out.println("**************");
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        dfs(n, new boolean[n + 1], new ArrayList<>(), results);
        return results;
    }

    private static void dfs(int n, boolean[] visited, List<Integer> subset, List<List<String>> results) {
        if (subset.size() == n) {
            results.add(makeBoard(subset));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (!isValid(i, subset)) {
                continue;
            }
            visited[i] = true;
            subset.add(i);
            dfs(n, visited, subset, results);
            subset.remove(subset.size() - 1);
            visited[i] = false;
        }
    }

    private static List<String> makeBoard(List<Integer> subset) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < subset.size(); i++) {
            sb.append(".");
        }

        for (int i = 0; i < subset.size(); i++) {
            int pos = subset.get(i);
            sb.replace(pos - 1, pos, "Q");
            board.add(sb.toString());
            sb.replace(pos - 1, pos, ".");
        }

        return board;
    }

    private static boolean isValid(int n, List<Integer> subset) {
        int pos = subset.size();
        for (int i = 0; i < subset.size(); i++) {
            if (Math.abs(pos - i) == Math.abs(n - subset.get(i))) {
                return false;
            }
        }

        return true;
    }
}
