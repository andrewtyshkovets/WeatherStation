package com.andrew;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class WebSiteWeather {
    private static final String API_KEY = "73b1285ea341bfaf126e0a52d93574c2";
    private static final String API_REQUEST = "http://api.openweathermap.org/data/2.5/weather?q=";

    public String getCurrentWeather(String city) throws IOException {
        String website = API_REQUEST + city + "&APPID=" + API_KEY;
        URL url = new URL(website);
        URLConnection connection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String text;
        while ((text = br.readLine()) != null)
            sb.append(text);
        br.close();
        return sb.toString();
    }


}