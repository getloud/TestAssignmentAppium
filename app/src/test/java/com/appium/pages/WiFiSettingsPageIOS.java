package com.appium.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */

public class WiFiSettingsPageIOS implements WiFiSettingsPage {

    public WiFiSettingsPageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeButton")
    public MobileElement addWiFiButton;

    @FindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeTable")
    public MobileElement wifiListView;

    @FindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public MobileElement wifiStatusTextView;

    public void pressButtonAddWifiNetwork() {

        addWiFiButton.click();
    }


    public Boolean wifiNetworkIsPresent(String wifiName) {
        String elementName = wifiListView.findElementById(wifiName).getText();
        if (elementName.equals(wifiName)) {
            return true;
        }
        return false;
    }


    public void connectToNewWiFiNetwork(String wifiName) {
        MobileElement element = wifiListView.findElementById(wifiName);
        element.click();
    }


    public Boolean isConnectedWiFiNetwork(String wifiName) {
        String wifiStatus = wifiStatusTextView.getText();
        String requiredString = wifiStatus.substring(wifiStatus.indexOf(":") + 1);
        String wifiStatusString = requiredString.substring(1);
        if (wifiStatusString.equals(wifiName)) {
            return true;
        }
        return false;

    }

}
