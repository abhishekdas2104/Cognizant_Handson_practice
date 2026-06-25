package DSAExercise.SortingCustomerOrder;

public class OrderSorting {
    static class Order {
        int id;
        String name;
        double price;
        Order(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
    static void bubbleSort(Order[] orders) {
        for(int i=0;i<orders.length-1;i++) {
            for(int j=0;j<orders.length-1-i;j++) {
                if(orders[j].price > orders[j+1].price) {
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }
    static void quickSort(Order[] orders, int low, int high) {
        if(low < high) {
            int p = partition(orders, low, high);
            quickSort(orders, low, p-1);
            quickSort(orders, p+1, high);
        }
    }
    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].price;
        int i = low;
        for(int j=low;j<high;j++) {
            if(orders[j].price < pivot) {
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
                i++;
            }
        }
        Order temp = orders[i];
        orders[i] = orders[high];
        orders[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101,"Abhishek",5000),
            new Order(102,"Rahul",2000),
            new Order(103,"Amit",8000),
            new Order(104,"Riya",3000)
        };
        System.out.println("Bubble Sort");
        bubbleSort(orders);
        for(Order o : orders) {
            System.out.println(o.id + " " + o.name + " " + o.price);
        }
        Order[] orders2 = {
            new Order(101,"Abhishek",5000),
            new Order(102,"Rahul",2000),
            new Order(103,"Amit",8000),
            new Order(104,"Riya",3000)
        };
        System.out.println("\nQuick Sort");
        quickSort(orders2,0,orders2.length-1);
        for(Order o : orders2) {
            System.out.println(o.id + " " + o.name + " " + o.price);
        }
    }
}
