package fr.ferreira.donovan.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.interfaces.EntityInterface;
import fr.ferreira.donovan.exam.entity.interfaces.SluggerInterface;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.json_views.JsonViewsRound;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonView(JsonViews.Ignore.class)
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewsRound.Id.class)
    private Long id;
    
    @JsonView(JsonViewsRound.Points.class)
    private Integer points;

    @JsonView(JsonViewsRound.Distance.class)
    private Long distance;

    @JsonView(JsonViewsRound.Time.class)
    private Integer time;

    @JsonView(JsonViewsRound.CreatedAt.class)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonView(JsonViewsRound.Game.class)
    @JoinColumn(nullable = false)
    private Game game;

    @ManyToOne
    @JsonView(JsonViewsRound.Origin.class)
    @JoinColumn(nullable = false)
    private Coordinate origin;

    @ManyToOne
    @JsonView(JsonViewsRound.Selected.class)
    private Coordinate selected;
}