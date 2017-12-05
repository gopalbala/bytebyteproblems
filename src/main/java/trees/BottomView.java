package trees;

import java.util.*;

/**
 * Created by fax6 gbalasubramanian 03/12/17.
 */
public class BottomView {
    public static void main(String[] args) {
        BvNode root = new BvNode(20);
        root.left = new BvNode(8);
        root.right = new BvNode(22);
        root.left.left = new BvNode(5);
        root.left.right = new BvNode(3);
        root.right.left = new BvNode(4);
        root.right.right = new BvNode(25);
        root.left.right.left = new BvNode(10);
        root.left.right.right = new BvNode(14);
        BvTree tree = new BvTree();
        tree.root = root;
        System.out.println("Bottom view of the given binary tree:");
        tree.printBotttomView(root);
    }
}

class BvTree {
    BvNode root;

    public void printBotttomView(BvNode node) {
        Queue<BvNode> bvNodeQueue = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int hd = 0;
        if (node == null)
            return;
        bvNodeQueue.add(node);
        node.hd = hd;
        while (!bvNodeQueue.isEmpty()) {
            BvNode n = bvNodeQueue.remove();
            hashMap.put(hd, n.data);
            hd = n.hd;
            if (n.left != null) {
                n.left.hd = hd - 1;
                bvNodeQueue.add(n.left);
            }
            if (n.right != null) {
                n.right.hd = hd + 1;
                bvNodeQueue.add(n.right);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, Integer> mapEmtry = entryIterator.next();
            System.out.println(mapEmtry.getValue());
        }
    }
}

class BvNode {
    int data;
    BvNode left;
    BvNode right;
    int hd;

    public BvNode(int data) {
        this.data = data;
    }
}
