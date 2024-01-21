package designapatterns.creational.restrauntfactory;

public class BurgerMain {

    public static void main(String[] args) {
        Restaurant beef = new BeefBurgerRestarunt();
        Burger beefBurger = beef.orderBurger();

        Restaurant veggie = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggie.orderBurger();


    }
}
