package DPPEx6;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        image.display();
        System.out.println();
        image.display();
    }
}