package com.weborders.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtilities {

    /**
     * Pause test for some time
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param elements represents collection of WebElements
     * @return collection of strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            textValues.add(element.getText());
        }
        return textValues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * @param name screenshot name
     * @return path to the screenshot

    public static String getScreenshot(String name) {
    //adding date and time to screenshot name, to amke screenshot unique
    // name = LocalDateTime.now() + "_" + name;---> bu calismadi
    name = new Date().toString() + "_" + name;
    // location of our screenshot
    //where we gonna store a screenshot
    String path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
    System.out.println("Screenshot is here: " + path);
    //since our reference type is a WebDriver
    //we cannot see methods from TakesScreenshot interface
    //that's why do casting
    TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
    //take screenshot of web browser, and save it as a file
    File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
    //where screenshot will be saved
    File destination = new File(path);
    try {
    //copy file to the previously specified location
    FileUtils.copyFile(source, destination);
    } catch (IOException e) {
    e.printStackTrace();
    }
    return path;
    }*/

    /**
     * pbg is image, path will be with that extension
     * will take screenshot and return the location of that screenshot it is important for report we will attach to the report
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenshot(String name){
        //adding date and time to screenshot name , to make screenshot unique
        //name = LocalDateTime.now() + "_" + name;
        name = (new Date().toString() + "_" + name).replace(":", "-");
        //where we gonna store a screenshot; location of our screenshot => System.getProperty("user.dir")+"/test-output/screensghots/"+name+".png";
        //user.dir same for everyone, it is java system properties, returns execution location
        String path = System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
        System.out.println("Screenshot is here: "+path);
        //since our reference type is a WebDriver
        //we can not see methods from TakeScreenshot interface
        //that's why we do casting
        TakesScreenshot takesScreenshot = (TakesScreenshot)Driver.getDriver();
        //takes screenshot and return that screenshot as file object
        //take screenshot of web browser, and save it as a file
        //we will move this file where we want with destination
        //this one line does everything => getScreenshotAs(OutputType.FILE);
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //where screenshot will be saved
        File destination = new File(path);
        try {
            //copy file to the previously specified location
            //FileUtils class comes from java, to work with the files, general file manipulation properties
            //It stores methods to work with file
            //takes 2 argument,where is your file and where to save it
            FileUtils.copyFile(source,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    //call method save file as a png
    //takeScreenshot is interface






}