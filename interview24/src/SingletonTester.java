import designapatterns.creational.singleton.NonBreakableSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTester {

    public static void main(String[] args) {
        // fist instance
        NonBreakableSingleton instance1 = NonBreakableSingleton.getInstance();

        // 2nd instance
        NonBreakableSingleton instance2 = null;
        try {
            Class<NonBreakableSingleton> clazz = NonBreakableSingleton.class;
            Constructor<NonBreakableSingleton> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println("Instance 1 hash" + instance1.hashCode());
        System.out.println("Instance 2 hash" + instance2.hashCode());
    }
}
