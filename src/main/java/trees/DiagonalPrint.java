package trees;

import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

/**
 * Created by gbalasubramanian on 27/11/17.
 */
public class DiagonalPrint {
    public static void main(String[] args) {
        DNode root = new DNode(8);
        root.left = new DNode(3);
        root.right = new DNode(10);
        root.left.left = new DNode(1);
        root.left.right = new DNode(6);
        root.right.right = new DNode(14);
        root.right.right.left = new DNode(13);
        root.left.right.left = new DNode(4);
        root.left.right.right = new DNode(7);
        DTree tree = new DTree();
        tree.root = root;
        HashMap<Integer, Vector<Integer>> diagonalPrint = new HashMap<>();
        tree.diagonalPrint(tree.root, 0, diagonalPrint);
        for (Map.Entry<Integer, Vector<Integer>> entry : diagonalPrint.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

class DTree {
    DNode root;

    public void diagonalPrint(DNode node, int d, HashMap<Integer, Vector<Integer>> diagonalPrint) {
        if (node == null)
            return;
        Vector<Integer> k = diagonalPrint.get(d);
        if (k == null) {
            k = new Vector<>();
            k.add(node.data);
        } else {
            k.add(node.data);
        }
        diagonalPrint.put(d, k);
        diagonalPrint(node.left, d + 1, diagonalPrint);
        diagonalPrint(node.right, d , diagonalPrint);
    }
}

class DNode {
    int data;
    DNode left;
    DNode right;

    public DNode(int data) {
        this.data = data;
    }
}
