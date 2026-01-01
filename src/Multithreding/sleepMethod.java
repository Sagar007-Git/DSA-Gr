package Multithreding;

public class sleepMethod  extends  Thread {
    @Override
    public void run() {
            try {
                for (int i = 0; i < 6; i++) {
                    Thread.sleep(1050);
                    System.out.println(Thread.currentThread().getName()+ " "+i);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }

    }

    public static void main(String[] args) throws Exception {
        sleepMethod t = new sleepMethod();
        t.run();
        sleepMethod t1 = new sleepMethod();
        t1.run();
//        for (int i = 0; i < 6; i++) {
//            Thread.sleep(1000);
//            System.out.println("main : "+i);
//        }
    }
}
