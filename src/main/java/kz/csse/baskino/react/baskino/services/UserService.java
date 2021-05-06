package kz.csse.baskino.react.baskino.services;


import kz.csse.baskino.react.baskino.entities.Roles;
import kz.csse.baskino.react.baskino.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Users createUser(Users users);
    Users saveUser(Users user);
    Users getUserByEmail(String email);

    Users updateUserPassword(Users user, String oldpassword, String newPassword);
    List<Users> getAllUsers();

    Users getUser(Long id);

    List<Roles> getAllRoles();

    Roles addRoles(Roles role);

    Roles saveRole(Roles role);

    Roles getRole(Long id);

    void deleteUser(Users users);

    void deletRole(Roles role);

}
