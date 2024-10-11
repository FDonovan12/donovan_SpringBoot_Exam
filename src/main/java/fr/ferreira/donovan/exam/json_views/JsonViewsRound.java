package fr.ferreira.donovan.exam.json_views;

public class JsonViewsRound {

    public interface MinimalRound extends Points, Time, Distance {}
    public interface AllRound extends Id, Points, Time, Distance, CreatedAt {}

    public interface Id {}
    public interface CreatedAt {};
    public interface Time {};
    public interface Distance {};
    public interface Points {};

    public interface Game {};
    public interface Origin {};
    public interface Selected {};
}