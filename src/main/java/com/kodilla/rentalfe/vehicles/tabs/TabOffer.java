package com.kodilla.rentalfe.vehicles.tabs;

import com.kodilla.rentalfe.vehicles.MainView;
import com.kodilla.rentalfe.vehicles.VehicleForm;
import com.kodilla.rentalfe.vehicles.domain.Vehicle;
import com.kodilla.rentalfe.vehicles.service.VehicleService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;


public class TabOffer extends VerticalLayout {
    private MainView mainView;

    private Button addNewVehicle = new Button("Add new Vehicle");
    private TextField filterBrand = new TextField();
    private Grid<Vehicle> gridVehicles = new Grid<>(Vehicle.class);
    private VehicleService vehicleService = VehicleService.getInstance();



    public TabOffer(MainView mainView) {
        this.mainView = mainView;
        VehicleForm vehicleForm = new VehicleForm(mainView);

    filterBrand.setPlaceholder("Filter by brand");
        filterBrand.setClearButtonVisible(true);
        filterBrand.setValueChangeMode(ValueChangeMode.EAGER);
        filterBrand.addValueChangeListener(e -> update());
        gridVehicles.setColumns("brand", "color", "productionYear", "horsePower", "type", "pricePerDay");

        addNewVehicle.addClickListener(e -> {
            gridVehicles.asSingleSelect().clear();
            vehicleForm.setVisible(true);
            vehicleForm.setVehicle(new Vehicle());
    });
    HorizontalLayout toolbar = new HorizontalLayout(filterBrand, addNewVehicle);
        toolbar.setSizeFull();
    HorizontalLayout mainContent = new HorizontalLayout(gridVehicles, vehicleForm);
        mainContent.setSizeFull();


    add(toolbar, mainContent);
        vehicleForm.setVehicle(null);


        gridVehicles.asSingleSelect().addValueChangeListener(event1 -> vehicleForm.setVehicle(gridVehicles.asSingleSelect().getValue()));
    }

    public void update(){
        gridVehicles.setItems(vehicleService.findByBrand(filterBrand.getValue()));
    }

    public void refresh() {
        gridVehicles.setItems(vehicleService.getVehicles());
    }
}
