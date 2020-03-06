package com.andrew;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private double temp = 0;
    private double humidity = 0;
    private double pressure = 0;
    private ArrayList<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        /*for (Observer o: observers) {
            o.update(temp,humidity,pressure);
        }*/
        for (int i = 0; i <observers.size() ; i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temp,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(double temp, double humidity, double pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
