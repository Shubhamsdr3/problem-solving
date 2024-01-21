package designapatterns.creational.restrauntfactory;

public class BeefBurgerRestarunt extends Restaurant {

    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
