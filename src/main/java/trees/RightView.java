package trees;

/**
 * Created by gbalasubramanian on 03/12/17.
 */
public class RightView {
    public static void main(String[] args) {
        MaxLevel maxLevel = new MaxLevel();
        RvTree tree = new RvTree();
        tree.root = new RvNode(1);
        tree.root.left = new RvNode(2);
        tree.root.right = new RvNode(3);
        tree.root.left.left = new RvNode(4);
        tree.root.left.right = new RvNode(5);
        tree.root.right.left = new RvNode(6);
        tree.root.right.right = new RvNode(7);
        tree.root.right.left.right = new RvNode(8);

        tree.printrightViewOfTree(tree.root, 1, maxLevel);
    }
}
class RvNode {
    int data;
    RvNode left;
    RvNode right;

    public RvNode(int data) {
        this.data = data;
    }
}

class RvTree {
    RvNode root;

    public static void printrightViewOfTree(RvNode node, int level, MaxLevel maxLevel) {
        if (node == null)
            return;
        if (maxLevel.maxLevel < level) {
            System.out.println(node.data + " ");
            maxLevel.maxLevel = level;
        }
        printrightViewOfTree(node.right, level + 1, maxLevel);
        printrightViewOfTree(node.left, level + 1, maxLevel);
    }
}

class MaxLevel {
    int maxLevel;
}
