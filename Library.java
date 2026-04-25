import java.io.*;
import java.util.*;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    public void addMember(int id, String name) {
        members.add(new Member(id, name));
        System.out.println("Member added!");
    }

    public void issueBook(int bookId, int memberId) {
        for(Book b : books) {
            if(b.id == bookId && b.isAvailable) {
                b.isAvailable = false;
                System.out.println("Book issued to Member " + memberId);
                return;
            }
        }
        System.out.println("Book not available!");
    }

    public void returnBook(int bookId) {
        for(Book b : books) {
            if(b.id == bookId && !b.isAvailable) {
                b.isAvailable = true;
                System.out.println("Book returned!");
                return;
            }
        }
        System.out.println("Invalid return!");
    }

    public void showBooks() {
        System.out.println("\n--- All Books ---");
        for(Book b : books) {
            b.display();
        }
    }

    public void saveBooksToFile() {
        try {
            FileWriter fw = new FileWriter("books.txt");
            for(Book b : books) {
                fw.write(b.id + "," + b.title + "," + b.author + "," + b.isAvailable + "\n");
            }
            fw.close();
            System.out.println("Books saved to file!");
        } catch(IOException e) {
            System.out.println("Error saving!");
        }
    }

    public void loadBooksFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Book b = new Book(Integer.parseInt(parts[0]), parts[1], parts[2]);
                b.isAvailable = Boolean.parseBoolean(parts[3]);
                books.add(b);
            }
            br.close();
            System.out.println("Books loaded!");
        } catch(IOException e) {
            System.out.println("No previous data found.");
        }
    }
}
