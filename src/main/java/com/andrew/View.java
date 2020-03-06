package com.andrew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    public static final String CURRENT_CONDITIONS_MSG = "Current conditions is: ";
    public static final String TEMPERATURE_MSG = "Temperature : ";
    public static final String HUMIDITY_MSG = "Humidity : ";
    public static final String PRESSURE_MSG = "Pressure : ";
    public static final String CITY_MSG = "Enter your city";
    public static final String STATISTIC_MSG = "Avg/Max/Min temperature = ";
    public static final String FORECAST_MSG = "Forecast: ";
    public static final String IMPROVING_MSG = "Improving weather on the way!";
    public static final String GETTING_WORSE_MSG = "Watch out for cooler or rainy weather";
    public static final String SAME_WEATHER_MSG = "More of the same";


    public void displayCurrentConditions(double temp, double humidity, double pressure) {
        System.out.println(CURRENT_CONDITIONS_MSG + "\n" + TEMPERATURE_MSG + temp + "\n"
                + HUMIDITY_MSG + humidity + "\n" + PRESSURE_MSG + pressure);
        System.out.println("\n");
    }

    public String setCity() throws IOException {
        System.out.println(CITY_MSG);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String city = br.readLine();
        return city;
    }

    public void displayStatistic(double sumTemp, int countOfMeasurement, double minTemp, double maxTemp) {
        double avgTemp = sumTemp / countOfMeasurement;
        System.out.println(STATISTIC_MSG + avgTemp + " / " + minTemp + " / " + maxTemp);
        System.out.println("\n");
    }

    public void displayForecast(double currentPressure, double lastPressure){
        System.out.println(FORECAST_MSG +"\n"+currentPressure+" | "+lastPressure);
        if (currentPressure > lastPressure) {
            System.out.println(IMPROVING_MSG);
        } else if (currentPressure == lastPressure) {
            System.out.println(SAME_WEATHER_MSG);
        } else if (currentPressure < lastPressure) {
            System.out.println(GETTING_WORSE_MSG);
        }
        System.out.println("\n");
    }

}
