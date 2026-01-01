package OOPS_Practice.StaticStuffs;

class OuterClass {
    private static int staticField = 10; // Static field
    private int instanceField = 20;     // Instance field

    // Inner class (static)
    public class InnerClass {
        static int man = 23;
        public void display() {
            System.out.println("Static field of OuterClass: " + staticField);
//            System.out.println("Instance field of OuterClass: " + instanceField); // Cannot access instance field
            }
            public void fun(){
                System.out.println(this.man);;
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass innerClass = outer.new InnerClass();

        innerClass.fun();
    }
}
