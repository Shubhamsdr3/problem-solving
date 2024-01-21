package designapatterns.creational.builder;

import designapatterns.creational.factory.OSTypes;

public class BuilderMain {

    public static void main(String[] args) {
        Phone phone = new Phone.PhoneBuilder()
                        .setBattery(10)
                        .setCamera(10)
                        .setOs(OSTypes.ANDROID.name()).build();
        System.out.println(phone.toString());
    }
}
