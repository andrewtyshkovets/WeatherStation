package com.andrew;

public class ForecastDisplay implements Observer, DisplayElement {
    private double currentPressure;
    private double lastPressure;
    private int numReadings;
    private View view;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData, View view) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        this.view = view;
    }

    public void update(double temp, double humidity, double pressure) {
            lastPressure = currentPressure;
            currentPressure = pressure;
            numReadings++;
            if(numReadings>1)
            display();
    }

    public void display() {
        view.displayForecast(currentPressure,lastPressure);
    }
}
