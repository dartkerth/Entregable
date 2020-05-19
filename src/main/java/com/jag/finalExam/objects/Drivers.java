package com.jag.finalExam.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {

    private WebDriver myDriver;

    /*
    El contructor siempre debe generar una instalacia del driver
    necesito una mejor idea para enviar los paths de los drivers, como jalar del xml o algo así
     */
    public Drivers(String inBrowser){
        switch (inBrowser){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--incognito");
                myDriver=new ChromeDriver(options);
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.24.0-win64\\geckodriver.exe");
                myDriver = new FirefoxDriver();
                break;
            case "Explorer":
                System.setProperty("webdriver.ie.driver","C:\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
                myDriver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("¿Qué carajos pidio?");
                break;
        }
    }

    public WebDriver getMyDriver() {
        return myDriver;
    }
}

