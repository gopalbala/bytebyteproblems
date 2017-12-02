package trees;

/**
 * Created by gbalasubramanian on 23/11/17.
 */
public class InorderSuccessor {
    public static void main(String[] args) {
        Successor tree = new Successor();
        STreeNode root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.getSuccessor(temp);
        if (suc != null) {
            System.out.println("Inorder successor of " + temp.data +
                    " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }
}

class Successor {
    STreeNode root;

    STreeNode insert(STreeNode node, int data) {

        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return (new STreeNode(data));
        } else {

            STreeNode temp = null;

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;

            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }


    public STreeNode getSuccessor(STreeNode node) {
        if (node == null)
            return null;
        if (node.right != null) {
            return getLeftmostChild(node.right);
        }
        STreeNode p = node.parent;
        while (p != null && node == p.right) {
            node = p;
            p = p.parent;
        }
        return p;

    }

    public STreeNode getLeftmostChild(STreeNode node) {
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

class STreeNode {
    STreeNode left;
    STreeNode right;
    STreeNode parent;
    int data;

    public STreeNode(int data) {
        this.data = data;
    }

    public STreeNode() {
    }
}
