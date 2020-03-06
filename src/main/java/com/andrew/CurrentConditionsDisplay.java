package com.andrew;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private double temperature;
    private double humidity;
    private double pressure;
    private Subject weatherData;
    private View view;

    public CurrentConditionsDisplay(Subject weatherData, View view) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        this.view = view;
    }

    public CurrentConditionsDisplay() {
        super();
    }

    @Override
    public void display() {
       view.displayCurrentConditions(temperature,humidity,pressure);
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
