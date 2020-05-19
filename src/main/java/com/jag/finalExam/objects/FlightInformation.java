package com.jag.finalExam.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightInformation extends Page {

    @FindBy(css = "html.firefox.js.flexbox.flexboxlegacy.canvas.webgl.no-touch.geolocation.hashchange.history.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.localstorage.sessionstorage.svg.inlinesvg.pointerevents.mediaqueries.placeholder.formvalidation.details.datalistelem.json.no-win8touch.checkedselector.no-highres.no-ipad.no-iphone.no-ipod.no-android.no-appleios.positionfixed.datauri body.wrap.cf.exp6805-1.exp11820-1.exp12051-0.exp13193-1.exp15445-0.exp15446-0.exp16400-1.exp24823-0.exp24887-1.exp26468-0.exp27200-0.exp28228-0.qualifiedForExp27267 header#fisHeader.cols-row-header.cf.page-header.no-group.uitk-grid h1.section-header-main")
    private WebElement pageTitle;

    @FindBy(className = "tripSummary")
    private WebElement tripSummaryHeader;

    @FindBy(className = "tripTotals")
    private WebElement tripTotals;

    @FindBy(className = "flex-area-primary")
    private WebElement flightInfo;

    @FindBy(className = "priceGuarantee")
    private WebElement priceGuaranteeSection;

    @FindBy(id = "bookButton")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@class=\"flex-area-primary\"]//*[contains(@class,'airportCode')]")
    private List<WebElement> airportCodes;

    private String XPATH_TO_TOTAL_PRICE = "//*[@class=\"tripSummary\"]//*[@class=\"tripTotalPrice visuallyhidden\"]";
    private String XPATH_TO_DEPARTURE_DATES = "//*[@class=\"flex-area-primary\"]//*[contains(@class,'departureDate')]";
    private String XPATH_TO_DESTINATIONS = "//*[@class=\"flex-area-primary\"]//*[@class=\"airport\"]";
    private String XPATH_TO_FLIGHT_DESTINATIONS = "//*[@class=\"flex-area-primary\"]//*[@class=\"flightSummary-timeDuration cf\"]";


    public FlightInformation(WebDriver inDriver) {
        super(inDriver);
    }


    /**
     * Just checks if the label exists an it's not null
     */
    public boolean confirmPrice() {
        getWebWait().until(ExpectedConditions.visibilityOf(tripSummaryHeader));
        if (tripSummaryHeader.findElements(By.xpath(XPATH_TO_TOTAL_PRICE)).get(0).getText() != null && !tripSummaryHeader.findElements(By.xpath(XPATH_TO_TOTAL_PRICE)).get(0).getText().isEmpty()) {
            System.out.println("Value for the total trip: " + tripSummaryHeader.findElements(By.xpath(XPATH_TO_TOTAL_PRICE)).get(0).getText());
            return true;
        }
        return false;
    }

    /**
     * The mission for this function is to ensure that no info is null
     */
    public boolean confirmDepartureData() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(flightInfo));
        if (flightInfo.findElements(By.xpath(XPATH_TO_DEPARTURE_DATES)).size() > 0) {
            for (WebElement unit : flightInfo.findElements(By.xpath(XPATH_TO_DEPARTURE_DATES))) {
                System.out.println(unit.getText());
            }
            return true;
        }
        if(flightInfo.findElements(By.xpath(XPATH_TO_DESTINATIONS)).size() > 0){
            for (WebElement unit : flightInfo.findElements(By.xpath(XPATH_TO_DESTINATIONS)))
            {
                System.out.println(unit.getText());
            }
            return true;
        }
        if(flightInfo.findElements(By.xpath(XPATH_TO_FLIGHT_DESTINATIONS)).size() > 0) {
            for (WebElement unit : flightInfo.findElements(By.xpath(XPATH_TO_FLIGHT_DESTINATIONS))) {
                System.out.println(unit.getText());
            }
            return true;
        }
        return false;
    }

    /**
     * The mission for this function is to ensure that no info is null
     */
    public void confirmReturnData() {

    }

    public HashMap<String,String> getAirportCodes(){
        HashMap<String,String> listOfCodes = new HashMap<String,String>();
        getWebWait().until(ExpectedConditions.visibilityOf(flightInfo));
        for(WebElement item : airportCodes){
            System.out.println(item.getText());
            listOfCodes.put(item.getText(),item.getText());
        }
        return listOfCodes;
    }

    public void confirmPriceGuarantee() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(priceGuaranteeSection));
        System.out.println(priceGuaranteeSection.getText());
    }

    public void continueBooking() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
}
