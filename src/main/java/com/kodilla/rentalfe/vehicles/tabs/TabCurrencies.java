package com.kodilla.rentalfe.vehicles.tabs;

import com.kodilla.rentalfe.vehicles.MainView;
import com.kodilla.rentalfe.vehicles.domain.Currencies;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TabCurrencies extends VerticalLayout {
    private final TextField filterBrand = new TextField();
    private final Grid<Currencies> gridCurrencies = new Grid<>(Currencies.class);
    private final List<Currencies> currencies;


    public TabCurrencies(MainView mainView) {

        filterBrand.setPlaceholder("Filter by currency");
        filterBrand.setClearButtonVisible(true);
        filterBrand.setValueChangeMode(ValueChangeMode.EAGER);
        filterBrand.addValueChangeListener(e -> update());
        gridCurrencies.setColumns("code", "value");
        HorizontalLayout toolbar = new HorizontalLayout(filterBrand);
        toolbar.setSizeFull();
        HorizontalLayout mainContent = new HorizontalLayout(gridCurrencies);
        mainContent.setSizeFull();


        add(toolbar, mainContent);
        RestTemplate r = new RestTemplate();
        ResponseEntity<Currencies[]> response = r.getForEntity("http://localhost:8084/v1/currencies", Currencies[].class);
        currencies = Arrays.asList(Objects.requireNonNull(response.getBody()));
        gridCurrencies.setItems(currencies);
    }

    public void update() {
        gridCurrencies.setItems(findByCode(filterBrand.getValue()));
    }

    private List<Currencies> findByCode(String code) {
        return currencies.stream().filter(br -> br.getCode().toLowerCase().contains(code.toLowerCase()))
                .collect(Collectors.toList());
    }
}
