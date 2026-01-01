package BinaryTree;

import java.util.Scanner;

public class BST {
    public  class Node {
        private Node right;
        private Node left;
        private int val;
        private int height;

        public Node(int value){
            this.val = value;
        }

        public int getValue() {
            return val;
        }
    }

    private Node root;

    public BST(){

    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void display(){
        display(root,"Root Node : ");
    }
    private void display(Node node, String details){
        if(node==null){
            return;
        }
        System.out.println(details + node.val);
        display(node.left, "Left child of " +node.val+ " : ");
        display(node.right, "Right child of " +node.val+ " : ");
    }

    public void populate(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            this.insert(arr[i]);
        }
    }

    public void populateSorted(int arr[]){
        populateSorted(arr,0,arr.length);
    }
    private void populateSorted(int arr[], int start, int end){
        if(start>=end){
            return;
        }
        int mid = start +(end-start)/2;
        this.insert(mid);
        populateSorted(arr, start,mid);
        populateSorted(arr, mid+1, end);

    }

    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node==null){
            node = new Node(value);
            return node;
        }
        if(value<node.val){
            node.left = insert(value, node.left);
        }
        if(value>node.val){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) +1;

        return rotate(node);
    }

    public Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            //left heavy ---------
            if(height(node.left.left)-height(node.left.right)>0){
                //left-left case
                return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                //left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left)-height(node.right)<-1){
            //right-heavy case -----
            if(height(node.right.left)-height(node.right.right)>0){
                //right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)<0){
                //right-right case
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left),height(p.right ) +1);
        c.height = Math.max(height(c.left),height(c.right ) +1);

        return c;
    }

    private Node leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;
        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left),height(p.right ) +1);
        c.height = Math.max(height(c.left),height(c.right ) +1);

        return c;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)- height(node.right))<=1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        for(int i=0; i<1000; i++){
            bst.insert(i);
        }
        System.out.println(bst.height());

    }
}
