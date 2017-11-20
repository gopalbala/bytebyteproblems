package trees;

/**
 * Created by gbalasubramanian on 23/10/17.
 */
public class AddGreaterNodes {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

          /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.modifySum(tree.root, new Sum());

        tree.inorder();

    }
}

class BinarySearchTree {
    Node root;

    void inorder() {
        inorderTraversal(root);
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    void inorderTraversal(Node node) {
        if (node == null)
            return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    Node insertRec(Node node, int data) {
        if (node == null) {
            root = new Node(data);
            return root;
        }
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    void modifySum(Node node, Sum sum) {
        if (node == null)
            return;
        modifySum(node.right, sum);
        sum.sum += node.data;
        node.data = sum.sum;
        modifySum(node.left, sum);
    }
}

class Sum {
    int sum;
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
