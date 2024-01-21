package designapatterns.creational.builder;

public class Phone {

    private String os;
    private String processor;

    private int battery;

    private int camera;

    /**
     * Make the constructor private.
     * @param os
     * @param processor
     * @param battery
     * @param camera
     */
    private Phone(String os, String processor, int battery, int camera) {
        this.os = os;
        this.processor = processor;
        this.battery = battery;
        this.camera = camera;
    }

    static class PhoneBuilder {

        private String os;
        private String processor;

        private int battery;

        private int camera;

        public PhoneBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public PhoneBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public PhoneBuilder setBattery(int battery) {
            this.battery = battery;
            return this;
        }

        public PhoneBuilder setCamera(int camera) {
            this.camera = camera;
            return this;
        }

        /**
         * Creating object
         * @return
         */
        public Phone build() {
            return new Phone(os, processor, battery, camera);
        }
    }
}
