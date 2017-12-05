package trees;

/**
 * Created by fax6 on 04/12/17.
 */
public class NextSiblings {
    public static void main(String[] args) {
        SNode root = new SNode(1);
        root.left = new SNode(2);
        root.right = new SNode(3);
        root.left.left = new SNode(4);
        root.left.right = new SNode(5);
        root.right.left = new SNode(6);
        root.right.right = new SNode(7);
        STree tree = new STree();
        tree.printSiblingNodes(root);
    }
}

class STree {
    SNode root;

    public void printSiblingNodes(SNode node) {
        if (node == null)
            return;
        if (node.left != null) {
            node.left.nextSibling = node.right;
            if (node.nextSibling != null)
                System.out.print(node.left.data + " -> "+ node.nextSibling.data);
            else
                System.out.print(node.left.data + " -> ");
        }
        if (node.right != null) {
            if (node.nextSibling != null) {
                node.right.nextSibling = node.nextSibling.left;
                System.out.print(node.left.data + " -> "+ node.nextSibling.data);
            }
        }
        System.out.println();
        printSiblingNodes(node.left);
        printSiblingNodes(node.right);
    }
}

class SNode {
    int data;
    SNode left;
    SNode right;
    SNode nextSibling;

    public SNode(int data) {
        this.data = data;
    }
}
