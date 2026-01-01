package Multithreding;

public class interuptED extends  Thread{
    @Override
    public void run() {
        try {
            System.out.println(Thread.interrupted());
            System.out.println(Thread.interrupted());
            for (int i = 0; i < 4; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws  Exception  {
        interuptED t = new interuptED();
        t.start();
        t.interrupt();
    }
}
