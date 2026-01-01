package BinaryTree;

public class SegmentTree {
    class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;


        public Node(int start, int end){
            this.startInterval = start;
            this.endInterval = end;
        }
    }

    Node root;

    public SegmentTree(int arr[]){
        this.root = constructor(arr,0,arr.length-1);
    }

    private Node constructor(int[] arr, int start, int end) {
        if(start==end){
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start,end);
        int mid = start +(end-start)/2;
        node.left = constructor(arr,start,mid);
        node.right = constructor(arr, mid+1,end);
        node.data = node.right.data+node.left.data;
        return node;
    }

    public void display(){
        display(root);
    }
    private Node display(Node node){
        if(node.right==null){
            System.out.println("["+node.startInterval+", "+node.endInterval + "]"+"  = "+node.data);
            return node;
        }
        display(node.left);
        display(node.right);
        System.out.println("["+node.startInterval+", "+node.endInterval + "]"+"  = "+node.data);
        return node;

    }

    public int query(int start, int end){
        return this.query(root, start, end);
    }
    private int query(Node node, int qsi, int qei   ){
       if(node.startInterval>=qsi && node.endInterval<=qei){
           //node is completely in the interval
           return node.data;
       } else if(node.startInterval>qei || node.endInterval<qsi){
           return 0;
       }else {
           return this.query(node.left,qsi, qei) + this.query(node.right,qsi, qei);
       }
    }

    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value){
        if(node.startInterval<=index && node.endInterval>=index){
            if(node.startInterval==index && node.endInterval==index){
                node.data = value;
                return node.data;
            } else {
                node.data = update(node.left, index, value) + update(node.right,index,value);
                return  node.data;
            }
        }

        return  node.data;
    }

    public static void main(String[] args) {
        int arr[] = {3,4,8,9,3,7};
        SegmentTree ST = new SegmentTree(arr);
        ST.update(3,19);
        ST.display();
        System.out.println(ST.query(2,5));
    }


}
