package fr.ferreira.donovan.exam.DTO;

import fr.ferreira.donovan.exam.repository.UserRepository;
import fr.ferreira.donovan.exam.validator.annotation.UniqueName;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "This should be a valid email")
    private String email;

    @NotBlank(message = "This should be a valid username")
    private String username;

    @NotNull(message = "This should be a valid birthedAt")
    private LocalDate birthedAt;

    private String avatar;

    @NotBlank(message = "This should be a valid password")
    private String password;

    @NotBlank(message = "This should be a valid confirmedPassword")
    private String confirmedPassword;

}