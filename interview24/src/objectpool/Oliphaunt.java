package objectpool;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * A giant object which is expensive to create.
 */
public class Oliphaunt {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;

    public Oliphaunt() {
        id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Oliphaunt{" +
                "id=" + id +
                '}';
    }
}
