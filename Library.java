public class Library {
  private Book[] books;
  private int bookCount;

  public Library() {
    books = new Book[100]; // Max 100 books to store
    bookCount = 0;
  }

  public void addBook(Book book) {
    if (bookCount < books.length) {
      books[bookCount++] = book; //Increament and Add the book
    }
  }

  public void displayBook() {
    for (int i = 0; i < bookCount; i++) {
      if (books[i].isAvailable()) {
        System.out.println("Book Name: " + books[i].getTitle() + ", Isbn: " + books[i].getIsbn()) ;
      }
    }
  }

 public Book searchBook(String isbn){
  for (int i = 0; i < bookCount; i++) {
    if(books[i].getIsbn().equals(isbn)){
      return books[i];  //return if found 
    }
  }
  return null; // not found
 }
}
