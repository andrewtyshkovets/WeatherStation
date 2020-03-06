package com.andrew;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class MyJSONParser {
    WebSiteWeather webSiteWeather = new WebSiteWeather();
    View view = new View();
    String weather;

    {
        try {
            weather = webSiteWeather.getCurrentWeather(view.setCity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    JsonObject jsonObject = (JsonObject) new JsonParser().parse(weather);

    public double getTempInKelvin() {
        double temp = Double.parseDouble(jsonObject.get("main").getAsJsonObject().get("temp").getAsString());
        return temp;
    }
    public double getTempInCelsius() {
        double temp = Double.parseDouble(jsonObject.get("main").getAsJsonObject().get("temp").getAsString())-273.15;
        return temp;
    }
    public double gethumidity() {
        double humidity = Double.parseDouble(jsonObject.get("main").getAsJsonObject().get("humidity").getAsString());
        return humidity;
    }
    public double getPressureInHPa() {
        double pressure = Double.parseDouble(jsonObject.get("main").getAsJsonObject().get("pressure").getAsString());
        return pressure;
    }
    public double getPressureInMilimetersRtSt() {
        double pressure = Double.parseDouble(jsonObject.get("main").getAsJsonObject().get("pressure").getAsString())*0.75006375541921;
        return pressure;
    }

}
