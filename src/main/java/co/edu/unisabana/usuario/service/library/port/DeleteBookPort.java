package co.edu.unisabana.usuario.service.library.port;
import co.edu.unisabana.usuario.repository.dao.BookDao;

public interface DeleteBookPort {
    boolean deleteBook(String name);
}