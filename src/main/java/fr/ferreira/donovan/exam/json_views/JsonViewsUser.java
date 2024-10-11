package fr.ferreira.donovan.exam.json_views;

public class JsonViewsUser {

    public interface MinimalUser extends Id, Username, Level {}
    public interface AllUser extends Id, Username, Email, Avatar, BirthAt, CreatedAt, Level, IsAdmin {}

    public interface Id {}
    public interface Roles {};
    public interface Level {};
    public interface CreatedAt {};
    public interface BirthAt {};
    public interface Avatar {};
    public interface Password {};
    public interface Email {};
    public interface Username {};
    public interface Games {};
    public interface IsAdmin {};
}