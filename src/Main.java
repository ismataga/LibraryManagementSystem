import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    Book book = new Book();
    Scanner sc = new Scanner(System.in);
    Library librarys = new Library();

    Order order = new Order();

    public static void main(String[] args) throws BookNotFounded {
        Main main = new Main();
        main.callMenu();
        ;
    }

    private void callMenu() throws BookNotFounded {
        while (true) {
            int option = printCallMenuCommand();
            if (chooseMenuOption(option)) return;
        }
    }

    private boolean chooseMenuOption(int option) throws BookNotFounded {
        switch (option) {
            case 0 -> {
                return true;
            }
            case 1 -> addBook();
            case 2 -> getBook();
            case 3 -> createOrder();
            case 4 -> getOrder();
            case 5 -> updateBook();
            case 6 -> searchByName();
            default -> System.out.println("Invalid option");
        }
        return false;
    }

    private int printCallMenuCommand() {
        System.out.println("" +
                "----|Enter menu|----");
        System.out.println("0. Exit system\n" +
                "1. Add book\n" +
                "2. Get book\n" +
                "3. CreateOrder\n" +
                "4. GetOrder\n" +
                "5. UpdateOrder\n" +
                "6. searchByName\n");
        int option = inputInt("Enter menu option: ");
        return option;
    }

    public void addBook() {

        long bookId = inputLong("Enter book id: ");

        String bookName = inputString("Enter book name: ");
        String authorName = inputString("Enter author name: ");

        Book book = new Book(bookId, bookName, authorName);
        librarys.addBook(book);
    }

    public void updateBook() {

//        String bookName = inputString("Enter book name: ");
//        String authorName = inputString("Enter author name: ");
//        Book updateBooks = new Book( bookName, authorName);
        long id = inputLong("Enter updated book id");
        for (Book book : librarys.getBooks()) {
            if (book.getBookId() == id) {
                String authorName = inputString("Enter author name: ");
                book.setBookName(authorName);
                String bookName = inputString("Enter book name: ");
                book.setBookAuthor(bookName);
            }
        }
    }

    public void searchByName() throws BookNotFounded {
        String searchName = inputString("Enter book name: ");
        for (Book books : librarys.getBooks()) {
            if (books.getBookName() != null) {
                for (Book book : librarys.getBooks()) {
                    if (book.getBookName().equals(searchName)) {
                        System.out.println(book);
                        return;
                    }
                }
            } else {
                throw new BookNotFounded("Axtardigniz adda kitab yoxdur");
            }

//
//            for (Book book : librarys.getBooks()) {
//                if (!book.getBookName().equals(searchName)) {
//                    throw new BookNotFounded("Axtardigniz adda kitab yoxdur");
//                }else {
//                    System.out.println(book);
//                    return;
//                }
//            }


        }

    }

    public void getBook() {
        System.out.println("-----------Books----------");
        List<Book> books = librarys.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void createOrder() {
        while (true) {
            int option = printOrderCommand();
            if (option == 1) {
                long id = inputLong("Enter book id");
                for (Book book : order.getBooks()) {
                    if (book.getBookId() == id) {
                        System.out.println("This book is rented");
                    }
                }
            } else if (option == 2) {
                long id = inputLong("Enter book id");
                addBooks(id);
            } else {
                return;
            }
        }
    }

    private int printOrderCommand() {
        System.out.println("------|Create Order|------------ ");
        System.out.println("1.Check order book: ");
        System.out.println("2.Order book: ");
        System.out.println("3.Exit: ");
        int option = inputInt("Enter menu option: ");
        sc.nextLine();
        return option;
    }

    public void getOrder() {
        System.out.println("-----------Books----------");
        List<Book> books = order.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }


    private long inputLong(String title) {
        System.out.println(title);
        long inputLong = sc.nextLong();
        return inputLong;
    }


    private String inputString(String title) {

        System.out.println(title);
        String inputString = sc.next();
        return inputString;
    }

    private int inputInt(String title) {
        System.out.println(title);
        int inputInt = sc.nextInt();
        return inputInt;
    }

    public void addBooks(long id) {
        for (Book book : librarys.getBooks()) {
            if (book.getBookId() == id) ;
            order.addMeal(book);
        }
    }

}