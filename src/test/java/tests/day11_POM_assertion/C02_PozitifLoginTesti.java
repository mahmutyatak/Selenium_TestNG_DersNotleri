package tests.day11_POM_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;

public class C02_PozitifLoginTesti {

    @Test
    public void pozitifLoginTesti(){
        // qdemy anasayfaya gidin
        Driver.getdriever().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tıklayin
        QdPage qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();
        // gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.cookie.click();
        ReusableMethods.bekle(2);
        qdPage.loginButonu.click();
        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        Driver.closeDriver();

    }
}
