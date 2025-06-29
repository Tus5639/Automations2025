package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Automation_Excercise_HomePage {

    @FindBy( xpath = "//a[@href='/login']")
    private WebElement login;

    @FindBy(xpath ="//a[@href='/products']" )
    private WebElement products;

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement view_cart;

    @FindBy(xpath = "//a[text()=' Home']")
    private WebElement home_page;
}
