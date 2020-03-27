package trees;

public class Trie {

    private Node root;

    private int indexOfSingleChild;

    public Trie() {
        this.root = new Node("");
    }

    public void insert(String key) {
        Node tempNode = root;

        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex, node);
                tempNode = node;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        tempNode.leaf = true;
    }

    public boolean search(String key) {

        Node trieNode = root;

        for (int i = 0; i < key.length(); ++i) {

            char c = key.charAt(i);
            int asciiIndex = c - 'a';

            if (trieNode.getChild(asciiIndex) == null) {
                return false;
            } else {
                trieNode = trieNode.getChild(asciiIndex);
            }
        }

        return true;
    }

    class Node {
        String character;
        Node[] children;
        boolean leaf;
        boolean visited;

        public Node(String character) {
            this.character = character;
            children = new Node[26];
        }

        public Node getChild(int index) {
            return children[index];
        }

        public void setChild(int index, Node node) {
            children[index] = node;
        }

    }

}
