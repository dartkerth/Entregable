package com.jag.finalExam.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FlightCheckout extends Page {

    @FindBy(className = "modal-inner modal-dismiss")
    private WebElement modalMessage;

    @FindBy(xpath = "//*[contains(@class,'modal-inner modal-dismiss')]//button[@class=\"btn-close modal-close btn-primary\"]")
    private WebElement closeModalButton;

    @FindBy(id = "cko-form")
    private WebElement checkoutForm;

    @FindBy(id = "preferences")
    private WebElement travelerPreferences;

    @FindBy(id = "insurance")
    private WebElement flightInsurance;

    @FindBy(id = "assurance")
    private WebElement companyAssurance;

    @FindBy(id = "payments")
    private WebElement paymentSection;

    @FindBy(id = "email")
    private WebElement createAccount;

    @FindBy(id = "complete")
    private WebElement completeBookingSection;

    @FindBy(id = "complete-booking")
    private WebElement completeBookingBUtton;

    private String XPATH_TO_VISA_LOGO = "//*[@id=\"payment-type-creditcard\"]//*[@class=\"logo cc-visa\"]";

    public FlightCheckout(WebDriver inDriver) {
        super(inDriver);
    }

    public void waithForElements() {
        /**getWebWait().until(ExpectedConditions.elementToBeClickable(modalMessage));
        if (modalMessage.isDisplayed()) {
            getWebWait().until(ExpectedConditions.elementToBeClickable(closeModalButton));
            closeModalButton.click();
        }**/
        getWebWait().until(ExpectedConditions.elementToBeClickable(checkoutForm));
        getWebWait().until(ExpectedConditions.elementToBeClickable(travelerPreferences));
        getWebWait().until(ExpectedConditions.elementToBeClickable(flightInsurance));
        //getWebWait().until(ExpectedConditions.elementToBeSelected(companyAssurance));
        getWebWait().until(ExpectedConditions.elementToBeClickable(paymentSection));
        getWebWait().until(ExpectedConditions.elementToBeClickable(completeBookingSection));
        getWebWait().until(ExpectedConditions.elementToBeClickable(completeBookingBUtton));
    }

    public boolean checkCheckoutForm() {
        return false;
    }

    public boolean checkTravelPrefereces() {
        return false;
    }

    public boolean checkFlightInsurance() {
        return false;
    }

    public boolean checkCompanyAssurance() {
        return false;
    }

    public boolean checkPaymentSection() {
        return false;
    }

    public boolean checkCreateAccount() {
        return false;
    }

    public boolean checkCompleteBookingSection() {
        return false;
    }

    public boolean checkCompleteBookingBUtton() {
        return false;
    }

    public boolean findVisaPayment() {
        List checkList = getDriver().findElements(By.xpath(XPATH_TO_VISA_LOGO));
        if (checkList.size() > 0) {
            System.out.println("There's a visa logo present");
            return true;
        }
        return false;
    }
}
