package DPPEx3;

public class Computer {
    String cpu;
    int ram;
    private Computer(Builder b) {
        cpu = b.cpu;
        ram = b.ram;
    }
    void display() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " GB");
    }
    static class Builder {
        String cpu;
        int ram;
        Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }
        Computer build() {
            return new Computer(this);
        }
    }
}
