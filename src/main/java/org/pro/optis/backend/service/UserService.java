package org.pro.optis.backend.service;

import lombok.AllArgsConstructor;
import org.pro.optis.backend.TypeRole;
import org.pro.optis.backend.bo.Role;
import org.pro.optis.backend.bo.User;
import org.pro.optis.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }


    public void signin(User user){
        // validity mail check
        if(!user.getEmail().contains("@") || !user.getEmail().contains(".")){
            throw  new RuntimeException("Email invalid");
        }
        Optional<User> userOptional =  this.userRepository.findByEmail(user.getEmail());


        if(userOptional.isPresent()) throw new RuntimeException("Mail already used.");

        //pwd
        String CryptedPwd = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(CryptedPwd);

        //role
        Role roleUser = new Role();
        if (user.getCompany() != null) {
            roleUser.setRole(TypeRole.COMPANY);
        } else {
            roleUser.setRole(TypeRole.USER);
        }

        if(roleService.findRoleByName(roleUser.getRole()) != null){
            user.setRole(roleService.findRoleByName(roleUser.getRole()));
        }else {
            user.setRole(roleUser);
        }

        //date
        Instant date = Instant.now();
        user.setDate_created(date);
        user.setDate_updated(date);

        user = this.userRepository.save(user);
    }
}
