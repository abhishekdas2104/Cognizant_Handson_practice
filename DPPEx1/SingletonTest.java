package DPPEx1;

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Application Started");
        logger2.log("User Logged In");
        System.out.println(logger1 == logger2);
    }
}

