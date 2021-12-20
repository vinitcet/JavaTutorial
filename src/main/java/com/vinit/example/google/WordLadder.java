/*
package com.vinit.example.google;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static int ladderLength2(String beginWord, String endWord, List<String> dict) {
        // write your code here
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (dict.size() == 0) {
            return 0;
        }

        int change = 0;
        dict.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            change++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return change;
                }
                List<String> next = findNextAndRemove(current, dict);
                for (String n : next) {
                    if (n.equals(endWord)) {
                        return change + 1;
                    }
                    queue.offer(n);
                }
            }
        }
        return change;
    }
    
    public static List<String> findNextAndRemove(String a, Set<String> dict) {
        List<String> next = new ArrayList<>();

        for (String d : dict) {
            int diff = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == d.charAt(i)) {
                    continue;
                }
                diff++;
            }
            if (diff == 1) {
                next.add(d);
            }
        }
        dict.removeAll(next); 
        return next;
    }
}
*/
