package com.automation.steps;

import com.automation.pages.web.WebHolidaysPackagesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HolidayPackageSteps {

    WebHolidaysPackagesPage holidayPackagePage = new WebHolidaysPackagesPage();

    @Then("verify tour packages page is displayed")
    public void verify_tour_packages_page_is_displayed() {
        Assert.assertTrue(holidayPackagePage.isTourPackagesPageDisplayed());
    }

    @When("user clicks on from city and enters the {string}")
    public void user_clicks_on_from_city_and_enters_the(String fromCity) {
        holidayPackagePage.selectFromCity(fromCity);
    }

    @When("apply filters as sort to {string} and package type as {string}")
    public void apply_filters_as_sort_to_and_package_type_as(String sortOption, String packageType) {
        holidayPackagePage.filterOptions(sortOption, packageType);
    }

    @When("user clicks on more filters button and add a theme as {string}")
    public void user_clicks_on_more_filters_button_and_add_a_theme_as(String theme) {
        holidayPackagePage.moreFilterOptions(theme);
    }

    @Then("verify list of packages are displayed")
    public void verify_list_of_packages_are_displayed() {
        Assert.assertTrue(holidayPackagePage.isPackagesDisplayed());
    }

    @And("user select the package with recommended tag")
    public void userSelectThePackageWithRecommendedTag() {
        holidayPackagePage.selectRecommendedPackage();
    }

    @When("user selects the package")
    public void userSelectsThePackage() {
        holidayPackagePage.selectRecommendedPackage();
    }
}
