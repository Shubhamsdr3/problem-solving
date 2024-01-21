package observer;

import javax.swing.text.View;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    /**
     * Maintains listener attached to every view.
     */
    private static Map<OnStateChangeListener, View> viewListeners = new LinkedHashMap<>();

    /**
     * Maintains a bucket of listeners for each specific product bcz
     * a single product can be listed in many places (Views) in the app and each
     * view has it's own listner.
     */
    private static Map<ProductDto, List<OnStateChangeListener>> productListeners = new LinkedHashMap<>();

    public static void notifyAllListeners(ProductDto productDto) {
        List<OnStateChangeListener> x = productListeners.get(productDto);
        for (OnStateChangeListener listener: x) {
            View view = viewListeners.get(listener);
            listener.onStateChange(view);
        }
    }
    public interface OnStateChangeListener {
        void onStateChange(View view);
    }
}


