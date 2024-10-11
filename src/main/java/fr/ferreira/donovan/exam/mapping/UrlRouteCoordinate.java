package fr.ferreira.donovan.exam.mapping;

public interface UrlRouteCoordinate {

    String URL_COORDINATE = "/coordinate";
    String URL_COORDINATE_NEW = URL_COORDINATE + "/new";
    String URL_COORDINATE_EDIT = URL_COORDINATE + "/edit";
    String URL_COORDINATE_DELETE = URL_COORDINATE + "/delete";

    String URL_ADMIN_COORDINATE = "/admin" + URL_COORDINATE;
    String URL_ADMIN_COORDINATE_NEW = URL_ADMIN_COORDINATE + "/new";
    String URL_ADMIN_COORDINATE_EDIT = URL_ADMIN_COORDINATE + "/edit";
    String URL_ADMIN_COORDINATE_DELETE = URL_ADMIN_COORDINATE + "/delete";
}
