package com.gb.bytebybyteproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gbalasubramanian on 28/08/17.
 */
public class AutoComplete {
    class Node {

        HashMap<Character, Node> children;
        String prefix;
        boolean isWord;

        public Node(String prefix) {
            this.prefix = prefix;
            children = new HashMap<>();
        }
    }

    private Node trie;

    public AutoComplete(String[] dict) {
        trie = new Node("");
        for (String word : dict) {
            insertWord(word);
        }
    }

    private void insertWord(String word) {
        Node current = trie;
        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                current.children.put(word.charAt(i), new Node(word.substring(0, i + 1)));
            }
            current = current.children.get(word.charAt(i));
            if (i == word.length() - 1) {
                current.isWord = true;
            }
        }
    }

    public List<String> getWordsPrefix(String prefix) {
        Node current = trie;
        List<String> results = new LinkedList<>();
        for (char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return results;
            }
        }

        findAllWords(current, results);
        return results;
    }

    private void findAllWords(Node current, List<String> results) {
        if (current.isWord) {
            results.add(current.prefix);
        }
        for (char c : current.children.keySet()) {
            findAllWords(current.children.get(c), results);
        }
    }

    public static void main(String[] args) {
        AutoComplete autocomplete = new AutoComplete(new String[]{"abc", "acd", "bcd", "def", "a", "aba"});
        assert compareArrays(autocomplete.getWordsPrefix("").toArray(new String[6]),
                new String[]{"abc", "acd", "bcd", "def", "a", "aba"});
    }

    private static boolean compareArrays(String[] array1, String[] array2) {
        if (array1.length != array2.length) return false;

        Arrays.sort(array1);
        Arrays.sort(array2);

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) return false;
        }

        return true;
    }
}
