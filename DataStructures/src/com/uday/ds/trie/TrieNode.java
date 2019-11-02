package com.uday.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<Character,TrieNode> children;

    boolean isEndofWord;

    public TrieNode(){
        isEndofWord = false;
        children = new HashMap<>();
    }
}
