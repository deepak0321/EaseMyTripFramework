package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement dontAllowBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Trains\"]")
    WebElement trainsTab;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Bus\"]")
    WebElement busTab;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Cabs\"]")
    WebElement cabsTab;

    public void clickOnCabsTab(){
        cabsTab.click();
    }


    public  void  openApplication(){
        if(isDisplayed(dontAllowBtn))
          dontAllowBtn.click();
    }

    public void clickOnBusTab(){
        busTab.click();
    }


    public boolean isHomePageDisplayed(){
        return trainsTab.isDisplayed() && busTab.isDisplayed();
    }

    public void ClickOnTrainsTab(){
        trainsTab.click();
    }



}
