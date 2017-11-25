package trees;

import java.util.Stack;

/**
 * Created by gbalasubramanian on 25/11/17.
 */
public class InorderWithoutRecursion {
    public static void main(String[] args) {
        Itree tree = new Itree();
        tree.root = new INode(1);
        tree.root.left = new INode(2);
        tree.root.right = new INode(3);
        tree.root.left.left = new INode(4);
        tree.root.left.right = new INode(5);
        tree.inOrder(tree.root);
    }
}

class Itree {
    INode root;

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
            System.out.println(node.data);
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    nodeStack.push(node);
                    node = node.left;
                }
            }
        }
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
