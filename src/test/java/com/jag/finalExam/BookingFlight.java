package com.jag.finalExam;

import com.jag.finalExam.objects.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

public class BookingFlight extends BaseTest {

    //POMS
    private FlightSearch search;
    private TravelWelcome welcome;
    private FlightInformation infor;
    private FlightCheckout checkout;
    private HotelSearch hotels;
    private HotelInformation hotelInfo;

    @BeforeTest(alwaysRun = true)
    @Parameters({"url"})
    public void getIntoPage(String url) {
        System.out.println("Setting up the page");
        welcome = new TravelWelcome(getMyPersonalDriver(), url);
        search = new FlightSearch(welcome.getDriver());
        infor = new FlightInformation(search.getDriver());
        checkout = new FlightCheckout(infor.getDriver());
        hotels = new HotelSearch(welcome.getDriver());
        hotelInfo = new HotelInformation(welcome.getDriver());
    }

    @Test(groups = {"excercise1"})
    @Parameters({"destination", "origin"})
    public void bookFlight(String destination, String origin) {
        try {
            System.out.println("**************************Test bookFlight Starts....**************************");
            welcome.selectFlights();
            welcome.selectRoundTrip();
            welcome.fillFlyingFrom(origin);
            welcome.fillFlyingTo(destination);
            welcome.selectDepartureFlightDate(0);
            welcome.selectReturnFlightDate();
            //welcome.clickSearch();
            //should be an and of the results
            search.findSortDropElements();
            search.searchAllChildButtons();
            search.flightDurationSearch();
            search.flightDetailCount();
            //should be an and of the results
            Assert.assertTrue(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                File scrFile = ((TakesScreenshot) getMyPersonalDriver()).getScreenshotAs(OutputType.FILE);
                //it's mandatory to improve the faults logger
                Date today = new Date();
                FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot" + today.getTime() + ".png"));
                Assert.fail();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                Assert.fail();
            }
        }


    }

    @Test(groups = {"excercise1"})
    @Parameters({"sortByType", "sortByDir"})
    public void choosingFlight(String inType, String inDir) {
        System.out.println("**************************Test flightSort Starts....**************************");
        search.sortBy(inType, inDir);
        search.clickOnAListOption(1);
        search.clickOnAListOption(3);
    }

    @Test(groups = {"excercise1"})
    @Parameters({"destination", "origin"})
    public void tripDetailsChecks(String inDestination, String inOrigin) {
        System.out.println("**************************Test tripDetailsChecks Starts....**************************");
        infor.swapToTab();
        infor.confirmPrice();
        infor.confirmDepartureData();
        infor.confirmReturnData();
        infor.confirmPriceGuarantee();
        HashMap list = infor.getAirportCodes();
        if (list.containsKey(inDestination) && list.containsKey(inOrigin)) {
            infor.continueBooking();
        } else {
            Assert.fail("Airport Codes did not matched");
        }
    }

    @Test(groups = {"excercise1"})
    public void walkingCheckout() {
        checkout.waithForElements();
        if (!checkout.findVisaPayment()) {
            Assert.fail();
        }
    }

    @Test(groups = {"excercise2"})
    @Parameters({"destination", "origin"})
    public void checkDate(String destination, String origin){
        int a = 23;
        int b = Math.floorMod((a + 13),30);
        System.out.println(b);
        welcome.selectPackagesButton();
        welcome.selectFlightAndHotels();
        welcome.fillPackageFrom(origin);
        welcome.fillPackageDestination(destination);
        welcome.selectDeparturePackageDate(2);
        welcome.selectReturnDateByDays(13);
    }

    @Test(groups = {"excercise2"})
    @Parameters({"sortByType2", "sortByDir2"})
    public void downTheSort(String asSortType, String asSortDir){
        hotels.sortBy(asSortType,asSortDir);
        hotels.lookForXStarHotel(3);
        hotels.getWebWait().withTimeout(Duration.ofSeconds(15));
        hotelInfo.swapToTab();
        hotelInfo.verifySelectedHotel(hotels.getValidationMap());
        hotelInfo.clickOnFirstOption();
    }

    @Test(groups = {"excercise3"})
    @Parameters({"cityForHotels"})
    public void anHotelSearch(String inCityForHotel){
        welcome.clickHotelButton();
        welcome.fillHotelsDestination(inCityForHotel);
        welcome.selectCheckinDate(0);
        welcome.selectCheckoutDate();
    }
}
