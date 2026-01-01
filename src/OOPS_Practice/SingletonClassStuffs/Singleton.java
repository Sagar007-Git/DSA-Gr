package OOPS_Practice.SingletonClassStuffs;

public class Singleton {
    private static Singleton Instance;

    public static Singleton getInstance(){

        if(Instance==null){

            synchronized (Singleton.class){

                if(Instance==null){

                    Instance = new Singleton();
                }
            }
        }
        return Instance;
    }
}
