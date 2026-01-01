package Multithreding;

public class InterruptMethod extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (Exception e){
            for (int i = 0; i < 6; i++) {
                System.out.println("Interrupt happening daa....!");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        InterruptMethod t = new InterruptMethod();
        t.start();
        t.interrupt();
    }
}
