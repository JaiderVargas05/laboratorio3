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
    }
    @Test
    public void shouldExistsBook(){
        assertTrue(library.getBooks().containsKey(book.getIsbn()));
    }
    @Test
    public void shouldNotExistsBook(){
        assertTrue(!library.getBooks().containsKey(book.getIsbn()));
    }

}
