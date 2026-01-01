package BinaryTree;
import java.security.PrivateKey;
import java.util.Scanner;

public class practiceTree {
//    private binaryTree(){
//
//    }
    private static class Node {
        private int val;
        private Node left;
        private  Node right;
        public  Node(int value){
            this.val = value;
        }
    }
    private  Node root;

    public void populate(Scanner scan){
        System.out.print("Enter the root Node vaue : ");
        int val = scan.nextInt();
        root = new Node(val);
        populate(scan, root);
    }
    private  void populate(Scanner scanner,  Node node){
        System.out.print("Do you want to enter left of " +node.val+" ");
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.print("enter the value to the Left Node " + node.val+" ");
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner,node.left);
        }
        System.out.print("Do you want to enter right of " + node.val+ " ");
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("enter the value to the right Node " + node.val + " ");
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner,node.right);
        }
    }

    public static void main(String[] args) {
        Scanner maang = new Scanner(System.in);
        practiceTree pack = new practiceTree();
        pack.populate(maang);
    }
}
