package com.kodilla.rentalfe.vehicles;

import com.kodilla.rentalfe.vehicles.tabs.TabCurrencies;
import com.kodilla.rentalfe.vehicles.tabs.TabOffer;
import com.kodilla.rentalfe.vehicles.tabs.TabReservation;
import com.kodilla.rentalfe.vehicles.tabs.TabWeather;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    private TabOffer tOffer = new TabOffer(this);
    TabReservation tReservation = new TabReservation(this);
    TabCurrencies tCurrencies = new TabCurrencies(this);
    TabWeather tWeather = new TabWeather(this);


    public MainView() {
        Tabs tabs = new Tabs();
        VerticalLayout tabContent = new VerticalLayout();

        Tab tabMain = new Tab("Main Page");
        Tab tabOffer = new Tab("Offer");
        Tab tabCurrencies = new Tab("Exchange rates");
        Tab tabReservation = new Tab("Reservation");

        tabs.add(tabMain, tabCurrencies, tabOffer, tabReservation);

        tabContent.add(tWeather);
        tabs.addSelectedChangeListener(event -> {
            tabContent.removeAll();
            if (event.getSelectedTab() == tabMain) {
                tabContent.add(tWeather);
            } else if (event.getSelectedTab() == tabCurrencies) {
                tabContent.add(tCurrencies);
            }else if (event.getSelectedTab() == tabOffer) {
                tabContent.add(tOffer);
                tOffer.refresh();
            }else if (event.getSelectedTab() == tabReservation) {
                tabContent.add(tReservation);
            }
        });

        add(new H1("GABEN RENTS"));
        add(tabs, tabContent);
        setSizeFull();
    }
    public void refresh() {
        tOffer.refresh();
    }

}
