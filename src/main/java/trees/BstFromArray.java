package trees;

/**
 * Created by gbalasubramanian on 22/11/17.
 */
public class BstFromArray {
    public static void main(String[] args) {

    }
}

class Bst {
    BstNode root;

    public BstNode constructTree(int[] arr, int start, int end) {
        if (start < end)
            return null;
        int mid = (start + end) / 2;
        BstNode node = new BstNode(arr[mid]);

        root.left = constructTree(arr, 0, mid - 1);
        root.right = constructTree(arr, mid + 1, end);
        return root;
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
