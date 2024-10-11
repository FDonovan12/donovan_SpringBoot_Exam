package fr.ferreira.donovan.exam.service;

import fr.ferreira.donovan.exam.entity.User;
import fr.ferreira.donovan.exam.repository.UserRepository;
import fr.ferreira.donovan.exam.DTO.UserDTO;
import fr.ferreira.donovan.exam.exception.NotFoundExamException;
import fr.ferreira.donovan.exam.service.interfaces.DAOServiceInterface;
import jakarta.xml.bind.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

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
        user.setRoles("[\"ROLE_USER\"]");
        user.setCreatedAt(LocalDateTime.now());
        user.setLevel(1);
        return userRepository.saveAndFlush(user);
    }

    public User getUserFromPrincipal(Principal principal) {
        return userRepository.findByEmail(loadUserByUsername(principal.getName()).getUsername())
                .orElseThrow(() -> new NotFoundExamException("User", "principal.getName()", principal.getName()));
    }

    public User update(UserDTO userDTO, String id) {
        User user = new User();
        if (id != null) {
            user = getObjectById(id);
        }
        user = getObjectFromDTO(userDTO);
        return userRepository.saveAndFlush(user);
    }

    public User getObjectFromDTO(UserDTO userDTO) {
        return getObjectFromDTO(userDTO, new User());
    }

    public User getObjectFromDTO(UserDTO userDTO, User user) {
        if (!Objects.equals(userDTO.getPassword(), userDTO.getConfirmedPassword())) {
            throw new RuntimeException("password not confirmed");
        }
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setBirthedAt(userDTO.getBirthedAt());
        user.setAvatar(userDTO.getAvatar());
        user.setPassword(userDTO.getPassword());
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
                user.getAuthorities()
        );
    }


}
