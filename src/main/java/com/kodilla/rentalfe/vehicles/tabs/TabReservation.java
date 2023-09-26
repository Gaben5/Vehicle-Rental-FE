package com.kodilla.rentalfe.vehicles.tabs;

import com.kodilla.rentalfe.vehicles.MainView;
import com.kodilla.rentalfe.vehicles.domain.Vehicle;
import com.kodilla.rentalfe.vehicles.service.VehicleService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.stream.Collectors;

public class TabReservation extends FormLayout {
    private MainView mainView;
    private VehicleService vehicleService = VehicleService.getInstance();


    private TextField email = new TextField("Email");
    private TextField firstName = new TextField("First Name");
    private TextField lastName = new TextField("Last name");
    private ComboBox<String> vehicle = new ComboBox<>("Select Vehicle");
    private Button reservation = new Button("Reservation");
    private DatePicker dateFrom = new DatePicker("Date from");
    private DatePicker dateTo = new DatePicker("Date to");

    public TabReservation(MainView mainView) {
        this.mainView = mainView;
        HorizontalLayout button = new HorizontalLayout(reservation);
        vehicle.setItems(vehicleService.getVehicles().stream().map(Vehicle::getBrand).collect(Collectors.toSet()));
        add(firstName, lastName, email, dateFrom, dateTo, vehicle, button);
    }
}
