package fr.ferreira.donovan.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.interfaces.EntityInterface;
import fr.ferreira.donovan.exam.entity.interfaces.SluggerInterface;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.json_views.JsonViewsCoordinate;
import jakarta.persistence.*;
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
@Entity
@JsonView(JsonViews.Ignore.class)
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewsCoordinate.Id.class)
    private Long id;

    @JsonView(JsonViewsCoordinate.Latitude.class)
    @Column(nullable = false)
    private String latitude;

    @JsonView(JsonViewsCoordinate.Longitude.class)
    @Column(nullable = false)
    private String longitude;
}