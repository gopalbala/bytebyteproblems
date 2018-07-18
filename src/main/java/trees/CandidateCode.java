package trees;

/**
 * Created by gbalasubramanian on 04/04/18.
 */
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner scanner = new Scanner(System. in);
        int n = scanner.nextInt();
        int[] treeArr = new int[n];
        for(int i=0;i<n;i++){
            treeArr[i] = scanner.nextInt();
        }
        Tree tree = new Tree();
        for(int i=0;i<n;i++){
            tree.insert(treeArr[i]);
        }
        int nodeToDelete = scanner.nextInt();
        tree.deleteNode(nodeToDelete);
        System.out.println(tree.getLeafNodes());
    }
}

class Tree{
    TreeNodes root;

    public TreeNodes getRoot(){
        return this.root;
    }

    public TreeNodes insert(int data){
        if(root == null){
            root = new TreeNodes(data);
            return root;
        }
        insert(root, data);
        return root;
    }

    private void insert(TreeNodes node, int data) {
        if(data <= node.getData()){
            if(node.getLeft()!= null)
                insert( node.getLeft(), data);
            else{
                TreeNodes n = new TreeNodes(data);
                node.setLeft(n);
            }
        } else{
            if(node.getRight()!=null)
                insert( node.getRight(),data);
            else{
                TreeNodes n = new TreeNodes(data);
                node.setRight(n);
            }
        }
    }
    int leafNodes = 0;
    public int getLeafNodes(){
        if(root == null)
            return 0;
        return getLeafNodes(root);
    }

    private int getLeafNodes(TreeNodes n){
        if(n.getLeft()== null && n.getRight() == null){
            leafNodes++;
        }
        if(n.getLeft()!=null)
            getLeafNodes(n.getLeft());
        if(n.getRight()!=null)
            getLeafNodes(n.getRight());
        return leafNodes;
    }

    public TreeNodes deleteNode(int data) {
        if(root == null)
            return null;
        if(root.getData() == data){
            root = null;
            return null;
        }
        deleteNode(root, data);
        return root;
    }

    private void deleteNode(TreeNodes node, int data) {
        if (node == null)
            return;
        if(node.getLeft() == null && data < node.getData())
            return;
        if(node.getRight() == null && data > node.getData())
            return;
        if(data < node.getData())
            deleteNode(node.getLeft(), data);
        else
            deleteNode(node.getRight(), data);

        if(node.getLeft() != null && node.getLeft().getData() == data){
            node.setLeft(null);
            return;
        }
        if(node.getRight()!= null && node.getRight().getData() == data){
            node.setRight(null);
            return;
        }
    }
}
class TreeNodes{
    int data;
    public TreeNodes(int data){
        this.data = data;
    }
    TreeNodes left;
    TreeNodes right;
    public int getData(){
        return this.data;
    }
    public TreeNodes getLeft(){
        return this.left;
    }
    public TreeNodes getRight(){
        return this.right;
    }
    public void setLeft(TreeNodes node){
        this.left = node;
    }
    public void setRight(TreeNodes node){
        this.right = node;
    }
    
}

