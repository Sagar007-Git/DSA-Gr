package Practic;

import java.util.Objects;

public class dattatype {
    public static void main(String[] args) {
        System.out.println(dataTypeSize("Integer"));
    }
        static int dataTypeSize(String str) {
            if(Objects.equals(str, "Double")) return 8;
            else if(Objects.equals(str, "Integer")) return 4;
            else if(str=="Long") return 8;
            else if(str=="Float") return 4;
            else return 1;

    }
}
