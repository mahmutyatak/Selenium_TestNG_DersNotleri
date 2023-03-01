package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class FacebookPage {


    public FacebookPage(){
        PageFactory.initElements(Driver.getdriever(),this);
    }
    @FindBy(id="email")
    public WebElement email;
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement login;
    @FindBy(xpath = "//div[@class='_9ay5']")
    public WebElement girisYapilamadiYaziElementi;
}
