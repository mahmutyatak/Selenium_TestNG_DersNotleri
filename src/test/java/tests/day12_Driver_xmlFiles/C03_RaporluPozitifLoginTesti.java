package tests.day12_Driver_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethodsE;
import utulities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void pozitifLoginTesti(){
        extentTest=extentReports.createTest("pozitifLoginTesti","Gecerli bilgilerle giris yapilabilmeli");
        // qdemy anasayfaya gidin
        Driver.getdriever().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("QualityDemy anasayfaya gidildi.");
        // login linkine tıklayin
        QdPage qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();
        extentTest.info("ilk login linkine tiklandi");
        // gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("gecerli email yazildi");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        extentTest.info("gecerli password yazildi");
        qdPage.cookie.click();
        ReusableMethodsE.bekle(2);
        qdPage.loginButonu.click();
        extentTest.info("gecerli email yazildi");
        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("Basarili sekilde giris yapildigi test edildi.");

    }
}
