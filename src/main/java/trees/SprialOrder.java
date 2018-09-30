package trees;

import java.util.Stack;

/**
 * Created by gbalasubramanian on 29/09/18.
 */
public class SprialOrder {
    public static void main(String[] args) {
        SpvTree tree = new SpvTree();
        tree.root = new SpvNode(1);
        tree.root.left = new SpvNode(2);
        tree.root.right = new SpvNode(3);
        tree.root.left.left = new SpvNode(7);
        tree.root.left.right = new SpvNode(6);
        tree.root.right.left = new SpvNode(5);
        tree.root.right.right = new SpvNode(4);
        tree.printSprialOrder();
    }
}

class SpvTree {
    SpvNode root;

    public void printSprialOrder() {
        if (root == null) {
            return;
        }

        Stack<SpvNode> s1 = new Stack<>();
        Stack<SpvNode> s2 = new Stack<>();
        s1.add(root);
        while (s1.size() > 0 || s2.size()> 0) {
            while (!s1.isEmpty()) {
                SpvNode node = s1.pop();
                System.out.print(node.data + " ");
                if (node.right != null)
                    s2.push(node.right);
                if (node.left != null)
                    s2.push(node.left);
            }
            while (!s2.isEmpty()) {
                SpvNode node = s2.pop();
                System.out.print(node.data + " ");

                if (node.left != null)
                    s1.push(node.left);
                if (node.right != null)
                    s1.push(node.right);

            }
        }
    }
}

class SpvNode {
    int data;
    SpvNode left;
    SpvNode right;

    public SpvNode(int data) {
        this.data = data;
    }
}