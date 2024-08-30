package edu.eci.cvds.tdd.library;
import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.tdd.library.book.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class LibraryTest {
    private Library library;
    private Book book;
    @BeforeEach
    public void init(){
        library = new Library();
        book = new Book("Satanás","Mario Mendoza","666");
    }
    @Test
    public void shouldAddNewBook(){
        assertTrue(this.library.addBook(book));
    }
//    @Test
//    public void shouldExistsBook(){
//
//        assertTrue(this.library.getBooks().containsKey(this.book.getIsbn()));
//    }
//    @Test
//    public void shouldNotExistsBook(){
//        assertTrue(!this.library.getBooks().containsKey(this.book.getIsbn()));
//    }



}
