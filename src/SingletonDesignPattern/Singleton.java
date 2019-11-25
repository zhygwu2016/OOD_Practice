package SingletonDesignPattern;

public class Singleton {

    private static Singleton instance = null;

    protected Singleton(){
        System.out.println("This is the SingletonDesignPattern.Singleton Class");
    }

    public static Singleton getSingletonInstance(){

        if(instance == null){
                synchronized (Singleton.class){
                    if (instance == null){
                        instance = new Singleton();
                    }
                }
        }

        return instance;
    }
}
