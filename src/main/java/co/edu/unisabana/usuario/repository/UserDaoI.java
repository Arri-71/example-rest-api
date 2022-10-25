package co.edu.unisabana.usuario.repository;

import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.user.api.IRegisterUserPort;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoI implements IRegisterUserPort {

  @Override
  public boolean addNewUser(User user) {

    return false;
  }
}
