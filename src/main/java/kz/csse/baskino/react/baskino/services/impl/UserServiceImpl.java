package kz.csse.baskino.react.baskino.services.impl;
import kz.csse.baskino.react.baskino.entities.Roles;
import kz.csse.baskino.react.baskino.entities.Users;
import kz.csse.baskino.react.baskino.repositories.RoleRepository;
import kz.csse.baskino.react.baskino.repositories.UserRepository;
import kz.csse.baskino.react.baskino.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(Users users) {
        userRepository.delete(users);
    }

    @Override
    public Users createUser(Users users) {
        Users checkUser = userRepository.findByEmail(users.getEmail());
        if (checkUser == null) {
            Roles role = roleRepository.findByRole("ROLE_USER");
            if (role != null) {
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                users.setRoles(roles);
                users.setPassword(passwordEncoder.encode(users.getPassword()));

                return userRepository.save(users);
            }
        }
        return null;
    }










    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user=userRepository.findByEmail(s);
        if(user!=null){
            return user;
        }
        else
            throw new UsernameNotFoundException("USER NOT FOUND");
    }



    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users updateUserPassword(Users user, String oldpassword, String newPassword) {
        if (passwordEncoder.matches(oldpassword , user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Roles addRoles(Roles role) {
        if(roleRepository.findByRole(role.getRole())==null) {
            return roleRepository.save(role);
        }
        return null;
    }


    @Override
    public Roles saveRole(Roles role) {
        return roleRepository.save(role);
    }
    @Override
    public Users getUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Roles getRole(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public void deletRole(Roles role) {
        roleRepository.delete(role);
    }



}
