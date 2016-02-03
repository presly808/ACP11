package ollo.controller;

import ollo.model.OlloMain;

/**
 * Created by dima on 01.02.2016.
 */
public class Controller {
    private OlloMain ollo;

    public Controller() {
    }

    public OlloMain getOllo() {
        return ollo;
    }

    public void setOllo(OlloMain ollo) {
        this.ollo = ollo;
    }

    public void startView() {
        ollo.getUser().startView();
    }

    public String createNewUser(String login, String passwprd) {


        return "User " + login + " is already registered in system";
    }


}
