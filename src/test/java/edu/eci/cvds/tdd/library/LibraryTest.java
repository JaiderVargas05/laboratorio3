package edu.eci.cvds.tdd.library;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LibraryTest {
    @Test
    public void addbooktext1(){
        //corregir
        Map<String, Integer> book = new HashMap<>();
        book.put("Satanas",1);
        assertTrue(Library.addBook(book,1));
    }
}
