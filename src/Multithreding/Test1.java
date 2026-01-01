package Multithreding;

public class Test1 extends Thread{
    @Override
    public void run() {
        System.out.println("t thread : " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        System.out.println("Main thread befire priortising : "+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(1);
        Test1 t = new Test1();
        t.start();
        System.out.println("Main thread After priortising  : "+ Thread.currentThread().getPriority());
    }
}
