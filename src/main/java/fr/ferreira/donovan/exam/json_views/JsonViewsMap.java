package fr.ferreira.donovan.exam.json_views;

public class JsonViewsMap {

    public interface MinimalMap extends Id, Name {}
    public interface AllMap extends Id, Name, CreatedAt {}

    public interface Id {}
    public interface Name {};
    public interface CreatedAt {};
}