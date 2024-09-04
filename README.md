# Laboratorio 03- TDD
*Integrantes:*

*-Jaider David Vargas Noriega.*

*-Laura Sofia Gil Chaves.*

## Desarrollo del laboratorio 03
### Crear un proyecto en Maven
La herramienta Maven nos ayuda a facilitar y optimizar procesos de desarrollo y hacerlos en el menor tiempo posible. Se creó un proyecto en Maven con los siguientes parámetros:
```yml
Grupo: edu.eci.cvds 
Artefacto: Library 
Paquete: edu.eci.cvds.tdd 
archetypeArtifactId: maven-archetype-quickstart 
```
![image](https://github.com/user-attachments/assets/b4cfe80f-44d9-452e-9b50-fdf71bbd7db7)
![image](https://github.com/user-attachments/assets/1e2c790f-a645-49c6-9839-17cd86d31dcc)
![image](https://github.com/user-attachments/assets/cbf455e5-6aa6-4174-81aa-1960a85a1c72)
### Agregar dependencia JUNIT5
Primero buscamos en maven central la dependencia de JUnit 5 en la versión más reciente. 
![image](https://github.com/user-attachments/assets/551b6bfe-c649-403e-82bf-50e6cd84aafe)
Luego, editamos el archivo pom.xml del proyecto para agregar la dependencia, verificando la versión de java.
![image](https://github.com/user-attachments/assets/82426c10-28b5-4bcf-99b9-4aad6f58d246)
### Agregar esqueleto del proyecto
Se crearon los siguientes paquetes dentro de```edu.eci.cvds.tdd``` en la carpeta src como en test.
![image](https://github.com/user-attachments/assets/0a326a5c-085a-4ad2-9ca4-0962727ab46f)

### Agregar clases 
En el paquete ```edu.eci.cvds.tdd.library``` se creó las siguientes clases.

![image](https://github.com/user-attachments/assets/6d8db0b4-d292-4da3-a7f4-b7ecbdea3e59)

```java
package edu.eci.cvds.tdd.library.book;
public class Book {
    private final String tittle;
    private final String author;
    private final String isbn;
    public Book(String tittle, String author, String isbn) {
        this.tittle = tittle;
        this.author = author;
        this.isbn = isbn;
    }
    public String getTittle() {
        return tittle;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    @Override
    public boolean equals(Object obj) {
        return isbn.equals(((Book)obj).isbn);
    }
}
```
```java
package edu.eci.cvds.tdd.library.user;
public class User {
    private String name;
    private String id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
```
```java
package edu.eci.cvds.tdd.library.loan;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;
import java.time.LocalDateTime;
public class Loan {
    private Book book;
    private User user;
    private LocalDateTime loanDate;
    private LoanStatus status;
    private LocalDateTime returnDate;
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
    public LoanStatus getStatus() {
        return status;
    }
    public void setStatus(LoanStatus status) {
        this.status = status;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
```
```java
package edu.eci.cvds.tdd.library.loan;
public enum LoanStatus {
    ACTIVE, RETURNED
}
```
```java
package edu.eci.cvds.tdd.library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Library responsible for manage the loans and the users.
 */
public class Library {
    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;
    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }
    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        //TODO Implement the logic to add a new book into the map.
        return false;
    }
    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        //TODO Implement the login of loan a book to a user based on the UserId and the isbn.
        return null;
    }
    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        //TODO Implement the login of loan a book to a user based on the UserId and the isbn.
        return null;
    }
    public boolean addUser(User user) {
        return users.add(user);
    }
}
```
Se compila con ```mvn package``` la estructura del proyecto.

![image](https://github.com/user-attachments/assets/e73d3718-456d-4e08-bc9f-a142df25ee83)

### Pruebas Unitarias y TDD
Para poder implementar los métodos ```addBook, loanABook y returnLoan``` de la clase ```Library``` se aplicó la técnica de TDD, por cada caso de prueba se hizo un commit.

Se realizan las pruebas para el método addBook, donde primero escribimos las pruebas unitarias antes de desarrollar el método en este caso ```shouldAddNewBook``` que válida si existe un libro y ```should_AddNwBook_WhenNotExists``` que válida si no existe un libro.

![image](https://github.com/user-attachments/assets/42573889-3554-4ff4-bf96-57a6f6d3141e)
![image](https://github.com/user-attachments/assets/1a1c3aa6-4e5d-4997-af09-da76f63b50fe)
En este punto debería fallar las pruebas porque aún no hay nada desarrollado en el método.

![image](https://github.com/user-attachments/assets/47be8a04-d2f0-47cb-97b8-8616e039e35b)
Se realiza el método para que funcionen las pruebas unitarias.

![image](https://github.com/user-attachments/assets/83f55b64-f1cf-4e3c-934c-170cab2f1052)
Volvemos a ejecutar las pruebas dando como resultado que son correctas.
![image](https://github.com/user-attachments/assets/f8168d0f-aedd-486e-a411-9da4bea5f91e)


### Referencias:
