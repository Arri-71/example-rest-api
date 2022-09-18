package co.edu.unisabana.usuario.service.library.port;
import java.util.List;

import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;

public interface SearchBookPort {

    boolean validateExistsBook(String nameBook);
    List<BookEntity> searchBook (String SearchA);
    List<BookEntity> searchBook(int year);
}