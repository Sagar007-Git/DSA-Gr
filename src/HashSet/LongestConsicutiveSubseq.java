package HashSet;

import java.util.HashSet;

public class LongestConsicutiveSubseq {
    public static void main(String[] args) {
        System.out.println(fun(new int[] {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}));
    }
    static int fun(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        int maxCount =0;
        for (int i = 0; i < arr.length; i++) {
            int present = arr[i];
            if(!set.contains(present-1)){
                int tempCount = 1;
                int nextEle = present+1;
                while (set.contains(nextEle)){
                    tempCount++;
                    nextEle++;
                }
                if(tempCount>maxCount){
                    maxCount=tempCount;
                }
            }
        }
        return maxCount;
    }
}
