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
        this.library = new Library();
        this.book = new Book("Satanás","Mario Mendoza","666");
    }
    @Test
    public void should_AddNewBook_WhenNotExists(){
        assertTrue(this.library.addBook(book));
    }
    @Test
    public void should_AddBook_WhenTheBookAlredyExists(){
        this.library.addBook(book);
        assertTrue(this.library.addBook(book));
    }
    @Test
    public void should_IncreaseQuantity_WhenTheBookAlredyExists(){
        this.library.addBook(book);
        this.library.addBook(book);
        assertEquals(this.library.getBooks().get(book),2);
    }
    @Test
    public void should_StartsWithOneBook_WhenIsNew(){
        this.library.addBook(book);
        assertEquals(this.library.getBooks().get(book),1);
    }
    @Test
    public void sholdNot_addBook_whenItIsNull(){
        assertFalse(this.library.addBook(null));
    }

    @Test
    public void shouldNot_addBook_whenItHasSameIsbnButDifferentNameOrAuthor(){
        this.library.addBook(book);
        Book invalidBook = new Book("Scorpio City","Mario Mendoza","666");
        assertFalse(this.library.addBook(invalidBook));

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
