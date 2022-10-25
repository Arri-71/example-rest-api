package co.edu.unisabana.usuario.service.user.api;

import co.edu.unisabana.usuario.service.model.User;

public interface IRegisterUserPort {

  boolean addNewUser(User user);
}
