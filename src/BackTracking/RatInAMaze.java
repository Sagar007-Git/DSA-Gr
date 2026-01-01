package BackTracking;

import java.util.ArrayList;
import java.util.List;

//// have to learn still...!

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(fun(arr));
    }
    static List<String> fun(int[][] arr){
        List<String> list = new ArrayList<>();
        return helper(0,0,"", arr, list);
    }
//    private static List<String> helper(int cols, int rows, String string,  int[][] arr, List<String> list){
//        if(cols== arr.length-1 && rows== arr[0].length-1){
////                list.add(string);
//            return list;
//        }
//        if((string.length()==0 || string.charAt(string.length()-1)!='U') && cols+1< arr[0].length && arr[cols+1][rows]!=0){
//            helper(cols+1, rows, string+"D", arr, list);
//            list.add(string);
//            arr[rows][cols] = 0;
//        }
//        if((string.length()==0 || string.charAt(string.length()-1)!='D') && cols-1>= 0 && arr[cols-1][rows]!=0){
//            helper(cols-1, rows, string+"U", arr, list );
//            list.add(string);
//            arr[rows][cols] = 0;
//        }
//        if((string.length()==0 || string.charAt(string.length()-1)!='L') && rows+1< arr[0].length && arr[cols][rows+1]!=0){
//            helper(cols, rows+1, string+"R", arr, list );
//            list.add(string);
//            arr[rows][cols] = 0;
//
//        }
//
//        if((string.length()==0 || string.charAt(string.length()-1)!='R') && rows-1>= 0 && arr[cols][rows-1]!=0){
//            helper(cols, rows-1, string+"L", arr, list );
//            list.add(string);
//            arr[rows][cols] = 0;
//
//        }
//        arr[rows][cols] = 1;
//
//        return list;
//
//    }
private static List<String> helper(int cols, int rows, String string, int[][] arr, List<String> list) {
    // Base case: reached destination
    if(cols == arr.length-1 && rows == arr[0].length-1) {
        list.add(string);
        return list;
    }

    // Mark current cell as visited (ONCE at start)
    arr[rows][cols] = 0;

    // Try all four directions (all conditions remain available)
    // Down
    if(cols+1 < arr.length && arr[cols+1][rows] != 0 &&
            (string.isEmpty() || string.charAt(string.length()-1) != 'U')) {
        helper(cols+1, rows, string+"D", arr, list);
    }

    // Right
    if(rows+1 < arr[0].length && arr[cols][rows+1] != 0 &&
            (string.isEmpty() || string.charAt(string.length()-1) != 'L')) {
        helper(cols, rows+1, string+"R", arr, list);
    }

    // Up
    if(cols-1 >= 0 && arr[cols-1][rows] != 0 &&
            (string.isEmpty() || string.charAt(string.length()-1) != 'D')) {
        helper(cols-1, rows, string+"U", arr, list);
    }

    // Left
    if(rows-1 >= 0 && arr[cols][rows-1] != 0 &&
            (string.isEmpty() || string.charAt(string.length()-1) != 'R')) {
        helper(cols, rows-1, string+"L", arr, list);
    }

    // Backtrack: unmark current cell (ONCE at end)
    arr[rows][cols] = 1;

    return list;
}
}
