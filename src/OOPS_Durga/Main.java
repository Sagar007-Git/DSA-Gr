package OOPS_Durga;
import java.sql.DataTruncation;
import java.util.*;
public class Main {

}

class Date{
    int date;
    String name;

    Date(int date){
        this.date= date;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Destroyed object");
    }
}


