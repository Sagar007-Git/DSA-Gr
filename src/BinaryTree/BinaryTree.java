package BinaryTree;

import com.sun.source.tree.NewArrayTree;

import java.security.PublicKey;
import java.util.Scanner;

public class BinaryTree {
    private class Node{
        private int val;
        private Node right;
        private Node left;

        public Node(int value){
            this.val = value;
        }

    }

    private Node root;

    public void populate(Scanner scan){
        System.out.print("Enter the root Node : ");
        int value = scan.nextInt();
        root = new Node(value);
        populate(scan, root);
    }

    //insert elements;
    public void populate(Scanner scan, Node node ) {
        System.out.print("Do you want to add left Node for " + node.val + "true / false ?");
        boolean left = scan.nextBoolean();
        if(left) {
            System.out.print("Enter the value for the left Node for " + node.val+" : ");
            int val = scan.nextInt();
            node.left = new Node(val);
            populate(scan,node.left);
        } else {
            node.left = null;
        }

        System.out.print("Do you want to add right Node for " + node.val + "true / false ?");
        boolean right = scan.nextBoolean();
        if(right) {
            System.out.print("Enter the value for the right Node for " + node.val+" : ");
            int val = scan.nextInt();
            node.right = new Node(val);
            populate(scan,node.right);
        } else {
            node.right = null;
        }

    }

    //Display elements of a binary tree;
    public void display(){
//        System.out.println(root.val);

    }
    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.val +" --> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(Node node){
        if(node==null){
            return;
        }
        preOrder(node.left);
        System.out.println(node.val +" --> ");
        preOrder(node.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scan);
        bt.inOrder();
        bt.preOrder();
    }

}
