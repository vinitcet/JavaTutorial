package com.vinit.example.sorco;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        String[][] pairs = {{"great", "good"}, {"fine", "good"}, {"acting", "drama"}, {"skills", "talent"}};
        System.out.println(new Solution().areSentencesSimilarTwo(words1, words2, pairs));
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        UnionFind uf = new UnionFind(2 * pairs.length);

        Map<String, Integer> map = new HashMap<>();
        int id = 0;

        for (String[] pair : pairs) {
            for (String word : pair) {
                if (!map.containsKey(word)) {
                    map.put(word, id);
                    ++id;
                }
            }

            uf.union(map.get(pair[0]), map.get(pair[1]));
        }

        System.out.println(map);
        System.out.println(uf.count);
        for (int sz : uf.size) {
            System.out.print(sz + " ");
        }
        System.out.println();
        for (int st : uf.sets) {
            System.out.print(st + " ");
        }
        System.out.println();
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];

            if (word1.equals(word2)) {
                continue;
            }

            if (!map.containsKey(word1) || !map.containsKey(word2) || uf.find(map.get(word1)) != uf.find(map.get(word2))) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        int[] sets;
        int[] size;
        int count;

        public UnionFind(int n) {
            sets = new int[n];
            size = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                sets[i] = i;
                size[i] = 1;
            }
        }

        public int find(int node) {
            while (node != sets[node]) {
                node = sets[node];
            }
            return node;
        }

        public void union(int i, int j) {
            int node1 = find(i);
            int node2 = find(j);

            if (node1 == node2) {
                return;
            }

            if (size[node1] < size[node2]) {
                sets[node1] = node2;
                size[node2] += size[node1];
            } else {
                sets[node2] = node1;
                size[node1] += size[node2];
            }
            --count;
        }
    }
}