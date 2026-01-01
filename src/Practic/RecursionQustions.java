package Practic;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionQustions {
    public static void main(String[] args) {
//        printN(5);
//        System.out.println(countZeros(500203000,0));
        int arr[] = {1,7,9,3,1,1,1,2,4,8};
//        System.out.println();
        System.out.println(subSeq("","str",new ArrayList<>()));
    }

    static void printN(int n){
        if(n==0){
            System.out.println(n);
            return;
        }
        printN(n-1);
        System.out.println(n);
    }

    static  int factorial(int n){
        if(n==1){
            return n;
        }
        return n*factorial(n-1);
    }

    static int sum(int n){
        if(n==1){
            return n;
        }
        return n + sum(n-1);
    }

    static int digitSum(int n){
        if(n==0){
            return n;
        }
        return n%10 + digitSum(n/10);
    }

    static int digitPrd(int n){
        if(n%10==n){
            return n;
        }
        return n%10*digitPrd(n/10);
    }

//    static int reverseNum(int n){
//        if(n%10==0){
//            return n;
//        }
//        return (n%10)*(int)Math.pow(10,(int)Math.log(n)) + reverseNum(n/10);
//    }

    static int countZeros(int n, int count){
        if(n/10==0){
            return count;
        }
        if(n%10==0){
            return countZeros(n/10,count+1);
        } else {
            return countZeros(n/10, count);
        }
    }

    static void bubbleSort(int arr[]){
        for(int j=arr.length-1;j>0;j--){
            int flag =0;
            for (int i=1; i<=j; i++){
                if(arr[i-1]>arr[i]){
                    int tem = arr[i-1];
                    arr[i-1]=arr[i];
                    arr[i]=tem;
                    flag = 1;
                }
            }
            if(flag!=1){
                return;
            }
        }

    }

    static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            int index =arr.length-i-1;
            for (int j = 0; j < arr.length-i; j++) {
                if(max<arr[j]){
                    max=arr[j];
                    index=j;
                }
            }
            int temp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[index];
            arr[index] = temp;
        }
    }

    static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j>0; j--) {
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                } else {
                    break;
                }
            }
        }
    }

    static  void cyclicSort(int arr[]){
        int i=0;
        while (i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=i+1){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else {
                i++;
            }
        }
    }

    static boolean isSorted(int arr[],int index){
        if(index== arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && isSorted(arr,++index);
    }

    static boolean linearSearch(int arr[],int index, int tar){
        if(index==arr.length){
            return false;
        }
        return arr[index]==tar || linearSearch(arr, ++index, tar);
    }

    static int tarIndex(int arr[], int tar, int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==tar){
            return index;
        } else {
            return tarIndex(arr, tar, ++index);
        }
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> tarMultiIndex(int arr[], int tar, int index){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==tar){
            list.add(index);
        }
        return tarMultiIndex(arr, tar, ++index);
    }
    
    static void pattern(int n){
        if(n==0){
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
        pattern(n-1);
    }

    static  void pattern1(int rows, int col){
        if(rows==0){
            return;
        }
        if(rows>col){
            pattern1(rows,++col);
            System.out.print("* ");
        }else {
            pattern1(rows-1, 0);
            System.out.println();
        }
    }

    static String skipChar(String str){
        if(str.length()==0){
            return "";
        }
        char ch = str.charAt(0);
        if(ch=='a'){
            return skipChar(str.substring(1));
        }else {
            return ch + skipChar(str.substring(1));
        }
    }

    static String skipString(String str){
        if (str.length()==0){
            return "";
        }
        if(str.startsWith("str")){
            return skipString(str.substring(3));
        }else {
            return str.charAt(0) + skipString(str.substring(1));
        }
    }

    static void subSequence(String p,String str){
        if(str.length()==0){
            System.out.println(p);
            return;
        }
        char ch = str.charAt(0);
        subSequence(p +ch,str.substring(1) );
        subSequence(p,str.substring(1));
    }

//    static ArrayList<String> seq = new ArrayList<>();
    static ArrayList<String> subSeq(String p,String str, ArrayList<String> seq ){
        if(str.length()==0){
            ArrayList<String> last = new ArrayList<>();
            last.add(p);
            return last;
        }
        char ch = str.charAt(0);
        seq.add(p);
        ArrayList<String> right =  subSeq(p,str.substring(1),seq);
        ArrayList<String> left =  subSeq(p+ch,str.substring(1),seq);
        right.addAll(left);
        return right;
    }
}
