package com.example.tbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(Application.class, args);
//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//        try
//        {
//            telegramBotsApi.registerBot(new HelloWorld());
//            wakeUpDyno();
//        }
//        catch (Exception e){e.printStackTrace();}
    }
    private static void wakeUpDyno() {
        try {
            while(true) {

                URL url = new URL("https://aioob.herokuapp.com/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responcode = connection.getResponseCode();
                System.out.println("RS CODE:"+responcode);
                if (responcode == HttpURLConnection.HTTP_OK)
                {
                    System.out.println("Working");
                }
                else{
                    System.out.println("GET not working");
                }

                Thread.sleep(60000); //

            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("/")
    public String index()
    {
        return "/index";
    }

}
