package com.gb.bytebybyteproblems;

import java.util.Random;

/**
 * Created by gbalasubramanian on 02/09/17.
 */
public class RandomNodeBinaryTree {
    private class Node {
        Node left;
        Node right;
        int val;
        int childrenCount;
    }

    Node root;
    Random random;

    public RandomNodeBinaryTree() {
        random = new Random();
    }

    public RandomNodeBinaryTree(long seed) {
        random = new Random(seed);
    }

    public void addNode(int val) {
        Node node = new Node();
        node.val = val;

        if (root == null) {
            root = new Node();
            root.val = val;
        }
        addNode(root, node);
    }

    private void addNode(Node root, Node node) {
        root.childrenCount++;
        if (root.val < node.val) {
            if (root.left == null)
                root.left = node;
            else
                addNode(root.left, node);
        } else {
            if (root.right == null)
                root.right = node;
            else
                addNode(root.right, node);
        }
    }

    public int getRandomNode() {
        int rnd = random.nextInt(root.childrenCount - 1);
        return getRandomNode(root, rnd);
    }

    private int getRandomNode(Node current, int count) {
        if (count == root.childrenCount) {
            return root.val;
        } else if (count < getChildCount(current)) {
            return getRandomNode(root.left, count);
        } else {
            return getRandomNode(root.right, getChildCount(root) - count - 1);
        }
    }

    private int getChildCount(Node node) {
        if (node == null) return 0;
        return node.childrenCount + 1;
    }

    public static void main(String[] args) {
        // Generates the tree:
        //        4
        //      /   \
        //     2     6
        //    / \   / \
        //   1   3 5   7

        RandomNodeBinaryTree t = new RandomNodeBinaryTree(0);
        t.addNode(4);
        t.addNode(2);
        t.addNode(6);
        t.addNode(1);
        t.addNode(3);
        t.addNode(5);
        t.addNode(7);

        assert t.getRandomNode() == 6;
        assert t.getRandomNode() == 3;
        assert t.getRandomNode() == 5;
        assert t.getRandomNode() == 3;
        assert t.getRandomNode() == 5;
        assert t.getRandomNode() == 1;
        System.out.println("Passed all tests");
    }
}
