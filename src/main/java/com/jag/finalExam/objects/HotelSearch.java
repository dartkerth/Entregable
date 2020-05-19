package com.jag.finalExam.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;

public class HotelSearch extends Page {

    @FindBy(className = "pagination-next")
    private WebElement nextPaginationButton;

    @FindBy(id = "bcol")
    private WebElement resultsList;

    @FindBy(xpath = "//*[@class=\"sort-filter-bar control box\"]//*[@data-opt-group=\"Price\"]")
    private WebElement priceButton;

    private String XPATH_FOR_STARS_RATINGS = "//*[@id]//li[contains(@class,'starRating')]//span[@class!=\"visuallyhidden\"]";
    private String XPATH_TO_BRING_RESULT_DESIRED_STAR_RATING = "//*[@id]//li[contains(@class,'starRating')]//span[@title=\"_NUMBER_\"]";
    private String REPLACE_LINE = "_NUMBER_";

    public HashMap<String, String> getValidationMap() {
        return validationMap;
    }

    private HashMap<String, String> validationMap;

    public HotelSearch(WebDriver inDriver) {
        super(inDriver);
        validationMap = new HashMap<>();
    }

    /**
     * When called it will look for a hotel with the value os stars given bye *stars*
     *
     * @param stars number of stars to look for
     */
    public void lookForXStarHotel(int stars) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(resultsList));
        String searchLine = XPATH_TO_BRING_RESULT_DESIRED_STAR_RATING.replace(REPLACE_LINE, stars + ".0");
        System.out.println(searchLine);
        List<WebElement> aviableOptions = getDriver().findElements(By.xpath(searchLine));
        System.out.println("There is "+aviableOptions.size()+" 3 stars hotels");
        if (aviableOptions.size() > 0) {
            getWebWait().until(ExpectedConditions.elementToBeClickable(resultsList));
            System.out.println("Setting up validation values");
            validationMap.put("hotel-name", aviableOptions.get(0).findElement(By.xpath("ancestor::div//*[@data-automation=\"hotel-name\"]")).getText());
            System.out.println(aviableOptions.get(0).findElement(By.xpath("ancestor::div//*[@data-automation=\"hotel-name\"]")).getText());
            validationMap.put("neighborhood secondary", aviableOptions.get(0).findElement(By.xpath("ancestor::div//*[@class=\"neighborhood secondary \"]")).getText());
            System.out.println(aviableOptions.get(0).findElement(By.xpath("ancestor::div//*[@class=\"neighborhood secondary \"]")).getText());
            validationMap.put("actualPrice", aviableOptions.get(0).findElement(By.xpath("ancestor::div/../..//*[@class=\"actualPrice price fakeLink \"]")).getText());
            System.out.println(aviableOptions.get(0).findElement(By.xpath("ancestor::div/../..//*[@class=\"actualPrice price fakeLink \"]")).getText());
            validationMap.put("reviewCount", aviableOptions.get(0).findElement(By.xpath("ancestor::div/../..//*[@class=\"reviewCount fakeLink secondary\"]//*[@aria-hidden]")).getText());
            System.out.println(aviableOptions.get(0).findElement(By.xpath("ancestor::div/../..//*[@class=\"reviewCount fakeLink secondary\"]//*[@aria-hidden]")).getText());
            System.out.println("About to click on the damn button");
            //actions.moveToElement(aviableOptions.get(0)).click().perform();
            WebElement linkToHotel =  aviableOptions.get(0).findElement(By.xpath("ancestor::div/ancestor::div"));
            //System.out.println(linkToHotel.getTagName()+","+linkToHotel.getText()+","+linkToHotel.getAttribute("class")+","+linkToHotel.getAttribute("href"));
            Actions actions2 = new Actions(getDriver());
            getWebWait().until(ExpectedConditions.elementToBeClickable(resultsList));
            getWebWait().until(ExpectedConditions.elementToBeClickable(linkToHotel));
            actions2.moveToElement(linkToHotel).click().perform();

            linkToHotel.click();
        } else {
            getWebWait().until(ExpectedConditions.elementToBeClickable(nextPaginationButton));
            nextPaginationButton.click();
            lookForXStarHotel(stars);
        }
    }

    public void sortBy(String asType, String asDir) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(resultsList));
        getWebWait().until(ExpectedConditions.elementToBeClickable(priceButton));
        priceButton.click();
    }
}
