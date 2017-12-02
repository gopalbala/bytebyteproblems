package trees;

/**
 * Created by fax6 on 01/12/17.
 */
public class LeftView {
    public static void main(String[] args) {
        LvTree tree = new LvTree();
        tree.root = new LvNode(12);
        tree.root.left = new LvNode(10);
        tree.root.right = new LvNode(30);
        tree.root.right.left = new LvNode(25);
        tree.root.right.right = new LvNode(40);

        tree.printLvOfTree(tree.root,1);
    }
}
class  LvTree{
    LvNode root;
    static int maxLevel = 0;
    public void printLvOfTree(LvNode node, int level){
        if (node == null)
            return;
        if (maxLevel < level){
            System.out.print(node.data + " ");
            maxLevel = level;
        }
        printLvOfTree(node.left, level+1);
        printLvOfTree(node.right, level +1);
    }
}
class LvNode{
    int data;
    LvNode left;
    LvNode right;
    public LvNode(int data){
        this.data = data;
    }
}