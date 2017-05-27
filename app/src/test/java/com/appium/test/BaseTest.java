package com.appium.test;

import com.appium.base.AppiumBase;
import com.appium.pages.CreateWiFiNetworkPage;
import com.appium.pages.CreateWiFiNetworkPageAndroid;
import com.appium.pages.CreateWiFiNetworkPageIOS;
import com.appium.pages.WiFiSettingsPage;
import com.appium.pages.WiFiSettingsPageAndroid;
import com.appium.pages.WiFiSettingsPageIOS;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.appium.java_client.AppiumDriver;

/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */

public class BaseTest extends AppiumBase {
    protected static WiFiSettingsPage settingsPage;
    protected static CreateWiFiNetworkPage createWiFiPage;
    protected static AppiumDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        AppiumDriver driver = new AppiumBase().build();

        switch (AppiumBase.executionOS) {
            case ANDROID:
                settingsPage = new WiFiSettingsPageAndroid(driver);
                createWiFiPage = new CreateWiFiNetworkPageAndroid(driver);
                break;
            case IOS:
                settingsPage = new WiFiSettingsPageIOS(driver);
                createWiFiPage = new CreateWiFiNetworkPageIOS(driver);
                break;
        }
    }

    @AfterClass
    public static void stop() {
        AppiumBase apiumBase = new AppiumBase();
        apiumBase.stop();
    }
}



