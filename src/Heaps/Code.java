package Heaps;

import java.util.Scanner;

public class Code {
    private class Node {
        private Node left;
        private  Node right;
        private int val;

        public Node(int value){
            this.val = value;
        }
    }

    private Node root;

    public void populate(Scanner scan){
        int val = scan.nextInt();
        root = new Node(val);
        populate(scan, root);
    }
    public void populate(Scanner scan, Node node){

    }

}
