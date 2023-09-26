package com.kodilla.rentalfe.vehicles.tabs;

import com.kodilla.rentalfe.vehicles.MainView;
import com.kodilla.rentalfe.vehicles.domain.WeatherForecast;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TabWeather extends VerticalLayout {
    private final String backendUrl = "http://localhost:8084/v2/weather";
    private final TextField cityTextField = new TextField("City");
    private final Button searchButton = new Button("Search");
    private final Grid<WeatherForecast> weatherGrid = new Grid<>(WeatherForecast.class);

    private List<WeatherForecast> weatherForecastList;

    public TabWeather(MainView mainView) {

        configureComponents();
        buildLayout();
}
    private void configureComponents() {
        searchButton.addClickListener(event -> fetchWeatherData());
        weatherGrid.setColumns("date", "temperature", "description");
    }

    private void buildLayout() {
        add(new H1("Check weather for next day"),cityTextField, searchButton, weatherGrid);
    }

    private void fetchWeatherData() {
        String cityName = cityTextField.getValue();
        RestTemplate r = new RestTemplate();
        ResponseEntity<WeatherForecast[]> response = r.getForEntity(backendUrl + "?city=" + cityName, WeatherForecast[].class);
        weatherForecastList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        weatherGrid.setItems(weatherForecastList);

    }
}
