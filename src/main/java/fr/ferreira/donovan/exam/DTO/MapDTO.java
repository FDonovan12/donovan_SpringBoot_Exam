package fr.ferreira.donovan.exam.DTO;

import fr.ferreira.donovan.exam.repository.MapRepository;
import fr.ferreira.donovan.exam.validator.annotation.UniqueName;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MapDTO {

    @NotBlank(message = "This should be a valid name")
    private String name;

}