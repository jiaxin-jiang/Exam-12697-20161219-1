package com.jjx.services;

/**
 * Created by TandTV on 2016/12/19.
 */
public abstract class ServiceFactory {
    public static Service createAddService() {
        return new AddService();
    }

    public static Service createShowService() {
        return new ShowService();
    }

    public static Service createUpdateNumService() {
        return new UpdateService();
    }

    public static Service createShowLanguageService() {
        return new ShowFilmService();
    }

    public static Service createDeleteService() {
        return new DeleteService();
    }

    public static Service createLoginService() {
        return new LoginService();
    }
}
