/**
 * Created by Nikhil on 9/27/16.
 */

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        TrieNode() {
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {

        Trie obj = new Trie();
        obj.insertIntoTrie("actor");
        obj.insertIntoTrie("abcd");
        obj.insertIntoTrie("ball");
        obj.searchInTrie("ball");
        obj.deleteFromTrie("ball");
        obj.searchInTrie("ball");
    }

    public void insertIntoTrie(String s) {
        if (s.length() == 0) {
            System.out.println("String is Empty");
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node ;
        }
        current.endOfWord = true;
        System.out.println(s + " has been successfully inserted in Trie");
    }

    public void searchInTrie(String s) {
        boolean searchResult = searchRecursive(root, s, 0);
        if (searchResult) {
            System.out.println(s + " has been found and exist in Trie");
        } else {
            System.out.println(s + " does not exist in Trie");
        }

    }

    public boolean searchRecursive(TrieNode current, String s, int index) {
        if (index == s.length()) {
            return current.endOfWord;
        }
        char c = s.charAt(index);
        TrieNode node = current.children.get(c);
        if (node==null) {
            return false;
        }
        return searchRecursive(node, s, index + 1);
    }

    public void deleteFromTrie(String s) {
        boolean status = deleteRecursive(root, s, 0);
        System.out.println(s + " has been successfully deleted from Trie");

    }

    public boolean deleteRecursive(TrieNode current, String s, int index) {
        if (index == s.length()) {
            if (!current.endOfWord) {
                System.out.println("Incorrect Word");
                return false;
            }
            current.endOfWord = false;
            return current.children.size() == 0;
        }
        char c = s.charAt(index);
        TrieNode node = current.children.get(c);

        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = deleteRecursive(node, s, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(c);
            return current.children.size() == 0;
        }
        return false;
    }
}
