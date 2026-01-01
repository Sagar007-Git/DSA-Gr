package Multithreding;

public class joinMethod extends Thread {
    static Thread mainthread;
    @Override
    public void run() {
        try {
            mainthread.join();
            for (int i = 0; i < 6; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" "+ i);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception{
        mainthread = Thread.currentThread();
        joinMethod j = new joinMethod();
        j.start();
        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" "+ i);
        }
    }
}
