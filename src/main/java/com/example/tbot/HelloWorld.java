package com.example.tbot;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld extends TelegramLongPollingBot {

    OkHttpClient okHttpClient;

    Request request;

    Response response = null;

    String sendCoronaDataNumbers = "";

    String from = null;

    String to = null;

    String amount = null;

    static String welcomemessage =
            "Thank you for using силердин ботунардын аты \uD83D\uDE09.\n\n" +
                    "боттун описаниеси\n" +
                    " описаниенин уландысы\uD83D\uDD25.\n" +
                    "\n\n" +
                    "Автор бота \uD83D\uDC68\u200D\uD83D\uDCBB : озунузду инстаграммыныз";

    JSONParser parser = new JSONParser();

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
//        System.out.println(update.getMessage().getChat().getFirstName());
//        System.out.println(update.getMessage().getChat().getUserName());
        String innerAmount = update.getMessage().getText();
        boolean isOnlyDigits = true;
        for (int i = 0; i < innerAmount.length() && isOnlyDigits; i++) {
            if (!Character.isDigit(innerAmount.charAt(i))) {
                isOnlyDigits = false;
            }
        }
        System.out.println(isOnlyDigits); // => true
        if (update.getMessage().getText().equals("/start") || update.getMessage().getText().equals("Back") || update.getMessage().getText().equals("/start@AlreadyExistsBOt") || update.getMessage().getText().equals("Okey")) {
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            KeyboardRow row;
            row = new KeyboardRow();
            row.add("Convert exchange rates");
            keyboardRowList.add(row);
            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            sendMessage.setText("Hi " + update.getMessage().getFrom().getFirstName() + " \uD83D\uDE4B\u200D♂️,\n\n" + welcomemessage);
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Convert exchange rates")) {
            try {
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboardRowList = new ArrayList<>();
                KeyboardRow row;
                row = new KeyboardRow();
                row.add("From");
                keyboardRowList.add(row);
                row = new KeyboardRow();
                row.add("Back");
                keyboardRowList.add(row);
                replyKeyboardMarkup.setKeyboard(keyboardRowList);
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
                try {
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Hello " + update.getMessage().getFrom().getFirstName() + " ,Array Index Out Of Bound (AiooB) is Telegram Bot developed by " +
                            "https://instagram.com/coding_boy_, 50K+ programmers community on the instagram" +
                            "and we are providing daily useful Programming,Java,android development,tips-tricks ,projects and tech content." +
                            "\n\n");
                    execute(sendMessage);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("From")) {
            ReplyKeyboardMarkup fromReplyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> fromKeyboardRowList = new ArrayList<>();
            KeyboardRow fromRow;
            fromRow = new KeyboardRow();
            fromRow.add("KGS");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("USD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("EUR");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("GBP");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("CAD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("AUD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("JPY");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("INR");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("NZD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("CHF");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("ZAR");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("RUB");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("BGN");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("SGD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("Back");
            fromKeyboardRowList.add(fromRow);
            fromReplyKeyboardMarkup.setKeyboard(fromKeyboardRowList);
            sendMessage.setReplyMarkup(fromReplyKeyboardMarkup);
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Выберите валюту: ");
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (update.getMessage().getText().length() == 3 && from == null && !isOnlyDigits ||
                update.getMessage().getText().length() == 4 && from == null && !isOnlyDigits) {
            from = update.getMessage().getText();
            ReplyKeyboardMarkup fromReplyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> fromKeyboardRowList = new ArrayList<>();
            KeyboardRow fromRow;
            fromRow = new KeyboardRow();
            fromRow.add("KGS");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("USD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("EUR");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("GBP");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("CAD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("AUD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("JPY");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("INR");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("NZD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("CHF");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("ZAR");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("RUB");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("BGN");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("SGD");
            fromKeyboardRowList.add(fromRow);
            fromRow = new KeyboardRow();
            fromRow.add("Back");
            fromKeyboardRowList.add(fromRow);
            fromReplyKeyboardMarkup.setKeyboard(fromKeyboardRowList);
            sendMessage.setReplyMarkup(fromReplyKeyboardMarkup);
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("На какую хотите поменять: ");
                execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().length() == 3 && from != null && !isOnlyDigits ||
                update.getMessage().getText().length() == 4 && from != null && !isOnlyDigits) {
            to = update.getMessage().getText();
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Write amount: ");
                execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (isOnlyDigits) {
            try {
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboardRowList = new ArrayList<>();
                KeyboardRow row;

                row = new KeyboardRow();
                row.add("Okey");
                keyboardRowList.add(row);
                amount = innerAmount;
                okHttpClient = new OkHttpClient();
                request = new Request.Builder()
                        .url("https://api.apilayer.com/fixer/convert?to=" + to + "&from=" + from + "&amount=" + amount)
                        .addHeader("apikey", "qU9uZU8xGYCv4tGw2soV2rDQf7qhXi1U")
                        .get()
                        .build();
                Response response = null;

                response = okHttpClient.newCall(request).execute();

                String data = null;

                data = response.body().string();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = null;
                jsonObject = (JSONObject) jsonParser.parse(data);
                String query = jsonObject.get("query").toString();

                sendMessage.setText(
                        "\nFrom : " +
                                "\nTo : " + jsonObject.get("to") +
                                "\nAmount : " + jsonObject.get("amount") +
                                "\nResult: " + jsonObject.get("result"));
                sendMessage.setChatId(update.getMessage().getChatId());
                replyKeyboardMarkup.setKeyboard(keyboardRowList);
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
                execute(sendMessage);

            } catch (TelegramApiException | IOException | ParseException e) {
                throw new RuntimeException(e);
            }
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Unlimited Courses")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Get Unlimited Courses including SEO Course, Linux, some programming languages courses.\n" +
                        "Happy Learning!\n" +
                        "https://drive.google.com/drive/folders/0B3Qd1rlyIyR5TGlyYmlsSHBlcVU?usp=sharing\n");
                execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("CS & Programming Books \uD83D\uDCDA")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("500+ Free Computer Science and Programming Books \n\n " +
                        "https://drive.google.com/drive/folders/0B9XbEQh3jB9pWVBFX0hqTzA0dUU");
                execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("to")) {
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            KeyboardRow row;

            row = new KeyboardRow();
            row.add("Instagram");
            row.add("Twitter");
            keyboardRowList.add(row);

            row = new KeyboardRow();
            row.add("Facebook");
            row.add("Youtube");
            keyboardRowList.add(row);

            row = new KeyboardRow();
            row.add("Our Blog");
            keyboardRowList.add(row);

            row = new KeyboardRow();
            row.add("Source Code of this Bot");
            keyboardRowList.add(row);

            row = new KeyboardRow();
            row.add("Back");
            keyboardRowList.add(row);

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Hello " + update.getMessage().getFrom().getFirstName() + " ,Array Index Out Of Bound (AiooB) is Telegram Bot developed by " +
                        "https://instagram.com/coding_boy_, 50K+ programmers community on the instagram" +
                        "and we are providing daily useful Programming,Java,android development,tips-tricks ,projects and tech content." +
                        "\n\n");
                execute(sendMessage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //All Social media and Contact Links

        else if (update.getMessage().getText().equals("Instagram")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Follow us On Instagram");
                execute(sendMessage);
                sendMessage.setText("\n https://instagram.com/coding_boy_");
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Twitter")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Follow us On Twitter");
                execute(sendMessage);
                sendMessage.setText("\n https://twitter.com/MrCodingBoy");
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Facebook")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Like our Facebook page");
                execute(sendMessage);
                sendMessage.setText("\n https://www.facebook.com/thecodingboy");
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Youtube")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Subscribe to our Youtube Channel");
                execute(sendMessage);
                sendMessage.setText("\n https://www.youtube.com/channel/UCcS31rdaPf42mS7B12VVfhw?view_as=subscriber");
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Our Blog")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Blog : ");
                execute(sendMessage);
                sendMessage.setText("\n https://codingboy.in");
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Source Code of this Bot")) {
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Source code of this bot");
                execute(sendMessage);
                sendMessage.setText("\n https://github.com/viralvaghela/Telegram-Bot-Array-Index-Out-Of-Bound");
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            sendMessage.setText("Hi " + update.getMessage().getFrom().getFirstName() + " \uD83D\uDE4B\u200D♂️,\n\n" + welcomemessage);
            try {
                sendMessage.setChatId(update.getMessage().getChatId());
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void concateNumbers(String country, String total_cases, String total_recovered, String total_deaths) {
        sendCoronaDataNumbers = sendCoronaDataNumbers + country + total_cases + total_recovered + total_deaths + "\n";
        System.out.println(sendCoronaDataNumbers);
    }

    @Override
    public String getBotUsername() {
        return "AlreadyExistsBOt";
    }

    @Override
    public String getBotToken() {
        return "6080176828:AAHud-nD7yvWza0GzE0EIGl3A-WOVOxR810";
    }
}
