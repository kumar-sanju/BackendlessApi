package com.smartworld.backendlessapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Example2Activity extends AppCompatActivity {

    //    private static String APPID = "60658C81-BEA1-4519-B21D-386A6A6AF5BF";
//    private static String APIKEY = "5A87C89C-21EA-4E99-B361-D987924B4C3B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

//        Backendless.setUrl(TestApplication.SERVER_URL);
//        Backendless.initApp(this,
//                TestApplication.APPLICATION_ID,
//                TestApplication.API_KEY);

        Person person = new Person();
        person.setName("Sanju");
        person.setSurname("Mahapatra");

        Backendless.Data.of(Person.class).save(person, new AsyncCallback<Person>() {
            @Override
            public void handleResponse(Person response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    //        Backendless.initApp(this, APPID, APIKEY );
//        BackendlessUser user = new BackendlessUser();
//        user.setEmail( "green.goblin@backendless.com" );
//        user.setPassword( "sp1dey" );
//        user.setProperty( "name", "Green Goblin" );
//        user.setProperty( "phoneNumber", "212-555-1212" );
//        final ProgressBar progressBar = findViewById(R.id.progressbar);
//        progressBar.setVisibility(View.VISIBLE);
//        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
//            @Override
//            public void handleResponse(BackendlessUser response) {
//                progressBar.setVisibility(View.INVISIBLE);
//                Toast.makeText(getContext(), "User has been registered", Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void handleFault(BackendlessFault fault) {
//                progressBar.setVisibility(View.INVISIBLE);
//                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
    public Context getContext() {
        return this;
    }
}