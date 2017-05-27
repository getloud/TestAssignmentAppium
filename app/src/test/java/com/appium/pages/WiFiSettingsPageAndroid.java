package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */

public class WiFiSettingsPageAndroid implements WiFiSettingsPage {

    public WiFiSettingsPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "addWiFi")
    public MobileElement addWiFiButton;

    @AndroidFindBy(id = "wifiNetworksList")
    public MobileElement wifiListView;

    @AndroidFindBy(id = "textView")
    public MobileElement wifiStatusTextView;

    public void pressButtonAddWifiNetwork() {
        addWiFiButton.click();
    }

    public Boolean wifiNetworkIsPresent(String wifiName) {
        List<MobileElement> elementlist = wifiListView.findElementsByClassName("android.widget.TextView");
        for (MobileElement element : elementlist) {
            if (element.getText().equals("\"" + wifiName + "\"")) {
                return true;
            }

        }
        return false;
    }


    public void connectToNewWiFiNetwork(String wifiName) {
        List<MobileElement> elementlist = wifiListView.findElementsByClassName("android.widget.TextView");
        for (MobileElement element : elementlist) {
            if (element.getText().equals("\"" + wifiName + "\"")) {
                element.click();
            }

        }
    }


    public Boolean isConnectedWiFiNetwork(String wifiName) {
        List<MobileElement> elementlist = wifiListView.findElementsByClassName("android.widget.TextView");
        String wifiStatus = wifiStatusTextView.getText();
        String requiredString = wifiStatus.substring(wifiStatus.indexOf("\"") + 1);
        String wifiStatusString = requiredString.substring(0, requiredString.indexOf("\""));
        if (wifiStatusString.equals(wifiName)) {
            return true;
        }
        return false;

    }


}
