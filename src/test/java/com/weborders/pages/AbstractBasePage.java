package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
it meant to be extended
 */
public class AbstractBasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

public AbstractBasePage(){
        PageFactory.initElements(driver,this); //this is for @FindBy annotation
    }

    /*or we can do like this just 1 line
   public AbstractBasePage(){
        PageFactory.initElements(Driver.getDriver(),this); //this is for @FindBy annotation
    }*/



}
