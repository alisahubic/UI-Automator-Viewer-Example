package com.example.alisa.uiautomatorviewer;

import android.app.UiAutomation;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;
import android.support.test.uiautomator.UiSelector;

import java.util.List;

/**
 * Created by alisa on 7/11/16.
 */
public class Monefy extends InstrumentationTestCase {

    private UiDevice device;
    public static final String applicationName = "Monefy";
    public static final String packageName = "com.monefy.app.lite";


    @Override
    public void setUp() throws Exception {
        device = UiDevice.getInstance(getInstrumentation());
        device.wait(Until.hasObject(By.text(applicationName)), 10000);
        device.findObject(By.text(applicationName)).click();

    }

    public void testMonefy() throws Exception {

        device.wait(Until.hasObject(By.res(packageName, "income_button")), 10000);
        UiObject2 addButtonn = device.findObject(By.res(packageName, "income_button"));
        addButtonn.click();
        
        device.wait(Until.hasObject(By.res(packageName, "amount_text")), 5000);
        UiObject2 Amount = device.findObject(By.res(packageName, "amount_text"));

        for (int i = 0; i < 5; i++) {
            device.findObject(By.res(packageName, "buttonKeyboard5")).click();
        }

        UiObject2 chooseCategoryBtn = device.findObject(By.text("Choose category"));
        chooseCategoryBtn.click();

        UiObject2 calendarBtn = device.findObject(By.res(packageName, "calendar"));
        calendarBtn.click();
        device.pressBack();

        List<UiObject2> listOfTypes = device.findObjects(By.clazz("android.widget.LinearLayout"));
        listOfTypes.get(2).click();

        device.waitForIdle();
        device.wait(Until.hasObject(By.text("All accounts")), 10000);

        UiObject2 balanceBtn = device.findObject(By.res(packageName, "balance_container"));
        balanceBtn.click();
        device.waitForIdle();

        UiObject2 minBtn = device.findObject(By.res(packageName, "expense_button"));
        minBtn.click();

        device.waitForIdle();
        device.wait(Until.hasObject(By.text("Choose category")), 10000);

        for (int i = 0; i < 5; i++) {
            device.findObject(By.res(packageName, "buttonKeyboard1")).click();
        }

        chooseCategoryBtn = device.findObject(By.text("Choose category"));
        chooseCategoryBtn.click();

        calendarBtn = device.findObject(By.res(packageName, "calendar"));
        calendarBtn.click();
        device.pressBack();

        listOfTypes = device.findObjects(By.clazz("android.widget.LinearLayout"));
        listOfTypes.get(2).click();

        device.waitForIdle();
        device.pressBack();


    }


}