package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class WebappsecurityPage {


    public WebappsecurityPage(){
        PageFactory.initElements(Driver.getdriever(),this);
    }
    @FindBy(className = "icon-signin")
    public WebElement ilksingButonu;
    @FindBy(id = "user_login")
    public WebElement username;
    @FindBy(id = "user_password")
    public WebElement password;
    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement girissignButton;
    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBanking;
    @FindBy(id = "pay_bills_link")
    public WebElement payyBills;
    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement pucrhaseButton;
    @FindBy(id = "pc_currency")
    public WebElement dropdown;
    @FindBy(id = "sp_sell_rate")
    public WebElement euroYazisi;
}
