package ru.pkmpei.mpei_pk.dataTypes;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.logging.ErrorManager;

/**
 * Created by infrostorm on 26.02.2018.
 */

public class SessionData {
    private String login;
    private String password;
    private String siteID;

    public SessionData(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Session", Context.MODE_PRIVATE);
        login = sharedPreferences.getString("login", null);
        password = sharedPreferences.getString("password", null);
        siteID =  sharedPreferences.getString("siteID", null);
        if(siteID == null || login == null || password == null) throw new NullPointerException();
    }

    public SessionData(String login, String password, String siteID) {
        this.login = login;
        this.password = password;
        this.siteID = siteID;
    }


    String GetLogin()
    {
        return login;
    }
    String GetPassword()
    {
        return password;
    }
    String GetSiteID()
    {
        return siteID;
    }

}
