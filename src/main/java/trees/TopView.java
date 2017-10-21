package trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gbalasubramanian on 20/10/17.
 */
public class TopView {
    TreeNode root;

    public void printTopView() {
        if (root == null)
            return;
        HashSet<Integer> items = new HashSet<>();

        Queue<QueueItem> levelOrder = new LinkedList<>();
        levelOrder.add(new QueueItem(root, 0));

        while (!levelOrder.isEmpty()) {
            QueueItem node = levelOrder.remove();
            int hd = node.horizontalDistance;
            if (!items.contains(hd)) {
                items.add(hd);
                System.out.println(node.node.data);
            }
            if (node.node.left != null)
                levelOrder.add(new QueueItem(node.node.left, hd - 1));
            if (node.node.right != null)
                levelOrder.add(new QueueItem(node.node.right, hd + 1));
        }

    }

    public static void main(String[] args)
    {
        /* Create following Binary Tree
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        TopView topView = new TopView();
        topView.root = root;
        System.out.println("Following are nodes in top view of Binary Tree");
        topView.printTopView();
    }
}

class QueueItem {
    TreeNode node;
    int horizontalDistance;

    public QueueItem(TreeNode node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
