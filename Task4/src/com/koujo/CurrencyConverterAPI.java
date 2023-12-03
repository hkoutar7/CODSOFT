package com.koujo;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class CurrencyConverterAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/cec24eda82e0f81ffe68cd5e/pair/";

    public static void getExchangeRate(String baseCurrency, String targetCurrency,float amount) {
        try {
            URL url = new URL(API_URL + baseCurrency + "/" + targetCurrency + "/" + amount);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Scanner scanner = new Scanner(reader);

            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }

            scanner.close();
            reader.close();

            String jsonResponse = response.toString();
            Gson gson = new Gson();
            Currency currency = gson.fromJson(jsonResponse, Currency.class);
            System.out.println("your amount " + amount + " " + currency.getBase_code() + " to " +
                    currency.getTarget_code() + " is " + currency.getConversion_result() + " " + currency.getTarget_code() );


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
