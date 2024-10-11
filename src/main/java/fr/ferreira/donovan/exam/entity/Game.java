package fr.ferreira.donovan.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.interfaces.EntityInterface;
import fr.ferreira.donovan.exam.entity.interfaces.SluggerInterface;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.json_views.JsonViewsGame;
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
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViewsGame.Id.class)
    private String id;
    
    @JsonView(JsonViewsGame.MaximumTime.class)
    @Column(nullable = false)
    private Integer maximumTime;

    @JsonView(JsonViewsGame.HasPan.class)
    @Column(nullable = false)
    private Boolean hasPan;
    
    @JsonView(JsonViewsGame.HasZoom.class)
    @Column(nullable = false)
    private Boolean hasZoom;

    @JsonView(JsonViewsGame.HasMove.class)
    @Column(nullable = false)
    private Boolean hasMove;

    @JsonView(JsonViewsGame.createdAt.class)
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @JsonView(JsonViewsGame.NbRounds.class)
    @Column(nullable = false)
    private Integer nbRounds;

    @ManyToOne
    @JsonView(JsonViewsGame.Map.class)
    @JoinColumn(nullable = false)
    private Map map;

    @OneToMany(mappedBy = "game")
    @JsonView(JsonViewsGame.Rounds.class)
    private List<Round> rounds = new ArrayList<>();

    @ManyToOne
    @JsonView(JsonViewsGame.User.class)
    @JoinColumn(nullable = false)
    private User user;

    @JsonView(JsonViewsGame.TotalPoint.class)
    public Integer getTotalPoint() {
        return rounds.stream().mapToInt(Round::getPoints).sum();
    }

}