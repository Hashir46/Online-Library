public class User {
  private String name;
  private Book borrowedBook;

  public User(String name) {
    this.name = name;
    this.borrowedBook = null; //Initially null
  }

  public String getName() {
    return name;
  }

  // Borrowing Book:
  public void borrowBook(Book book) {
    if (book.isAvailable()) {
      book.setAvailable(false); //assigns the book has been borrowed by User
      this.borrowedBook = book;
      System.out.println(name + " borrowed " + book.getTitle() + " book");
    } else {
      System.out.println("Book is not Available");
    }
  }

  // Returning Book
  public void returnBook(String isbn, Library lib) {
    if (borrowedBook != null && borrowedBook.getIsbn().equals(isbn)) {
      borrowedBook.setAvailable(true); // book has been returned by the User
      System.out.println(name + " has been returned " + borrowedBook.getTitle() + " book");
      borrowedBook = null;
    } else {
      System.out.println("No book to return");
    }
  }
}
