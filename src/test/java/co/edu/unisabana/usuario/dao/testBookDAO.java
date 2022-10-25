package co.edu.unisabana.usuario.dao;



import co.edu.unisabana.usuario.repository.dao.BookDao;
import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class testBookDAO {
    //tests unitarios funcion validateExistsBook
    @Test
    public void given_an_existing_book_wehn_validate_exist_book_return_true(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertTrue(testBookDao.validateExistsBook("Don Quijote"));
    }
    @Test
    public void given_an_inexisting_book_when_validate_exist_book_return_false(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertFalse(testBookDao.validateExistsBook("maria"));
    }
    //test de las tres salidas addBook
    @Test
    public void given_an_existing_book_when_add_book_return_true(){
        BookDao testCreateBookDao = new BookDao();
        testCreateBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertTrue(testCreateBookDao.addBook("Don Quijote"));
    }
    @Test
    public void given_an_existing_book_when_the_number_of_copys_is_equals_to_the_max_number_of_copys_trow_exeption(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        for(int i= 1;i<=10;i++){
            testBookDao.addBook("Don Quijote");
        }
        assertThrows(IllegalArgumentException.class, () -> {
            testBookDao.addBook("Don Quijote");
        });
    }
    @Test
    public void given_an_inexisting_book_wehn_addbook_trow_exeption(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertThrows(IllegalArgumentException.class, () -> {
            testBookDao.addBook("Maria");
        });
    }

    @Test
    public void given_an_inexisting_book_when_deleteBook_then_trow_exception(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertThrows(IllegalArgumentException.class, () -> {
            testBookDao.deleteBook("Maria");
        });
    }

    @Test
    public void given_an_existing_book_when_deleteBook_then_return_true(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertTrue(testBookDao.deleteBook("Don Quijote"));
    }

    @Test
    public void given_an_existing_book_when_searchAuthor_then_return_list(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        testBookDao.registerBook(new Book("libro 1", 1990, "daniel", false, CategoryBook.SOFT_COVER));
        testBookDao.registerBook(new Book("libro 2", 1993, "daniel", false, CategoryBook.SOFT_COVER));
        List<BookEntity> ExpectedlistBooks = new ArrayList<>();
        BookEntity bookEntity = BookEntity.fromModel(new Book("libro 1", 1990, "daniel", false, CategoryBook.SOFT_COVER));
        bookEntity.setId(ExpectedlistBooks.size() + 2);
        ExpectedlistBooks.add(bookEntity);
        bookEntity = BookEntity.fromModel(new Book("libro 2", 1993, "daniel", false, CategoryBook.SOFT_COVER));
        bookEntity.setId(ExpectedlistBooks.size() + 2);
        ExpectedlistBooks.add(bookEntity);
        assertEquals(ExpectedlistBooks,testBookDao.searchBook("daniel"));
    }

    @Test
    public void given_an_existing_book_when_searchYear_then_return_list(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        testBookDao.registerBook(new Book("libro 1", 1990, "daniel", false, CategoryBook.SOFT_COVER));
        testBookDao.registerBook(new Book("libro 2", 1993, "daniel", false, CategoryBook.SOFT_COVER));
        List<BookEntity> ExpectedlistBooks = new ArrayList<>();
        BookEntity bookEntity = BookEntity.fromModel(new Book("libro 1", 1990, "daniel", false, CategoryBook.SOFT_COVER));
        bookEntity.setId(ExpectedlistBooks.size() + 2);
        ExpectedlistBooks.add(bookEntity);
        assertEquals(ExpectedlistBooks,testBookDao.searchBook(1990));
    }
}
