package Multithreding;

class task1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("task1");
        }
    }
}

class task2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("task2");
        }
    }
}


public class multiTasking {
    public static void main(String[] args) {
        task1 t1_2 = new task1();
        t1_2.start();
        task2 t2_1 = new task2();
        t2_1.start();
        task1 t1_1 = new task1();
        t1_1.start();
        task2 t2_2 = new task2();
        t2_2.start();
        Thread.currentThread().setName("huli_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i_i+iiiiiiiii___");
        System.out.println(Thread.currentThread().getName());
    }
}

