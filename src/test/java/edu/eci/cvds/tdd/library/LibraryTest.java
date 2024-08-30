package edu.eci.cvds.tdd.library;
import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class LibraryTest {
    private Library library;
    private Book book;
    private User user;
    @BeforeEach
    public void init(){
        this.library = new Library();
        this.book = new Book("Satanás","Mario Mendoza","666");
        this.user = new User();
        user.setName("Sofia");
        user.setId("123");
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

    @Test
    public void shouldNot_addBook_whenItHasEmptyOrNullIsbn(){
        Book invalidBook1 = new Book("Halo","Epic",null);
        assertFalse(this.library.addBook(invalidBook1));
        Book invalidBook2 = new Book("Halo","Epic","");
        assertFalse(this.library.addBook(invalidBook2));
    }
    @Test
    public void should_loanABook_whenUserAndBookExists(){
        this.library.addUser(user);
        this.library.addBook(book);
        Loan loan = this.library.loanABook(user.getId(),book.getIsbn());
        assertEquals(loan.getBook(),book);
        assertEquals(loan.getUser(),user);
        assertEquals(this.library.getLoans().size(),1);
    }
    @Test
    public void shouldNot_loanABook_whenBookNotExists(){
        this.library.addUser(user);
        assertThrows(IllegalArgumentException.class,() -> this.library.loanABook(user.getId(),book.getIsbn()));
    }
    @Test
    public void shouldNot_loanABook_whenUserNotExists(){
        this.library.addBook(book);
        assertThrows(IllegalArgumentException.class,() -> this.library.loanABook(user.getId(),book.getIsbn()));
    }
    @Test
    public void shouldNot_loanABook_whenUserOrBookIsNull(){
        this.library.addBook(book);
        assertThrows(IllegalArgumentException.class,() -> this.library.loanABook(null,null));
    }
    @
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
