package com.jag.finalExam.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelWelcome extends Page {

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightsButton;

    @FindBy(id = "tab-package-tab-hp")
    private WebElement packagesButton;

    @FindBy(id="tab-hotel-tab-hp")
    private WebElement hotelsButton;

    @FindBy(id = "tab-cruise-tab-hp")
    private WebElement cruisesButton;

    @FindBy(id = "hotel-destination-hp-hotel")
    private WebElement goingToTextArea;

    @FindBy(id = "partialHotelBooking-hp-package")
    private WebElement partialStayCheck;

    @FindBy(id = "cruise-destination-hp-cruise")
    private WebElement cruiseDestination;

    @FindBy(id = "cruise-departure-month-hp-cruise")
    private WebElement cruiseDepartureMonth;

    @FindBy(id = "package-origin-hp-package")
    private WebElement packageOrigin;

    @FindBy(xpath = "//*[@id=\"gcw-packages-form-hp-package\"]/div[3]//*[@class=\"autocomplete-dropdown\"]")
    private WebElement packageDropdown;

    @FindBy(id = "package-destination-hp-package")
    private WebElement packageDestination;

    @FindBy(xpath = "//*[@id=\"gcw-packages-form-hp-package\"]//*[@class=\"col sub-nav-radio-button-for-high-contrast-mode\"]")
    private WebElement flightPlusHotelButton;

    @FindBy(id = "flight-type-roundtrip-label-hp-flight")
    private WebElement roundTripButton;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement originTextBox;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[3]/div[1]/div/div[2]")
    private WebElement listFirstOption;

    @FindBy(className = "autocomplete-dropdown")
    private WebElement autocompleteDropdown;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement destinationTextBox;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[3]/div[2]/div/div[2]")
    private WebElement secondListFirstOption;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departingDate;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returningDate;

    @FindBy(id = "package-departing-hp-package")
    private WebElement packageDepartingDate;

    @FindBy(id = "package-returning-hp-package")
    private WebElement packageReturningDate;

    @FindBy(id = "hotel-checkin-hp-hotel")
    private WebElement hotelCheckinDate;

    @FindBy(id = "hotel-checkout-hp-hotel")
    private WebElement hotelCheckoutDate;

    @FindBy(xpath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/button[2]")
    private WebElement nextPageMonthDeparture;

    @FindBy(xpath = "//*[@id=\"flight-returning-wrapper-hp-flight\"]/div/div/button[2]")
    private WebElement nextPageMonthReturn;

    @FindBy(xpath = "//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/button[2]")
    private WebElement nextPageMonthCheckin;

    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div/div/button[2]")
    private WebElement nextPageMonthCheckout;

    @FindBy(xpath = "//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/button[2]")
    private WebElement nextPageMonthPackageDeparture;

    @FindBy(xpath = "//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/button[2]")
    private WebElement nextPageMonthPackageReturn;
    //El objetivo inicial era coger siempre el primer día del mes, perp es mejor ir a la fija siempre con el sabado
    @FindBy(xpath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button")
    private WebElement firstSaturdayMonthDeparting;
    //This should be random
    @FindBy(xpath = "//*[@id=\"flight-returning-wrapper-hp-flight\"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button")
    private WebElement firstSaturdayMonthReturn;
    //El objetivo inicial era coger siempre el primer día del mes, perp es mejor ir a la fija siempre con el sabado
    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button")
    private WebElement firstSaturdayMonthCheckin;
    //This should be random
    @FindBy(xpath = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button")
    private WebElement firstSaturdayMonthCheckout;
    //El objetivo inicial era coger siempre el primer día del mes, perp es mejor ir a la fija siempre con el sabado
    @FindBy(xpath = "//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button")
    private WebElement firstSaturdayMonthPackageDeparting;
    //This should be random
    @FindBy(xpath = "//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button")
    private WebElement firstSaturdayMonthPackageReturn;

    @FindBy(xpath = "//*[@id=\"package-returning-wrapper-hp-package\"]//*[@data-day=17]")
    private WebElement returnPackageTwoWeeks;
    //*[@id="gcw-flights-form-hp-flight"]/div[9]/label/button
    //*[@id="flight-returning-wrapper-hp-flight"]/div/div/div[3]/table/tbody/tr[1]/td[5]
    //*[@id="flight-returning-wrapper-hp-flight"]/div/div/div[3]/table/tbody/tr[1]/td[1]
    //*[@id="flight-returning-wrapper-hp-flight"]/div/div/div[3]/table/tbody/tr[1]/td[7]/button
    //*[@id="flight-departing-wrapper-hp-flight"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button

    @FindBy(css = "button.btn-action")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[9]/label/button")
    private WebElement submitButtonId;

    private String XPATH_FOR_N_DROPOUT_RESULT = "//*[@id=\"gcw-packages-form-hp-package\"]/div[3]/div[_NUMBER_]//*[@class=\"autocomplete-dropdown\"]";
    private String XPATH_FOR_NEXT_MONTH_BUTTON = "//*[@id=\"_TYPE_-returning-wrapper-hp-_TYPE_\"]/div/div/div[2]/table/tbody/tr[1]/td[7]/button";
    private String XPATH_FOR_HOTEL_DROPOUT = "//*[@id=\"gcw-hotel-form-hp-hotel\"]//*[@class=\"autocomplete-dropdown\"]";


    public TravelWelcome(WebDriver asDriver, String asUrl) {
        super(asDriver);
        //getDriver().get(asUrl);
        //getDriver().manage().window().maximize();
    }

    /**
     * Due to a need from the test, it's mandatory to check post two months the actual date
     *
     * @param asPlusMonths if needed, the months are moved foward.
     */
    public void selectDepartureFlightDate(int asPlusMonths) {
        selectDepartureGenericDate(departingDate,nextPageMonthDeparture,firstSaturdayMonthDeparting,asPlusMonths);
    }

    public void selectReturnFlightDate() {
        selectReturnGenericDate(returningDate,nextPageMonthReturn,firstSaturdayMonthReturn);
    }

    /**
     * Due to a need from the test, it's mandatory to check post two months the actual date
     *
     * @param asPlusMonths if needed, the months are moved foward.
     */
    public void selectCheckinDate(int asPlusMonths) {
        selectDepartureGenericDate(hotelCheckinDate,nextPageMonthCheckin,firstSaturdayMonthCheckin,asPlusMonths);
    }

    public void selectCheckoutDate() {
        selectReturnGenericDate(hotelCheckoutDate,nextPageMonthReturn,firstSaturdayMonthReturn);
    }
    /**
     * Due to a need from the test, it's mandatory to check post two months the actual date
     *
     * @param asPlusMonths if needed, the months are moved foward.
     */
    public void selectDeparturePackageDate(int asPlusMonths) {
        selectDepartureGenericDate(packageDepartingDate,nextPageMonthPackageDeparture,firstSaturdayMonthPackageDeparting,asPlusMonths);
    }

    public void selectReturnPackageDate() {
        selectReturnGenericDate(packageReturningDate,nextPageMonthPackageReturn,returnPackageTwoWeeks);
    }

    /**
     * Selects a future date by dates in the calendar, but in the same calendar page
     * @param asDays
     */
    public void selectReturnDateByDays(int asDays){
        selectReturnSameMonthGenericDate(packageReturningDate,returnPackageTwoWeeks);
    }

    public void fillFlyingFrom(String asOrigin) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(originTextBox));
        originTextBox.click();
        originTextBox.sendKeys(asOrigin);
        getWebWait().until(ExpectedConditions.elementToBeClickable(listFirstOption));
        originTextBox.sendKeys(Keys.LEFT);
        originTextBox.sendKeys(Keys.RIGHT);
        originTextBox.sendKeys(Keys.DOWN);
        originTextBox.sendKeys(Keys.TAB);
    }

    public void fillFlyingTo(String asDestination) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(destinationTextBox));
        destinationTextBox.click();
        destinationTextBox.sendKeys(asDestination);
        getWebWait().until(ExpectedConditions.elementToBeClickable(secondListFirstOption));
        destinationTextBox.sendKeys(Keys.DOWN);
        destinationTextBox.sendKeys(Keys.TAB);
    }

    public void fillPackageFrom(String asOrigin){
        fillGenericAutoComplete(packageOrigin,XPATH_FOR_N_DROPOUT_RESULT,asOrigin,1);
    }

    public void fillPackageDestination(String asOrigin){
        fillGenericAutoComplete(packageDestination,XPATH_FOR_N_DROPOUT_RESULT,asOrigin,2);
    }

    public void fillHotelsDestination(String asDestination){
        fillGenericAutoComplete(goingToTextArea,XPATH_FOR_HOTEL_DROPOUT,asDestination,1);
    }

    public void selectFlights() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
    }

    public void selectPackagesButton(){
        getWebWait().until(ExpectedConditions.elementToBeClickable(packagesButton));
        packagesButton.click();
    }

    public void selectFlightAndHotels() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(flightPlusHotelButton));
        flightPlusHotelButton.click();
    }
    public void selectRoundTrip() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(roundTripButton));
        roundTripButton.click();
    }

    public void clickSearch() {
        getWebWait().until(ExpectedConditions.elementToBeSelected(submitButton));
        submitButton.click();
    }
    public void clickHotelButton(){
        getWebWait().until(ExpectedConditions.elementToBeClickable(hotelsButton));
        hotelsButton.click();
    }
}
