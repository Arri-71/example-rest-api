package co.edu.unisabana.usuario.service.user;

import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.user.api.IRegisterUserPort;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private final IRegisterUserPort IRegisterUserPort;

    RegisterUserService(IRegisterUserPort IRegisterUserPort) {
        this.IRegisterUserPort = IRegisterUserPort;
    }

    //Un codigo con muchas salidas, tiene MAYOR complejidad ciclomatica
    public int registerUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (user.getAge() < 18) {
            throw new RuntimeException("The age cannot be minior 18");
        }

        boolean result = IRegisterUserPort.addNewUser(user);

        if (result) {
            return 10;
        } else {
            return 3;
        }
    }

}