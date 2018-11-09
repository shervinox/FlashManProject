package com.appestan.flashman;

import java.util.HashMap;

public class FlashManArguments {

    HashMap<String, String> header;
    HashMap<String, String> body;

    public FlashManArguments()
    {
        this.header = new HashMap<>();
        this.body = new HashMap<>();
    }

    public HashMap<String, String> getHeader()
    {
        return header;
    }

    public void setHeader(HashMap<String, String> header)
    {
        this.header = header;
    }

    public void addToHeader(String key, String value)
    {
        if (this.header == null)
        {
            throw new NullPointerException();
        }

        this.header.put(key, value);

    }

    public HashMap<String, String> getBody()
    {
        return body;
    }

    public void setBody(HashMap<String, String> body)
    {
        this.body = body;
    }

    public void addToBody(String key, String value)
    {
        if (this.body == null)
        {
            throw new NullPointerException();
        }

        this.body.put(key, value);

    }
}
