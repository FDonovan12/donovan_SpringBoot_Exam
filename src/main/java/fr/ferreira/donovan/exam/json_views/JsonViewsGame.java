package fr.ferreira.donovan.exam.json_views;

public class JsonViewsGame {

    public interface MinimalGame extends Id, User, createdAt, NbRounds, TotalPoint {}
    public interface AllGame extends TotalPoint, MaximumTime, HasPan, HasZoom, HasMove, createdAt, NbRounds, Rounds {}

    public interface Id {}
    public interface MaximumTime {};
    public interface HasPan {};
    public interface HasZoom {};
    public interface HasMove {};
    public interface createdAt {};
    public interface NbRounds {};

    public interface User {};
    public interface Rounds {};
    public interface Map {};
    public interface TotalPoint {};
}