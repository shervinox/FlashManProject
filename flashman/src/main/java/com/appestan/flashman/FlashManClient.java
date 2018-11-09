package com.appestan.flashman;

public class FlashManClient {

    private static final FlashManClient ourInstance = new FlashManClient();

    public static FlashManClient getInstance()
    {
        return ourInstance;
    }

    private FlashManClient()
    {
    }
}
