package com.kodilla.rentalfe.vehicles.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecast {
    private String date;
    private double temperature;
    private String description;

    @JsonProperty("dt_txt")
    public String getDate() {
        return date;
    }

    @JsonProperty("main.temp")
    public double getTemperature() {
        return temperature;
    }

    @JsonProperty("weather[0].description")
    public String getDescription() {
        return description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
