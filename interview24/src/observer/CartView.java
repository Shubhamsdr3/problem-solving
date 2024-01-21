package observer;

import javax.swing.text.View;

public class CartView {

    private static ProductDto productDto;

    private Cart.OnStateChangeListener listener = new Cart.OnStateChangeListener() {
        @Override
        public void onStateChange(View view) {
            // update the view.
        }
    };
}
