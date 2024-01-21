package designapatterns.creational.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * Singleton pattern can be broken in three ways:
 *  1. Reflection
 *  2. Serialization/deserialization
 *  3. cloning
 *
 *  We can prevent this following the pattern in this class.
 */
public class NonBreakableSingleton implements Serializable, Cloneable {

    /**
     * Using Volatile keyword, it's possible for another thread in Java to see half intialized state of instance.
     */
    private static volatile NonBreakableSingleton instance = null;

    /**
     * To prevent the single pattern breaking using reflection.
     */
    private NonBreakableSingleton() {
        if (instance != null) {
            throw new RuntimeException("Instance already exist");
        }
    }

    /**
     * Lazy initialization.
     * @return
     */
    public static NonBreakableSingleton getInstance() {
        if (instance == null) {
            synchronized (NonBreakableSingleton.class) {
                if (instance == null) {
                    instance = new NonBreakableSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * Prevent breaking of singleton pattern using cloning.
     * @return
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * Prevent breaking of singleton pattern using serialization/deserialization
     * @return
     */
    @Serial
    protected Object readResolve() {
        return instance;
    }
}
