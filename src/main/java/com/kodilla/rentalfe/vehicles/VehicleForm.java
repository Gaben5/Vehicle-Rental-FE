package com.kodilla.rentalfe.vehicles;

import com.kodilla.rentalfe.vehicles.domain.Vehicle;
import com.kodilla.rentalfe.vehicles.service.VehicleService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.List;

public class VehicleForm extends FormLayout {
    private MainView mainView;

    private TextField brand = new TextField("Brand");
    private TextField color = new TextField("Color");
    private TextField productionYear = new TextField("Production year");
    private TextField horsePower = new TextField("Horse power");
    private ComboBox<VehicleType> type = new ComboBox<>("Vehicle type");
    private TextField pricePerDay = new TextField("Price per day");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Binder<Vehicle> binder = new Binder<Vehicle>(Vehicle.class);
    private VehicleService service = VehicleService.getInstance();



    public VehicleForm(MainView mainView){
        this.mainView = mainView;
        type.setItems(VehicleType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(brand, color, productionYear, horsePower, type, pricePerDay, buttons);
        binder.bindInstanceFields(this);

        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
    }

    private void save() {
        Vehicle vehicle = binder.getBean();
        service.save(vehicle);
        mainView.refresh();
        setVehicle(null);
    }

    private void delete() {
        Vehicle vehicle = binder.getBean();
        service.delete(vehicle);
        mainView.refresh();
        setVehicle(null);
    }

    public void setVehicle(Vehicle vehicle) {
        binder.setBean(vehicle);

        if (vehicle == null){
            setVisible(false);
        }else {
            setVisible(true);
            brand.focus();
        }
    }

}
