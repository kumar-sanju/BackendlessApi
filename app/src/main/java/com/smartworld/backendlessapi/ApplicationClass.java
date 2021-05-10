package com.smartworld.backendlessapi;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

public class ApplicationClass extends Application {

    public static final String SERVER_URL = "https://api.backendless.com";
    public static final String APPLICATION_ID = "60658C81-BEA1-4519-B21D-386A6A6AF5BF";
    public static final String API_KEY = "5A87C89C-21EA-4E99-B361-D987924B4C3B";

    public static BackendlessUser user;

    @Override
    public void onCreate() {
        super.onCreate();

//        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(this,
                APPLICATION_ID,
                API_KEY);
    }
}
