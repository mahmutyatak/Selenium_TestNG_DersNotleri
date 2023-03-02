package tests.day10_TestNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utulities.Driver;
import utulities.ReusableMethodsE;

public class C04_facebookTest {


    @Test(groups = "smoke")
    public void facebootesti(){
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getdriever().get("https://www.facebook.com/");
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        FacebookPage facebookPage=new FacebookPage();
        Faker faker=new Faker();
                facebookPage.email.sendKeys(("asdf"+faker.internet().emailAddress()));
                facebookPage.password.sendKeys(faker.internet().password());
                facebookPage.login.click();
        //4- Basarili giris yapilamadigini test edin
        ReusableMethodsE.bekle(3);
        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());
        ReusableMethodsE.bekle(3);
        Driver.closeDriver();

    }
}
