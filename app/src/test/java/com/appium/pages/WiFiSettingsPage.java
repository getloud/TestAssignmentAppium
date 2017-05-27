package com.appium.pages;

/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */

public interface WiFiSettingsPage {

    public void pressButtonAddWifiNetwork();

    public Boolean wifiNetworkIsPresent(String wifiName);

    public void connectToNewWiFiNetwork(String wifiName);

    public Boolean isConnectedWiFiNetwork(String wifiName);


}
