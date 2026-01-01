import java.lang.instrument.ClassDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        System.out.println(lastRemaining(1000000));

    }
    public static int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        int index = 0;
        int flag = 0;
        while(list.size()!=1){
            if(index>list.size()-1 || index<0){
                if(flag==0) index=list.size()-1;
                else index=0;
                flag = 1-flag;
            }
            if(flag==0){
                list.remove(index);
                index+=1;
            }
            if(flag==1){
                list.remove(index);
                index-=1;
            }
        }
        return list.get(0);
    }
}