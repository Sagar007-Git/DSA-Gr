package Multithreding;

class Medical extends  Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println();
            System.out.println("Welcome to Medical Test");
            Thread.sleep(1500);
            for (int i = 0; i < 6; i++) {
                System.out.println("Medical Checkup " + i + " pass" );
                Thread.sleep(i*500);
            }
            System.out.println("All Medical Checkups are verified");
            Thread.sleep(1000);
            System.out.println("Approved for Driving Test ");
            Thread.sleep(1000);
            System.out.println("Forwarding all details to Driving Test center!!");
            Thread.sleep(2000);
            System.out.println("Loading......");
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

class Drivingtest extends Thread{
    @Override
    public void run() {
        try {

            Thread.sleep(1000);
            System.out.println();
            System.out.println("Welcome to Drivingtest");
            Thread.sleep(1000);
            for (int i = 0; i < 3; i++) {
                System.out.println("Driving Test "+i+" pass");
                Thread.sleep(i*500);
            }
            Thread.sleep(2500);
            System.out.println("Eligible for License ");
            Thread.sleep(1500);
            System.out.println("Forwarding All the results to Officer Department");
            Thread.sleep(500);
            System.out.println("Loading........");
            Thread.sleep(2500);
            System.out.println("Sent successfully......!");
            Thread.sleep(1000);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

class OfficerDept extends  Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println();
            System.out.println("Welcome to OfficerDept");
            Thread.sleep(1500);
            System.out.println("loading all the Documents");
            Thread.sleep(2500);
            System.out.println("Verifying the documents");
            Thread.sleep(5500);
            System.out.println("Verified");
            Thread.sleep(1500);
            System.out.println("Licence will be sent throw a post..!");
            Thread.sleep(1000);
            System.out.println("Thank you for Application");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
public class LicenseApproval {
    public static void main(String[] args) throws Exception {
        Medical m = new Medical();
        m.start();
        m.join();
        Drivingtest d = new Drivingtest();
        d.start();
        d.join();
        OfficerDept o = new OfficerDept();
        o.start();
    }
}
