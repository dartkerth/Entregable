package com.jag.finalExam.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

public class HotelInformation extends Page {
    //Objects identified
    @FindBy(id = "hotel-name")
    private WebElement hotelName;
    @FindBy(className = "price link-to-rooms")
    private WebElement finalPrice;
    @FindBy(xpath = "//*[@class=\"reviews-link link-to-reviews\"]/span")
    private WebElement reviewsNumber;
    @FindBy(id = "rooms-and-rates")
    private WebElement roomsAndRatesList;
    @FindBy(xpath = "//*[@id=\"rooms-and-rates\"]//*[@data-room-index][1]//*[@role=\"button\"]")
    private WebElement firstListButton;

    //@FindBy()
    //private WebElement
    //@FindBy()
    //private WebElement
    //@FindBy()
    //private WebElement
    //@FindBy()
    //private WebElement
    //Objects for transaction
    public HotelInformation(WebDriver inDriver) {
        super(inDriver);
    }

    /**
     * i know it's a rather awful implementation, while i search for a better one
     *
     * @param asValidationData pair so Strinf,String with the named value.
     * @return is validated?
     */
    public boolean verifySelectedHotel(HashMap<String, String> asValidationData) {
        getWebWait().until(ExpectedConditions.elementToBeSelected(hotelName));
        getWebWait().until(ExpectedConditions.elementToBeSelected(finalPrice));
        getWebWait().until(ExpectedConditions.elementToBeSelected(reviewsNumber));
        System.out.println("+++++++++The validation data ++++++++++++");
        for(String key : asValidationData.keySet()){
            System.out.println(asValidationData.get(key));
        }

        if (hotelName.getText().contains(asValidationData.get("hotel-name"))&&finalPrice.getText().contains(asValidationData.get("actualPrice"))&&asValidationData.get("actualPrice").contains(reviewsNumber.getText())) {
            return true;
        }
        return false;
    }

    public void clickOnFirstOption(){
        actions.moveToElement(firstListButton);
        getWebWait().until(ExpectedConditions.elementToBeClickable(firstListButton));
        actions.moveToElement(firstListButton).click().perform();
    }

}
