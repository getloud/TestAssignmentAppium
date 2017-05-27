package com.appium.base;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


/**
 * Created by oleksandrlezvinskyi on 5/25/17.
 */

public class AppiumBase {

    //Choose Platform on which you would like to test
    public static OS executionOS = OS.IOS;

    public enum OS {
        ANDROID,
        IOS
    }

    public static AppiumDriver driver;


    public AppiumDriver build() throws IOException, InterruptedException {

        if (driver != null) {
            return driver;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (executionOS) {
            case ANDROID:
                File classpathRootAndroid = new File(System.getProperty("user.dir"));
                File appDirAndroid = new File(classpathRootAndroid, "/app/src/main/");
                File appAndroid = new File(appDirAndroid, "WiFiSettings.apk");

                capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", appAndroid.getAbsolutePath());
                capabilities.setCapability("deviceName", "Google_NEXUS_4_");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "5.1");
                capabilities.setCapability("appPackage", "com.example.wood.wifinetworksettingsapp");
                capabilities.setCapability("appActivity", "com.example.wood.wifinetworksettingsapp.MainActivity");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;

            case IOS:
                File classpathRootIOS = new File(System.getProperty("user.dir"));
                File appDirIOS = new File(classpathRootIOS, "/app/src/main/");
                File appIOS = new File(appDirIOS, "WiFiSettingS.app");

                capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", appIOS.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("deviceName", "iPhone 5s");
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("platformVersion", "10.3");
                capabilities.setCapability("bundleId", "com.woodwayfarer.org.WiFiSettingS");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;

        }

        return driver;
    }

    public static void stop() {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.quit();
            driver = null;
        }
    }

}
