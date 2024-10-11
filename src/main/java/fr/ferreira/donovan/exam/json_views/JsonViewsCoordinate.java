package fr.ferreira.donovan.exam.json_views;

public class JsonViewsCoordinate {

    public interface MinimalCoordinate extends Id {}
    public interface AllCoordinate extends Id, Longitude, Latitude {}

    public interface Id {}
    public interface  Longitude {};
    public interface  Latitude {};
}