package fr.ferreira.donovan.exam.DTO;

import fr.ferreira.donovan.exam.repository.GameRepository;
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
public class GameDTO {

    @NotNull(message = "This should be a valid name")
    private Boolean hasPan;

    @NotNull(message = "This should be a valid name")
    private Boolean hasZoom;

    @NotNull(message = "This should be a valid name")
    private Boolean hasMove;

    @NotNull(message = "This should be a valid name")
    private Integer maximumTime;

    @NotNull(message = "This should be a valid name")
    private Integer nbRound;

    @NotNull(message = "This should be a valid name")
    private Long mapId;

}