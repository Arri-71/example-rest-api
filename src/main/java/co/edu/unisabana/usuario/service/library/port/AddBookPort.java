package co.edu.unisabana.usuario.service.library.port;

import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.repository.dao.BookDao;

public interface AddBookPort {

    boolean addBook(String name);
}
