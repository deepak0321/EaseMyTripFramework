package com.automation.pages.ui;

import io.cucumber.datatable.DataTable;

public interface ActivitiesPage {

    default boolean isActivitiesPageDisplayed() {
        return false;
    }

    default void selectPlace(String inputPlace) {}

    default boolean isActivitiesListPageDisplayed(){
        return false;
    }

    default void applyFilter(String durationVal, String specialVal){}

    default void sort(String value){}

    default boolean verifySort(String sortOrder){
        return false;
    }

    default void selectActivity(String location){}

    default boolean isUserInfoPageDisplayed() {
        return false;
    }

    default void fillUserDetails (DataTable dataTable) {}

    default void fillContactDetails(String mobileInput, String emailInput, String panNameInput, String panNumberInput) {}

    default void printDetails() {}

    default boolean isActivityDetailPageDisplayed() {
        return false;
    }

    default void selectDate(String inputDate) {}

    default void selectTime() {}

    default void addPeople(String adultCount) {}

    default void clickOnBookNowBtn() {}

}
