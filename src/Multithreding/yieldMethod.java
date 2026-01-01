package Multithreding;

public class yieldMethod extends  Thread {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            Thread.yield();//this doesnt work in windows
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }

    public static void main(String[] args) {
        yieldMethod t = new yieldMethod();
        t.start();
        Thread.yield();
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }
}
