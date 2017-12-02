package trees;

/**
 * Created by gbalasubramanian on 27/11/17.
 */
public class TreeToString {
    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        StringBuilder str = new StringBuilder();
        treeToString(root, str);
        System.out.println(str.toString());
    }

    static void treeToString(TreeNode root, StringBuilder str){
        if (root == null)
            return;
        str.append(root.data);
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            str.append('(');
            treeToString(root.left, str);
            str.append(')');
        }
        if (root.right != null){
            str.append('(');
            treeToString(root.right,str);
            str.append(')');
        }
    }
}
