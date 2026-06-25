package DSAExercise.LibraryManagement;

public class LibraryManagement {

    static class Book {
        int id;
        String title;
        Book(int id, String title) {
            this.id = id;
            this.title = title;
        }
    }
    static void linearSearch(Book[] books, String title) {
        for(Book b : books) {
            if(b.title.equals(title)) {
                System.out.println("Book Found " +  b.title);
                return;
            }
        }
        System.out.println("Not Found");
    }
    static void binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(books[mid].title.equals(title)) {
                System.out.println("Book Found " +  books[mid].title);
                return;
            }
            if(title.compareTo(books[mid].title) > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println("Not Found");
    }
    public static void main(String[] args) {
        Book[] books = {
            new Book(1,"C"),
            new Book(2,"Java"),
            new Book(3,"Python"),
            new Book(4,"SQL")
        };
        linearSearch(books, "Python");
        binarySearch(books, "DBMS");
    }
}