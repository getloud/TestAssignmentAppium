# Appium cross platform example

An example project of cross platform testing  on Android and iOS application. All tests work only with iOS/Android emulator.
List of test cases:
- addWiFiNetwork
- connectToNewWiFiNetwork

## Tested application

For this project I developed simple app for two platforms Android and iOS. The main idea of app is creating new public WiFi Networks. 

#### Android 
```
(../TestAssignment/app/src/main/WiFiSettings.apk)
```
I would like to make this android app similiar to real Android WiFi Settings menu. So I used WifiManager and WifiConfiguration classes to have posebility create real WiFi networks.

#### iOS 
```
(../TestAssignment/app/src/main/WiFiSettingS.app)
```
As iOS doesn't have public API for WiFi settings my iOS app is working as test model.

## Functionality of application 
- Create new wifi network
- Connect to new wifi network
- Show list of available networks
- Show simple status about connection


## Environment
- Android Stuido 
- Genymotion emulator (https://www.genymotion.com) (because in default Android emulator WiFi functionality is disabled)
- Appium 1.6.4 (npm install -g appium@1.6.4 )
- Selenium 3.4.0
- XCUITest (https://github.com/appium/appium-xcuitest-driver)


## Presetup
- Import this project in Android Studio
- Open Genymotion GUI
- Create Android virtual Device with name: ```Google_Nexus_4_ ```
- Run ```Google_Nexus_4_```

## Instructions
- Run Appium in terminal by ```appium```
- Set the ``executionOS`` variable in the AppiumBase class (/app/src/test/java/com/appium/base/AppiumBase.java) to ANDROID or IOS.
- Run scope of tests ``WiFiSettingsTest`` in (/app/src/test/java/com/appium/test/WiFiSettingsTest.java)
 
 
