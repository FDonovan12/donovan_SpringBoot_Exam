package fr.ferreira.donovan.exam.mapping;

public interface UrlRouteRound {

    String URL_ROUND = "/round";
    String URL_ROUND_NEW = URL_ROUND + "/new";
    String URL_ROUND_EDIT = URL_ROUND + "/edit";
    String URL_ROUND_DELETE = URL_ROUND + "/delete";

    String URL_ADMIN_ROUND = "/admin" + URL_ROUND;
    String URL_ADMIN_ROUND_NEW = URL_ADMIN_ROUND + "/new";
    String URL_ADMIN_ROUND_EDIT = URL_ADMIN_ROUND + "/edit";
    String URL_ADMIN_ROUND_DELETE = URL_ADMIN_ROUND + "/delete";
}
