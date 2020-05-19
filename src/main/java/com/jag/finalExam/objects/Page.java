package com.jag.finalExam.objects;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class Page {
    protected String REPLACE_STRING = "_NUMBER_";
    private WebDriver driver;
    private WebDriverWait webWait;
    protected Actions actions;
    private double times;

    public Page(WebDriver inDriver) {
        PageFactory.initElements(inDriver, this); // Y esto con que se come?
        webWait = new WebDriverWait(inDriver, 20);
        driver = inDriver;
        actions = new Actions(inDriver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void dispose() {
        //if (driver != null)
        //  driver.quit();

    }

    public WebDriverWait getWebWait() {
        return webWait;
    }


    public boolean isDialogPresent(WebDriver driver) {
        try {
            getWebWait().until(ExpectedConditions.alertIsPresent());
            Alert alert = ExpectedConditions.alertIsPresent().apply(driver);
            return (alert != null);
        } catch (TimeoutException e) {
            System.out.println(e);
            return false;
        }
    }

    private List getPageLinks() {
        List allLinks = driver.findElements(By.tagName("a"));
        return allLinks;
    }

    private void fillTextField(WebElement textbox) {
        textbox.sendKeys(" ");
    }

    protected void fillGenericAutoComplete(WebElement asAutocompleteBox, String asAutomcompleteXpath, String asValue, int asResultNumber) {
        String xpathForResult = asAutomcompleteXpath.replace(REPLACE_STRING, String.valueOf(asResultNumber));
        System.out.println(xpathForResult);
        getWebWait().until(ExpectedConditions.elementToBeClickable(asAutocompleteBox));
        asAutocompleteBox.click();
        asAutocompleteBox.sendKeys(asValue);
        asAutocompleteBox.sendKeys(Keys.DOWN);
        getWebWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath(xpathForResult.trim()))));
        asAutocompleteBox.sendKeys(Keys.DOWN);
        asAutocompleteBox.sendKeys(Keys.TAB);
    }

    protected void fillGenericAutoComplete(WebElement asAutocompleteBox, WebElement asAutocompleteDropdown, String asValue) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(asAutocompleteBox));
        asAutocompleteBox.click();
        asAutocompleteBox.sendKeys(asValue);
        asAutocompleteBox.sendKeys(Keys.DOWN);
        getWebWait().until(ExpectedConditions.elementToBeClickable(asAutocompleteDropdown));
        asAutocompleteBox.sendKeys(Keys.DOWN);
        asAutocompleteBox.sendKeys(Keys.TAB);
    }

    /**
     * it depends that you provide the necessary webElements
     *
     * @param asReturningDate
     * @param nextPageMonthReturn
     * @param firstSaturdayMonthReturn
     */
    protected void selectReturnGenericDate(WebElement asReturningDate, WebElement nextPageMonthReturn, WebElement firstSaturdayMonthReturn) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(asReturningDate));
        asReturningDate.click();
        double lTimes = Math.random() * (11 - times);//Up to a year
        System.out.println(lTimes);

        getWebWait().until(ExpectedConditions.elementToBeClickable(nextPageMonthReturn));
        for (int i = 0; i < lTimes; i++) {
            if (nextPageMonthReturn.isDisplayed()) {
                nextPageMonthReturn.click();
            } else {
                break;
            }
        }
        getWebWait().until(ExpectedConditions.elementToBeClickable(firstSaturdayMonthReturn));
        firstSaturdayMonthReturn.click();
        asReturningDate.sendKeys(Keys.ENTER);
    }

    /**
     * it depends that you provide the necessary webElements
     *
     * @param asReturningDate
     * @param dayForReturn
     */
    protected void selectReturnSameMonthGenericDate(WebElement asReturningDate, WebElement dayForReturn) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(asReturningDate));
        asReturningDate.click();
        double lTimes = Math.random() * (11 - times);//Up to a year
        System.out.println(lTimes);

        getWebWait().until(ExpectedConditions.elementToBeClickable(dayForReturn));
        dayForReturn.click();
        asReturningDate.sendKeys(Keys.ENTER);
    }

    /**
     * it depends that you provide the necessary webElements
     *
     * @param asDepartureDate
     * @param nextPageMonthButton
     * @param firstSaturdayMonthButton
     * @param asPlusMonths
     */
    public void selectDepartureGenericDate(WebElement asDepartureDate, WebElement nextPageMonthButton, WebElement firstSaturdayMonthButton, int asPlusMonths) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(asDepartureDate));
        asDepartureDate.click();
        times = Math.random() * 9; //Due to page limitations, up nine months ahead, not the whole year.
        //As needed, if asPLusMonths is bigger than zero, it's necessary to change it
        times = times > asPlusMonths ? times : times + asPlusMonths;
        System.out.println(times);
        getWebWait().until(ExpectedConditions.elementToBeClickable(nextPageMonthButton));
        for (int i = 0; i < times; i++) {
            //makes it slower, but more stable
            getWebWait().until(ExpectedConditions.elementToBeClickable(nextPageMonthButton));
            nextPageMonthButton.click();
        }
        getWebWait().until(ExpectedConditions.elementToBeClickable(firstSaturdayMonthButton));
        firstSaturdayMonthButton.click();
    }

    /**
     * In case you have an xpath to
     *
     * @param asBaseElement
     * @param asContinuedXpath
     * @return
     */
    private String generateXpathFromWebElement(WebElement asBaseElement, String asContinuedXpath) {
        String result = "//*[@_METHOD_=\"_SELECTOR_\"]";
        if (asBaseElement.getAttribute("id") != null) {
            result = result.replace("_METHOD_", "id");
            result = result.replace("_SELECTOR_", asBaseElement.getAttribute("id"));
        } else {
            result = result.replace("_METHOD_", "class");
            result = result.replace("_SELECTOR_", asBaseElement.getAttribute("class"));
        }
        System.out.println(result);
        result = result + asContinuedXpath;
        return result;
    }


    public void swapToTab() {
        for (String handle : getDriver().getWindowHandles()) {
            System.out.println(handle);
            if (getDriver().getWindowHandle().equals(handle))
                System.out.println("The same window");
            else {
                System.out.println("Swapping to page: ");
                getDriver().switchTo().window(handle);
            }
        }

    }


}
