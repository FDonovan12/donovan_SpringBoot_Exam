package fr.ferreira.donovan.exam.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoundDTO {

    @NotBlank(message = "This should be a valid gameId")
    private String gameId;

}