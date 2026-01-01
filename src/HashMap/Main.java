package HashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> myHeap = new HashMap<>();
        myHeap.put(1,"Shan");
        myHeap.put(2,"asf");
        myHeap.put(3,"Shaadgn");
        myHeap.put(4,"the");
        myHeap.put(1,"hgfdsdfgffggggggggggggg");
        System.out.println(myHeap);
//        System.out.println(myHeap.containsKey(3));
        myHeap.replace(1,"gagg");
        System.out.println(myHeap.put(4,"the"));

    }
}
