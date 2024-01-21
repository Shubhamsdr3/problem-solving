package objectpool;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {

    private final Set<T>  available = new HashSet<>();
    private final Set<T> inUse = new HashSet<>();

    protected abstract T create();

    /**
     * If no instance is available then create new and put this in use.
     * @return
     */
    public synchronized T checkout() {
        if (available.isEmpty()) {
            available.add(create());
        }
        T instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void checkIn(T instance) {
        inUse.remove(instance);
        available.add(instance);
    }

    @Override
    public String toString() {
        return "ObjectPool{" +
                "available=" + available +
                ", inUse=" + inUse +
                '}';
    }
}