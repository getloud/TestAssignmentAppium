package com.appium.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */

public class CreateWiFiNetworkPageIOS implements CreateWiFiNetworkPage {

    public CreateWiFiNetworkPageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    public MobileElement saveWiFiNetworkButton;

    @FindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement wifiNameEditTextField;


    public void inputWiFiName(String wifiName) {

        wifiNameEditTextField.setValue(wifiName);
    }

    public void createWiFiNetwork() {
        saveWiFiNetworkButton.click();
    }

}
