package trees;

/**
 * Created by gbalasubramanian on 20/10/17.
 */


public class TreeDiameter {
    public TreeNode root;

    public int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        System.out.println("Left Height: " + lheight + ". Right height: " + rheight);

        int leftdm = diameter(root.left);
        int rightdm = diameter(root.right);

        System.out.println("Left Diameter: " + leftdm + ". Right Diameter: " + rightdm);

        return Math.max(lheight + rheight +1 , Math.max(leftdm,rightdm));
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = 0, rh = 0;
        lh = height(root.left);
        rh = height(root.right);
        return Math.max(lh,rh) + 1;
        //return Math.max(height(root.left), height(root.right)) + 1;

    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        //TreeNode tree = new TreeNode();
        TreeDiameter treeDiameter = new TreeDiameter();
        treeDiameter.root = new TreeNode(1);
        treeDiameter.root.left = new TreeNode(2);
        treeDiameter.root.right = new TreeNode(3);
        treeDiameter.root.left.left = new TreeNode(4);
        treeDiameter.root.left.right = new TreeNode(5);

        System.out.println("The height of given binary tree is : "
                + treeDiameter.height(treeDiameter.root));

        System.out.println("The diameter of given binary tree is : "
                + treeDiameter.diameter(treeDiameter.root));
    }
}
