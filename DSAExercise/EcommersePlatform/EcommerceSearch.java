package DSAExercise.EcommersePlatform;

public class EcommerceSearch {
    static class Product {
        int productId;
        String productName;
        String category;
        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
    }
    static void linearSearch(Product[] products, int id) {
        for(int i = 0; i < products.length; i++) {
            if(products[i].productId == id) {
                System.out.println("Product Found: " + products[i].productName);
                return;
            }
        }
        System.out.println("Product Not Found");
    }
    static void binarySearch(Product[] products, int id) {
        int low = 0;
        int high = products.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(products[mid].productId == id) {
                System.out.println("Product Found: " + products[mid].productName);
                return;
            }
            if(id > products[mid].productId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println("Product Not Found");
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Monitor", "Electronics")
        };
        System.out.println("Linear Search:");
        linearSearch(products, 103);

        System.out.println("Binary Search:");
        binarySearch(products, 104);
    }
}