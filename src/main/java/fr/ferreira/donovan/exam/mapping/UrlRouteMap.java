package fr.ferreira.donovan.exam.mapping;

public interface UrlRouteMap {

    String URL_MAP = "/map";
    String URL_MAP_NEW = URL_MAP + "/new";
    String URL_MAP_EDIT = URL_MAP + "/edit";
    String URL_MAP_DELETE = URL_MAP + "/delete";
    String URL_MAP_BEST = URL_MAP + "/best";

    String URL_ADMIN_MAP = "/admin" + URL_MAP;
    String URL_ADMIN_MAP_NEW = URL_ADMIN_MAP + "/new";
    String URL_ADMIN_MAP_EDIT = URL_ADMIN_MAP + "/edit";
    String URL_ADMIN_MAP_DELETE = URL_ADMIN_MAP + "/delete";
}
