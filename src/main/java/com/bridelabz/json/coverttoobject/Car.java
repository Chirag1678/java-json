package com.bridelabz.json.coverttoobject;

// Class whose object to be converted
public class Car {
    // Attributes
    private String model;
    private int year;
    private int capacity;
    private double mileage;

    // Constructor
    public Car() {
    }

    // Getters
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getMileage() {
        return mileage;
    }

    // Setters

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
