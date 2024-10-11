package fr.ferreira.donovan.exam.service;

import fr.ferreira.donovan.exam.entity.User;
import fr.ferreira.donovan.exam.repository.UserRepository;
import fr.ferreira.donovan.exam.DTO.UserDTO;
import fr.ferreira.donovan.exam.exception.NotFoundExamException;
import fr.ferreira.donovan.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements DAOServiceInterface<User, UserDTO, String>, UserDetailsService {

    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User getObjectById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new NotFoundExamException("User", "id", id));
    }

    public User create(UserDTO userDTO) {
        User user = getObjectFromDTO(userDTO);
        // TODO complete dto -> object
        return userRepository.saveAndFlush(user);
    }

    public User update(UserDTO userDTO, String id) {
        User user = new User();
        if (id != null) {
            user = getObjectById(id);
        }
        user = getObjectFromDTO(userDTO);
        // TODO complete dto -> object
        return userRepository.saveAndFlush(user);
    }

    public User getObjectFromDTO(UserDTO userDTO) {
        return getObjectFromDTO(userDTO, new User());
    }

    public User getObjectFromDTO(UserDTO userDTO, User user) {
        // TODO Complete
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        User user = optionalUser.get();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                userGrantedAuthority(user.getRoles())
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Collections.singletonList(role);
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (r.contains("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        });
        return authorities;
    }
}
