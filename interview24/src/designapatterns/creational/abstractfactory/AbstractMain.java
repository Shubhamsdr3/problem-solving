package designapatterns.creational.abstractfactory;

public class AbstractMain {

    public static void main(String[] args) {
        Company msiComp = new MsiManufaturer();
        msiComp.assembleGpu();
        msiComp.assembleMonitor();

        Company asusCom= new AsusManufacturer();
        asusCom.assembleGpu();
        asusCom.assembleMonitor();
    }
}
