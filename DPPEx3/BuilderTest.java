package DPPEx3;

public class BuilderTest {
    public static void main(String[] args) {

        Computer c = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam(8)
                .build();
        c.display();
    }
}
