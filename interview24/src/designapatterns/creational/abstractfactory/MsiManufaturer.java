package designapatterns.creational.abstractfactory;

public class MsiManufaturer extends Company {
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
