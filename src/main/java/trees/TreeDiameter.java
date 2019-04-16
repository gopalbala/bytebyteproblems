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

    int diameterOpt(Node root, Height height)
    {
        /* lh --> Height of left subtree
           rh --> Height of right subtree */
        Height lh = new Height(), rh = new Height();

        if (root == null)
        {
            height.h = 0;
            return 0; /* diameter is also 0 */
        }

        /* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */
        /* Get the heights of left and right subtrees in lh and rh
         And store the returned values in ldiameter and ldiameter */
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);

        /* Height of current node is max of heights of left and
         right subtrees plus 1*/
        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }
}
class Height
{
    int h;
}

