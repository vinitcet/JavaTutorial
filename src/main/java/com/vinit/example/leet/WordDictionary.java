package com.vinit.example.leet;

class Trie {
    Trie[] children;
    boolean isEnd;

    Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }
}

class WordDictionary {

    private Trie root;

    public WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = this.root;

        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Trie();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, this.root, 0);
    }

    //search the word from index onwards and the present node curr
    private boolean search(String word, Trie curr, int index) {
        //loop from index to end of word
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                //find if there already exists a char which can substitute the dot
                for (int x = 0; x < 26; x++) {
                    if (curr.children[x] == null) continue;
                    //trieNode is a possible substitution for dot
                    Trie trieNode = curr.children[x];
                    //explore the possibility with trieNode
                    if (search(word, trieNode, i + 1))
                        return true;
                }
                //if there is no char which can substitute the dot or match the pattern
                return false;
            } else {
                //if the char in word is not a dot, it should be there in trieNode else return false;
                if (curr.children[ch - 'a'] == null)
                    return false;
                curr = curr.children[ch - 'a'];
            }
        }
        return curr.isEnd;
    }
}