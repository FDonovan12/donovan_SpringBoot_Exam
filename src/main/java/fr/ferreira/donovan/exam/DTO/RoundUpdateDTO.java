package fr.ferreira.donovan.exam.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoundUpdateDTO {

    @NotNull(message = "This should be a valid time")
    private Integer time;

    @NotNull(message = "This should be a valid selectedCoordinateId")
    private Long selectedCoordinateId;

}