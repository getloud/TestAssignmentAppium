package com.appium.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */

public class CreateWiFiNetworkPageAndroid implements CreateWiFiNetworkPage {

    public CreateWiFiNetworkPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "dialogButtonOK")
    public MobileElement saveWiFiNetworkButton;

    @FindBy(id = "inputSSID")
    public MobileElement wifiNameEditTextField;


    public void inputWiFiName(String wifiName) {
        wifiNameEditTextField.setValue(wifiName);
    }

    public void createWiFiNetwork() {
        saveWiFiNetworkButton.click();
    }

}
