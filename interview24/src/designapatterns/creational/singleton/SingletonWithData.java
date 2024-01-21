package designapatterns.creational.singleton;

public class SingletonWithData {

    private static volatile SingletonWithData instance;
    private String data; // username/password in case of database

    private SingletonWithData(String data) {
        this.data = data;
    }

    public static SingletonWithData getInstance(String data) {
        SingletonWithData result = instance;
        if (result == null) { // avoid locking in case of already existing instance.
            synchronized (SingletonWithData.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SingletonWithData(data);
                }
            }
        }
        return result;
    }

}
