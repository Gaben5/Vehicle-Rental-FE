package com.kodilla.rentalfe.vehicles.service;

import com.kodilla.rentalfe.books.domain.Book;
import com.kodilla.rentalfe.vehicles.VehicleType;
import com.kodilla.rentalfe.vehicles.domain.Vehicle;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VehicleService {
    private Set<Vehicle> vehicles;
    private static VehicleService vehicleService;

    public VehicleService() {
        this.vehicles = exampleData();
    }

    public static VehicleService getInstance(){
        if (vehicleService == null){
            vehicleService = new VehicleService();
        }
        return vehicleService;
    }

    public Set<Vehicle> getVehicles() {
        return new HashSet<>(vehicles);
    }
    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    private Set<Vehicle> exampleData(){
        Set<Vehicle> vehicles = new HashSet<>();
        vehicles.add(new Vehicle("BMW X6", "Black", 2015, 200, VehicleType.CAR, 400));
        vehicles.add(new Vehicle("Honda CBR600RR", "Red", 2017, 95, VehicleType.MOTORCYCLE, 200));
        vehicles.add(new Vehicle("Audi S8", "White", 2020, 400, VehicleType.CAR, 450));
        vehicles.add(new Vehicle("VW Arteon", "Black", 2022, 180, VehicleType.CAR, 250));
        vehicles.add(new Vehicle("Yamaha Fazer", "Blue", 2008, 100, VehicleType.MOTORCYCLE, 150));
        return vehicles;
    }

    public Set<Vehicle> findByBrand(String brand){
        return vehicles.stream().filter(br -> br.getBrand().contains(brand))
                .collect(Collectors.toSet());
    }

    public void save(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void delete(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }
}
