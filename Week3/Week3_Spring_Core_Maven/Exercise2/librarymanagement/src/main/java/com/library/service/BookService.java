package service;

import com.library.repository.BookRepository;

public class BookService {
  private BookRepository bookRepository;

  public BookRepository getBookRepository() {
    return bookRepository;
  }

  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void listBooks() {
    System.out.println("BookService: Performing operation");
    bookRepository.printBookList();
  }

}
