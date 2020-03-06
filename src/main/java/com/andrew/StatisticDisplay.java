package com.andrew;

public class StatisticDisplay implements Observer, DisplayElement {
    private double maxTemp = 0.0;
    private double minTemp = 200.0;
    private double tempSum;
    private int numReadings;
    private View view;
    private Subject weatherData;

    public StatisticDisplay(Subject weatherData, View view) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        this.view = view;
    }

    public void update(double temp, double humidity, double pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    public void display() {
        view.displayStatistic(tempSum,numReadings,minTemp,maxTemp);
    }
}
