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


    }

    public void insertIntoTrie(String s) {
        if (s.length() == 0) {
            System.out.println("String is Empty");
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode node = root.children.get(c);
            if (node == null) {
                TrieNode newNode = new TrieNode();
                root.children.put(c, newNode);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public boolean searchInTrie(String s) {
        return searchRecursive(root, s, 0);

    }

    public boolean searchRecursive(TrieNode current, String s, int index) {
        if (index == s.length()) {
            return current.endOfWord;
        }
        char c = s.charAt(index);
        TrieNode node = current.children.get(c);
        if (!node.children.containsKey(c)) {
            return false;
        }
        return searchRecursive(node, s, index + 1);
    }

    public boolean deleteFromTrie(String s) {
        return deleteRecursive(root, s, 0);
    }

    public boolean deleteRecursive(TrieNode current, String s, int index) {
        if (index == s.length()) {
            if (!current.endOfWord) {
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
