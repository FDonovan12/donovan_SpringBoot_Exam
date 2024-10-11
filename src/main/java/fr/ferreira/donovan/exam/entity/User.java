package fr.ferreira.donovan.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.interfaces.EntityInterface;
import fr.ferreira.donovan.exam.entity.interfaces.SluggerInterface;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.json_views.JsonViewsUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonView(JsonViews.Ignore.class)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViewsUser.Id.class)
    private String id;

    @JsonView(JsonViewsUser.Username.class)
    @Column(nullable = false)
    private String username;

    @JsonView(JsonViewsUser.Email.class)
    @Column(nullable = false)
    private String email;

    @JsonView(JsonViewsUser.Password.class)
    @Column(nullable = false)
    private String password;

    @JsonView(JsonViewsUser.Avatar.class)
    private String avatar;

    @JsonView(JsonViewsUser.BirthAt.class)
    @Column(nullable = false)
    private LocalDate birthedAt;

    @JsonView(JsonViewsUser.CreatedAt.class)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @JsonView(JsonViewsUser.Level.class)
    @Column(nullable = false)
    private Integer level;

    @JsonView(JsonViewsUser.Roles.class)
    @Column(nullable = false)
    private String roles;

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViewsUser.Games.class)
    private List<Game> games = new ArrayList<>();

    @JsonView(JsonViewsUser.IsAdmin.class)
    public boolean isAdmin() {
        return roles.toUpperCase().contains("ADMIN");
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Collections.singletonList(getRoles());
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (r.contains("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        });
        return authorities;
    }
}