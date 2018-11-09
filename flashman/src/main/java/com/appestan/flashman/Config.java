package com.appestan.flashman;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Config {

    public static final int USE_VOLLEY = 1000;
    public static final int USE_ANDROID_ASYNC_HTTP = 1000;
    private final Context context;

    public int selectedLibrary;
    public FlashManRequestCallback callback;
    private FlashManEndPoint endPoint;
    private FlashManArguments arguments;
    private String hostUrl;

    public Config(Context context)
    {
        this.context = context;
    }

    public Config Builder()
    {
        return this;
    }

    public Config selectLib(int whichLibrary)
    {
        selectedLibrary = whichLibrary;
        return this;
    }

    public Config by(FlashManRequestCallback callback)
    {
        this.callback = callback;
        return this;
    }

    public Config on(FlashManEndPoint endPoint)
    {
        this.endPoint = endPoint;
        return this;
    }

    public Config with(FlashManArguments arguments)
    {
        this.arguments = arguments;
        return this;
    }

    public Config host(String hostUrlString)
    {
        this.hostUrl = hostUrlString;
        return this;
    }

    public void go()
    {
        if (selectedLibrary == USE_VOLLEY)
        {
            RequestQueue queue = Volley.newRequestQueue(context);

            queue.add(new StringRequest(Request.Method.GET, hostUrl + endPoint,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response)
                        {
                            callback.requestServed();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    callback.requestFailed();
                }
            }));

        }
        else
        {
            // its loopj
        }
    }
}
