package com.example.tbot;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String to = "USD";
        String from = "EUR";
        String amount = "100";
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/fixer/convert?to=" + to + "&from=" + from + "&amount=" + amount)
                .addHeader("apikey", "qU9uZU8xGYCv4tGw2soV2rDQf7qhXi1U")
                .get().build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}