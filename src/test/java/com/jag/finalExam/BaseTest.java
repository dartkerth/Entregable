package com.jag.finalExam;

import com.jag.finalExam.objects.Drivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest{
    private Drivers myPersonalDriver;
    private String initialPage;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser","url"})
    public void beforeSuite(String inBrowser, String inDestiniy){
        myPersonalDriver = new Drivers(inBrowser);
        initialPage = inDestiniy;
        myPersonalDriver.getMyDriver().get(inDestiniy);
        myPersonalDriver.getMyDriver().manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void dispose(){
        myPersonalDriver.getMyDriver().quit();
    }

    protected WebDriver getMyPersonalDriver() {
        return myPersonalDriver.getMyDriver();
    }

    protected String getInitialPage() {
        return initialPage;
    }
}