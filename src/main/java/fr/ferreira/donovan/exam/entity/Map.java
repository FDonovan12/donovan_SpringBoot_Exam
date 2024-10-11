package fr.ferreira.donovan.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.interfaces.EntityInterface;
import fr.ferreira.donovan.exam.entity.interfaces.SluggerInterface;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.json_views.JsonViewsMap;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonView(JsonViews.Ignore.class)
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewsMap.Id.class)
    private Long id;

    @JsonView(JsonViewsMap.Name.class)
    @Column(nullable = false)
    private String name;

    @JsonView(JsonViewsMap.CreatedAt.class)
    @Column(nullable = false)
    private LocalDateTime createdAt;

}