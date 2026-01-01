package A_Random;

public class CourseSchedule1 {
    public static void main(String[] args) {

    }

    static boolean fun(int N, int P, int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][0]<arr[i][1]) return false;
        }
        return true;
    }
}
