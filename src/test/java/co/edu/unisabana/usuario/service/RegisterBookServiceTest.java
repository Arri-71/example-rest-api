package co.edu.unisabana.usuario.service;

import co.edu.unisabana.usuario.service.library.RegisterBookLibrary;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.DeleteBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RegisterBookServiceTest {

    @InjectMocks
    private RegisterBookLibrary service;
    @Mock
    private SearchBookPort searchBookPort;

    @Mock
    private AddBookPort addBookPort;

    @Mock
    private RegisterBookPort registerBookPort;

    @Mock
    private DeleteBookPort deleteBookPort;


    @Test
    public void Given_Book_Exist_When_RegisterBook() {
        CategoryBook categoryBook = CategoryBook.fromString("suave");
        Book book = new Book("Satanas", 1986,
                "Mario mendoza", false, categoryBook);
        Mockito.when(searchBookPort.validateExistsBook(book.getName())).thenReturn(true);
        int result = service.registerBook(book);
        assertEquals(1, result);

    }
}