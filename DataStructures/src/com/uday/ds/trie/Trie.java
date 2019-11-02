package com.uday.ds.trie;

public class Trie {

    TrieNode root;

    public Trie(TrieNode root){
        this.root = root;
    }


    public void insert(String word){

        if(null == this.root){
            this.root = new TrieNode();
        }
        TrieNode last = root;
        for(int i = 0; i < word.length(); i++ ){
            Character ch = word.charAt(i);
            last = last.children.computeIfAbsent(ch, c ->new TrieNode());
            /*TrieNode tn = last.children.get(ch);
            if(null == tn){
                tn = new TrieNode();
                last.children.put(ch,tn);
            }
            last = tn;*/
        }
        last.isEndofWord = true;
    }

    public boolean search(String word){
        if(null == this.root){
            return false;
        }
        TrieNode current = this.root;
        for(int i = 0; i < word.length(); i++ ){
            Character ch = word.charAt(i);
            current = current.children.get(ch);
            if(null == current){
                return false;
            }
        }
        return current.isEndofWord;
    }

    public static void main(String[] args){
        Trie trie = new Trie(new TrieNode());
        trie.insert("abcd");
        System.out.println(trie.search("abcd"));
    }
}
