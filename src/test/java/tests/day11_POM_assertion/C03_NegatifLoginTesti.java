package tests.day11_POM_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethodsE;

public class C03_NegatifLoginTesti {
    //qd anasayfayagidin
    //3 test metodu olusturun asagidaki durumlarda giris yapılamadigini test edin

    //1-gecerli username gecersiz password
    //2- gecersiz username gecerli password
    //3- gecersiz username gecersiz password
    QdPage qdPage=new QdPage();
    @Test(groups = "smoke")
    public void nagatifLogin1(){
        qdPage=new QdPage();
        Driver.getdriever().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.cookie.click();
        ReusableMethodsE.bekle(2);
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.loginButonu.isEnabled());
        Driver.closeDriver();
    }
    @Test(groups = "smoke")
    public void nagatifLogin2(){
        qdPage=new QdPage();
        Driver.getdriever().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.cookie.click();
        ReusableMethodsE.bekle(2);
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.loginButonu.isEnabled());
        Driver.closeDriver();
    }
    @Test
    public void nagatifLogin3(){
        qdPage=new QdPage();
        Driver.getdriever().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.cookie.click();
        ReusableMethodsE.bekle(2);
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.loginButonu.isEnabled());
        Driver.closeDriver();
    }

}
