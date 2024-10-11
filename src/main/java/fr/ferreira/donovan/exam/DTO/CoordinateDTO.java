package fr.ferreira.donovan.exam.DTO;

import fr.ferreira.donovan.exam.repository.CoordinateRepository;
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
public class CoordinateDTO {

    @NotBlank(message = "This should be a valid latitude")
    private String latitude;

    @NotBlank(message = "This should be a valid longitude")
    private String longitude;

}