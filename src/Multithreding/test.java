package Multithreding;

public class test extends  Thread {

    @Override
    public void run() {

    }
/////
    public static void main(String[] args) {
        test world = new test();
        world.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println(world.isAlive());
//        Thread.currentThread().setName("huliiii");
        System.out.println(10/0);
        System.out.println(Thread.currentThread().isAlive());
    }
}
