package trees;

/**
 * Created by gbalasubramanian on 22/11/17.
 */
public class BstFromArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Bst bst = new Bst();
        BstNode n = bst.constructTree(a, 0, a.length - 1);
        bst.printInorder(n);
    }
}

class Bst {
    BstNode root;

    public BstNode constructTree(int[] arr, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        BstNode node = new BstNode(arr[mid]);

        node.left = constructTree(arr, start, mid - 1);
        node.right = constructTree(arr, mid + 1, end);

        if (start > end) {
            return null;
        }
        return node;
    }

    public void printInorder(BstNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}

class BstNode {
    public BstNode(int val) {
        this.val = val;
    }

    int val;
    BstNode left;
    BstNode right;
}
