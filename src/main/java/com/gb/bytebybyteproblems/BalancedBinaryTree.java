package com.gb.bytebybyteproblems;

/**
 * Created by gbalasubramanian on 28/08/17.
 */
public class BalancedBinaryTree {
    static class Node {
        public Node(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        Node left;
        Node right;
        int value;

    }
    public static boolean isBalanced(Node node){
        return balancedHeight(node) > -1;
    }

    private static int balancedHeight(Node node) {
        if (node == null){
            return 0;
        }
        int leftHeight = balancedHeight(node.getLeft());
        int rightHeight = balancedHeight(node.getRight());

        if (leftHeight == -1 || rightHeight == -1){
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node firstLeftNode = new Node(2);
        Node firstRightNode = new Node(3);
        Node secondLeft = new Node(4);

        Node firstLeftRightNode = new Node(5);
        Node firstRightRightNode = new Node(6);
        root.setLeft(firstLeftNode);
        root.setRight(firstRightNode);

        firstLeftNode.setLeft(secondLeft);
        firstRightNode.setLeft(firstLeftRightNode);
        firstRightNode.setRight(firstRightRightNode);

        System.out.println(isBalanced(root));
    }
}
