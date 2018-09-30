package trees;

/**
 * Created by gbalasubramanian on 30/09/18.
 */
public class RootToLeafSum {
    public static void main(String[] args) {
        int path[] = new int[100], sum = 164;
        Node root = newNode(45);
        root.left = newNode(38);
        root.left.left = newNode(33);
        root.left.left.left = newNode(31);
        root.left.left.right = newNode(35);
        root.left.right = newNode(41);
        root.left.right.left = newNode(40);
        root.left.right.right = newNode(44);
        root.right = newNode(50);
        root.right.left = newNode(47);
        root.right.left.left = newNode(46);
        root.right.left.right = newNode(48);
        root.right.right = newNode(52);
        root.right.right.left = newNode(51);
        root.right.right.right = newNode(55);
        if (checkThesum(root, path, 0, sum) == 1) System.out.print("YES\n");
        else System.out.print("NO\n");
    }

    // BST node
    static class Node {
        int data;
        Node left, right;
    }

    /* Helper function that
    allocates a new node */
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    // Function to check if root
    // to leaf path sum to a
    // given number in BST
    static int checkThesum(Node root, int path[],
                           int i, int sum) {
        int sum1 = 0, x, j;

        if (root == null)
            return 0;

        // insert the data of a node
        path[i] = root.data;

        // if the node is leaf
        // add all the element in array
        if (root.left == null &&
                root.right == null) {
            for (j = 0; j <= i; j++)
                sum1 = sum1 + path[j];
            // if the sum of root node to leaf // node data is equal then return 1
            if (sum == sum1)
                return 1;
            else
                return 0;
        }
        x = checkThesum(root.left, path, i + 1, sum);
        // if x is 1, it means the // given sum is matched with // root to leaf node sum
        if (x == 1)
            return 1;
        else {
            return checkThesum(root.right, path, i + 1, sum);
        }
    } // Driver code public


}

