package com.appium.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Random;

/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WiFiSettingsTest extends BaseTest {
    static String wifiName;


    /*
    This test adds new WiFi Network
    1. Generate WiFi name (SSID)
    2. Click Add WiFi Network button and open popup window
    3. Input WiFi name from step 1
    4. Click Create WiFi Network

    Expected: WiFi with name from step 1 should appear in WiFi Networks List
    */
    @Test
    public void addWiFiNetwork() {
        wifiName = generateWiFiName();
        settingsPage.pressButtonAddWifiNetwork();
        createWiFiPage.inputWiFiName(wifiName);
        createWiFiPage.createWiFiNetwork();
        Assert.assertTrue(settingsPage.wifiNetworkIsPresent(wifiName));
    }

    /*
   This test connects to new WiFi Network
   1. Click at new WiFi network from test addWiFiNetwork

   Expected: Should be changed status of connection
   */
    @Test
    public void connectToNewWiFiNetwork() {
        settingsPage.connectToNewWiFiNetwork(wifiName);
        Assert.assertTrue(settingsPage.isConnectedWiFiNetwork(wifiName));

    }

    private String generateWiFiName() {
        Random rnd = new Random();
        int nameSuffix = (rnd.nextInt(100_000));
        String wifiName = "NewWiFi" + nameSuffix;
        return wifiName;

    }

}
