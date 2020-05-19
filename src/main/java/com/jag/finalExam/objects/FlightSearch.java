package com.jag.finalExam.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

public class FlightSearch extends Page {

    private HashMap<String,String> elementsExpected;

    private String XPATH_FOR_FLIGHT_RESULTS = "//*[@id=\"flightModuleList\"]/li[@id]/h3";
    private String XPATH_FOR_BUTTONS = "//*[@id=\"flightModuleList\"]/li[@id]//button";
    private String STRING_TO_REPLACE = "_NUMBER_";
    private String XPATH_FOR_DISABLED_SELECT_BUTTONS = "//*[@id=\"flightModuleList\"]//button[@class=\"btn-secondary btn-action t-select-btn btn disabled\"]";
    private String XPATH_FOR_SELECT_CLICKABLE_BUTTONS = "//*[@id=\"flightModuleList\"]/li[_NUMBER_]//button[@data-test-id]";
    private String XPATH_FOR_SELECT_DISABLED_BUTTONS = "//*[@id=\"flightModuleList\"]//button[@data-test-id=\"select-button\" AND [contains(@class,\"disabled\")]]";
    private String XPATH_FOR_SELECT_DISABLED_BUTTONS_PER_BOX = "//*[@id=\"flightModuleList\"]/li[_NUMBER_]//button[contains(@class,'disabled')]";

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdown;

    @FindBy(id = "flightModuleList")
    private WebElement flightOptionsList;

    @FindBy(css = "")
    private WebElement flightDivision;
//*[@id="flight-module-2019-04-01t06:00:00-07:00-coach-las-lax-ua-324_2019-07-06t08:45:00-07:00-coach-lax-las-ua-1260_"]/div[1]/div[1]/div[2]/div/div[2]/button
    //*[@id="flight-module-2019-04-01t06:00:00-07:00-coach-las-lax-as-1469_2019-07-06t08:45:00-07:00-coach-lax-las-ua-1260_"]/div[1]/div[1]/div[2]/div/div[2]/button
//*[@id="flight-module-2019-03-19t09:00:00-07:00-coach-las-lax-nk-671_2019-05-17t06:05:00-07:00-coach-lax-las-nk-562_"]/div[1]/div[1]/div[2]/div/div[2]/button
    //*[@id="flight-module-2019-03-02t18:50:00-05:00-coach-bog-lim-vv-439-coach-lim-piu-vv-502_2019-06-01t12:20:00-05:00-coach-piu-lim-vv-503-coach-lim-bog-f1-329_"]/div[1]
//*[@id="flight-module-2019-03-02t18:50:00-05:00-coach-bog-lim-vv-439-coach-lim-piu-vv-506_2019-06-01t12:20:00-05:00-coach-piu-lim-vv-503-coach-lim-bog-f1-329_"]
    public FlightSearch(WebDriver asDriver) {
        super(asDriver);
        elementsExpected = new HashMap<>();
        elementsExpected.put("price","price");
        elementsExpected.put("duration","duration");
        elementsExpected.put("departure","departure");
        elementsExpected.put("arrival","arrival");
    }

    /**
     * Podría ser una lista de la cual se pueda eliminar lo ya encontrado, al final, si la lista no queda en ceros, fail.
     * Esta función es para verificar que las opciones esten en la lista.
     */
    public void findSortDropElements(){
        HashMap<String,String> remaingExpectedElements = new HashMap<>();
        remaingExpectedElements.putAll(elementsExpected);
        getWebWait().until(ExpectedConditions.elementToBeClickable(sortDropdown));
        //*[@id="sortDropdown"]/option[@value]
        for(WebElement child : sortDropdown.findElements(By.xpath("//*[@id=\"sortDropdown\"]/option"))){
            System.out.println(child.getAttribute("value"));
            for(String element : elementsExpected.values()){
                if(child.getAttribute("value").contains(element)) {
                    remaingExpectedElements.remove(element);
                }

            }
        }
        if(remaingExpectedElements.size() == 0){
            System.out.println("Elementos completos, aprovar assert");
        }
    }
    public void searchAllChildButtons(){
        //List<WebElement> childs = flightOptionsList.findElements(By.xpath(".//*"));
        //buttons countdown
        //*[@id]/div[1]/div[1]/div[2]/div/div[2]/button
        System.out.println("the childs number is: "+flightOptionsList.findElements(By.xpath(".//*/div[1]/div[1]/div[2]/div/div[2]/button")).size());
        getWebWait().until(ExpectedConditions.visibilityOf(flightOptionsList));
        /**
        for(WebElement child : flightOptionsList.findElements(By.xpath("//*[@id=\"flightModuleList\"]/li[@id]"))){
            System.out.println(child.getAttribute("id"));
            //System.out.println(child.getAttribute("xpath"));
        }**/
        //tiles countdown
        System.out.println("the childs number is: "+flightOptionsList.findElements(By.xpath(XPATH_FOR_FLIGHT_RESULTS)).size());

        if(flightOptionsList.findElements(By.xpath(XPATH_FOR_FLIGHT_RESULTS)).size() == flightOptionsList.findElements(By.xpath(".//*/div[1]/div[1]/div[2]/div/div[2]/button")).size()){
            System.out.println("Numeros coinciden, aprovar prueba");
        }
        else{
            System.out.println("No coinciden los numeros, rechazar prueba");
        }
    }

    public void flightDurationSearch(){
        getWebWait().until(ExpectedConditions.visibilityOf(flightOptionsList));
        //*[@id]/div[1]/div[1]/div[1]/div/div/div/div[2]/div[1]/span[1]
        /**
        for(WebElement child : flightOptionsList.findElements(By.xpath("//*[@id]/div[1]/div[1]/div[1]/div/div/div/div[2]/div[1]/span[1]"))){
            System.out.println(child.getAttribute("data-test-id"));
            //System.out.println(child.getAttribute("xpath"));
        }**/
        System.out.println("the flights number is: "+flightOptionsList.findElements(By.xpath("//*[@id]/div[1]/div[1]/div[1]/div/div/div/div[2]/div[1]/span[1]")).size());
        System.out.println("the flights number is: "+flightOptionsList.findElements(By.xpath(XPATH_FOR_FLIGHT_RESULTS)).size());

    }

    public void flightDetailCount(){
        getWebWait().until(ExpectedConditions.visibilityOf(flightOptionsList));
        //*[@id="flight-module-2019-01-25t18:00:00-08:00-coach-las-lax-nk-1489_2019-05-04t21:10:00-07:00-coach-lax-las-aa-1763_"]/div[1]/div[2]/span[1]/a/span[1]
        System.out.println("flight and baggage count is: " + flightOptionsList.findElements(By.xpath("//*/div[1]/div[2]/span[1]/a/span[1]")).size());
        System.out.println("flight and baggage count is: " + flightOptionsList.findElements(By.xpath(XPATH_FOR_FLIGHT_RESULTS)).size());
    }

    public void sortBy(String type, String dir){
//*[@id="sortDropdown"]/option[2]
        getWebWait().until(ExpectedConditions.visibilityOf(sortDropdown));
        sortDropdown.click();
        System.out.println("elementos en lista" + sortDropdown.findElements(By.xpath("//*[@id=\"sortDropdown\"]/option")).size());
        for(WebElement element : sortDropdown.findElements(By.xpath("//*[@id=\"sortDropdown\"]/option"))){
            System.out.println(element.getText());
            if(element.getText().contains(type))
                if(element.getText().contains(dir)){
                    element.click();
                }
        }
    }

    public void clickOnAListOption(int option){
       // /html/body/div[2]/div[12]/section/div/div[11]/ul/li[1]/div[1]/div[1]/div[2]/div/div[2]/button
       // /html/body/div[2]/div[12]/section/div/div[11]/ul/li[1]/div[2]/div/div/div/div[1]/button
        String buttonsXpath = XPATH_FOR_SELECT_CLICKABLE_BUTTONS.replace(STRING_TO_REPLACE, String.valueOf(option));
        System.out.println(buttonsXpath);
        getWebWait().until(ExpectedConditions.visibilityOf(flightOptionsList));
        getWebWait().until(ExpectedConditions.elementToBeClickable(sortDropdown));
        int buttonsInside = flightOptionsList.findElements(By.xpath(buttonsXpath)).size();
        System.out.println(buttonsInside);

        flightOptionsList.findElements(By.xpath(buttonsXpath)).get(0).click();
        if(buttonsInside > 1){
            getWebWait().until(ExpectedConditions.elementToBeClickable(flightOptionsList.findElements(By.xpath(buttonsXpath)).get(1)));
            flightOptionsList.findElements(By.xpath(buttonsXpath)).get(1).click();
        }
    }

    public boolean checkButtonDisabled(int option){
        getWebWait().until(ExpectedConditions.visibilityOf(flightOptionsList));
        return !flightOptionsList.findElements(By.xpath(XPATH_FOR_BUTTONS)).get(option).isEnabled();
        //getWebWait().until(ExpectedConditions.visibilityOf(flightOptionsList.findElements(By.xpath(XPATH_FOR_BUTTONS)).get(option)));
    }
}
