package trees;

import java.util.Stack;

/**
 * Created by gbalasubramanian on 25/11/17.
 */
public class InorderWithoutRecursion {
    public static void main(String[] args) {
        System.out.println("******Inorder******");
        Itree tree = new Itree();
        tree.root = new INode(1);
        tree.root.left = new INode(2);
        tree.root.right = new INode(3);
        tree.root.left.left = new INode(4);
        tree.root.left.right = new INode(5);
        tree.inOrder(tree.root);
        System.out.println("******Preorder******");
        tree.preOrder(tree.root);
        tree = new Itree();
        tree.root = new INode(10);
        tree.root.left = new INode(8);
        tree.root.right = new INode(2);
        tree.root.left.left = new INode(3);
        tree.root.left.right = new INode(5);
        tree.root.right.left = new INode(2);
        tree.preOrder(tree.root);
        System.out.println("******Postorder******");

        INode root = null;
        tree.root = new INode(1);
        tree.root.left = new INode(2);
        tree.root.right = new INode(3);
        tree.root.left.left = new INode(4);
        tree.root.left.right = new INode(5);
        tree.root.right.left = new INode(6);
        tree.root.right.right = new INode(7);
        tree.postOrder(tree.root);
    }
}

class Itree {
    INode root;
    Stack<INode> s1, s2;

    public void inOrder(INode node) {
        if (node == null)
            return;
        Stack<INode> nodeStack = new Stack<>();
        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }
        while (nodeStack.size() > 0) {
            node = nodeStack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    nodeStack.push(node);
                    node = node.left;
                }
            }
        }
        System.out.println();
    }

    public void preOrder(INode node) {
        if (node == null)
            return;
        Stack<INode> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (!nodeStack.isEmpty()) {
            System.out.print(nodeStack.peek().data + " ");
            node = nodeStack.pop();
            if (node.right != null)
                nodeStack.push(node.right);
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
        System.out.println();
    }

    public void postOrder(INode node) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        if (node == null)
            return;
        s1.push(root);
        while (!s1.isEmpty()) {
            INode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }
        while (!s2.isEmpty()) {
            INode temp = s2.pop();
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }
}

class INode {
    int data;
    INode left;
    INode right;

    public INode(int data) {
        this.data = data;
    }
}
