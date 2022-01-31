package com.vinit.example.leet;

class TrieN {
    TrieN[] children;
    boolean isEnd;

    TrieN() {
        this.children = new TrieN[26];
        this.isEnd = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}


public class WordDictionary {

    private TrieN root;

    public WordDictionary() {
        this.root = new TrieN();
    }

    public void addWord(String word) {
        TrieN curr = this.root;

        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieN();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public static void printAllWordsInTrieN(TrieN root, String str) {
        TrieN current = root;
        if (current.children == null || current.children.length == 0)
            return;
        for (int i = 0; i < current.children.length; i++) {
            TrieN tr = current.children[i];
            printAllWordsInTrieN(tr, str);
            if (tr.isEnd == true) {
                System.out.print(" " + str);
                str = str.substring(0, str.length() - 1);
            } else {
                str = str.substring(0, str.length() - 1);
            }
        }
    }


    public boolean search(String word) {
        return search(word, this.root, 0);
    }

    //search the word from index onwards and the present node curr
    private boolean search(String word, TrieN curr, int index) {
        //loop from index to end of word
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                //find if there already exists a char which can substitute the dot
                for (int x = 0; x < 26; x++) {
                    if (curr.children[x] == null) continue;
                    //TrieNNode is a possible substitution for dot
                    TrieN TrieNNode = curr.children[x];
                    //explore the possibility with TrieNNode
                    if (search(word, TrieNNode, i + 1))
                        return true;
                }
                //if there is no char which can substitute the dot or match the pattern
                return false;
            } else {
                //if the char in word is not a dot, it should be there in TrieNNode else return false;
                if (curr.children[ch - 'a'] == null)
                    return false;
                curr = curr.children[ch - 'a'];
            }
        }
        return curr.isEnd;
    }

    public static void main(String[] args) {
        String[] str = {"WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search", "Vinit"};
        WordDictionary wd = new WordDictionary();
        for (String s : str) {
            wd.addWord(s);
        }
        printAllWordsInTrieN(wd.root, new String());

    }
}