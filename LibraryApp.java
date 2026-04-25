import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.loadBooksFromFile();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== LIBRARY MANAGEMENT ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Save & Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Book ID: "); int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    lib.addBook(bid, title, author);
                    break;
                case 2:
                    System.out.print("Member ID: "); int mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    lib.addMember(mid, name);
                    break;
                case 3:
                    System.out.print("Book ID: "); int bId = sc.nextInt();
                    System.out.print("Member ID: "); int mId = sc.nextInt();
                    lib.issueBook(bId, mId);
                    break;
                case 4:
                    System.out.print("Book ID to return: "); int rId = sc.nextInt();
                    lib.returnBook(rId);
                    break;
                case 5:
                    lib.showBooks();
                    break;
                case 6:
                    lib.saveBooksToFile();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 6);
        sc.close();
    }
}
