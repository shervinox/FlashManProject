package com.appestan.flashmanproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.appestan.flashman.Config;
import com.appestan.flashman.FlashManArguments;
import com.appestan.flashman.FlashManEndPoint;
import com.appestan.flashman.FlashManRequestCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlashManRequestCallback callback = new FlashManRequestCallback() {
            @Override
            public void requestServed()
            {

            }

            @Override
            public void requestFailed()
            {

            }
        };

        FlashManEndPoint endPoint = new FlashManEndPoint() {
            @Override
            public String getPath()
            {
                return "/myPath";
            }

            @Override
            public String getMethodType()
            {
                return "POST";
            }
        };

        FlashManArguments arguments = new FlashManArguments();
        arguments.addToHeader("key", "value");
        arguments.addToBody("key", "value");

        new Config(getApplicationContext()).Builder().selectLib(Config.USE_VOLLEY).host("https://jsonplaceholder.typicode.com").by(callback).on(endPoint).with(arguments).go();

    }
}
