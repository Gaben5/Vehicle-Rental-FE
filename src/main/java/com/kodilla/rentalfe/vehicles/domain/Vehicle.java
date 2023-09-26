package com.kodilla.rentalfe.vehicles.domain;

import com.kodilla.rentalfe.vehicles.VehicleType;

import java.util.Objects;


public class Vehicle {
    private String brand;
    private String color;
    private int productionYear;
    private int horsePower;
    private VehicleType type;
    private double pricePerDay;

    public Vehicle() {
    }

    public Vehicle(String brand, String color, int productionYear, int horsePower, VehicleType type, double pricePerDay) {
        this.brand = brand;
        this.color = color;
        this.productionYear = productionYear;
        this.horsePower = horsePower;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return productionYear == vehicle.productionYear && horsePower == vehicle.horsePower && Double.compare(pricePerDay, vehicle.pricePerDay) == 0 && Objects.equals(brand, vehicle.brand) && Objects.equals(color, vehicle.color) && type == vehicle.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, productionYear, horsePower, type, pricePerDay);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public VehicleType getType() {
        return type;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
