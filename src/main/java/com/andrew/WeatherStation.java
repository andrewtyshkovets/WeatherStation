package com.andrew;

public class WeatherStation{

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        MyJSONParser myJSONParser = new MyJSONParser();
        View view = new View();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData, view);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData, view);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData,view);

        while (true) {
            weatherData.setMeasurements(myJSONParser.getTempInCelsius(), myJSONParser.gethumidity(), myJSONParser.getPressureInMilimetersRtSt());
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
