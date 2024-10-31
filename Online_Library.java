import java.util.Scanner;

public class Online_Library {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Library lib = new Library();

    lib.addBook(new Book("1984", "George Orwell", "123"));
    lib.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "456"));
    lib.addBook(new Book("Harry Potter", "J K Rowling", "789"));

    User user = new User("Hash");
    System.out.println("Available Books");
    lib.displayBook();

    while (true) {
      System.out.println("Enter 1 to borrow the book , 2 to return the book and 0 to exit:");
      int choice = sc.nextInt();
      sc.nextLine();

      if (choice == 1) {
        // isbn id to borrow:
        System.out.print("Enter ISBN id to borrow the Book: ");
        String isbnToBorrow = sc.nextLine();

        Book bookToBorrow = lib.searchBook(isbnToBorrow); // borrowed with isbn id

        if (bookToBorrow != null) {
          user.borrowBook(bookToBorrow);
        } else {
          System.out.println("Book not found");
        }

        System.out.println("Available books after borrowing");
        lib.displayBook();
      }
       else if (choice == 2) {
        System.out.print("Enter the ISBN id to return the book: ");
        String isbnToReturn = sc.nextLine();
        user.returnBook(isbnToReturn, lib);


        System.out.println("Available books after returning");
        lib.displayBook();
      }
       else if (choice == 0) {
        System.out.println("Exit");
        break;
      } 
      else {
        System.out.println("Invaid choice, Please enter 1, 2 or 0");
      }
    }

    sc.close();
    System.out.println("Thank You for using the library system.");
  }
}
