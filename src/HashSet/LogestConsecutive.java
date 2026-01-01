package HashSet;

import java.util.HashSet;

public class LogestConsecutive {
    public static void main(String[] args) {
        System.out.println(fun(new int[]{1, 1, 2, 4, 9, 10, 11, 7, 8, 6, 3}));
    }
    static int fun(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int maxCount =0;
        int i=0;
        while (i< arr.length){
            int present = arr[i];
            if(!set.contains(arr[i]-1)){
                int count=1;
                int next = present+1;
                while(set.contains(next)){
                    count++;
                    next++;
                }
                maxCount = Math.max(maxCount,count);
            }
            i++;
        }
        return maxCount;
    }
}
