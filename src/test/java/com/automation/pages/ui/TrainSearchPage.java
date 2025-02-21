package com.automation.pages.ui;

public interface TrainSearchPage {

    void enterDepartureCity(String departureCity);

    void selectCity(String cityStation);

    void enterArrivalCity(String arrivalCity);

    boolean isTrainSearchPageDisplayed();

    void clickOnShowTrains();

    void selectDepartureDate(String departureDate);
}
