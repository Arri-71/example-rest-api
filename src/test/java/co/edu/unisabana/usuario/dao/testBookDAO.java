package co.edu.unisabana.usuario.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import co.edu.unisabana.usuario.repository.dao.BookDao;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;


public class testBookDAO {
    //tests unitarios funcion validateExistsBook
    @Test
    public void given_an_existing_book_wehn_validate_exist_book_return_true(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertTrue(testBookDao.validateExistsBook("Don Quijote"));
    }
    @Test
    public void given_an_inexisting_book_wehn_validate_exist_book_return_false(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertFalse(testBookDao.validateExistsBook("maria"));
    }
    //test de las tres salidas addBook
    @Test
    public void given_an_existing_book_wehn_add_book_return_true(){
        BookDao testBookDao = new BookDao();
        testBookDao.registerBook(new Book("Don Quijote", 1605, "miguel de servantes", false, CategoryBook.SOFT_COVER));
        assertTrue(testBookDao.addBook("Don Quijote"));
    }
    @Test
    public void given_an_existing_book_wehn_the_number_of_copys_is_equals_to_the_max_number_of_copys_trow_exeption(){
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
}
