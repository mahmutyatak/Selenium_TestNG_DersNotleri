package tests.day13_crossBrowserTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethodsE;

public class C04_DataProviderNegatifLoginTest {



    /*
        Werilen 5 farklı username ve password u kullanarak
        qdemy uygulamsına girilemedigiini test edin
         */
    @Test(dataProvider = "kullanicilar")
    public void nagatifLogin1(String username,String password) {
        QdPage qdPage = new QdPage();

        qdPage = new QdPage();
        Driver.getdriever().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(username);
        qdPage.passwordKutusu.sendKeys(password);
        ReusableMethodsE.bekle(2);
        qdPage.cookie.click();
        ReusableMethodsE.bekle(2);
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.loginButonu.isEnabled());
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] kullanicilar() {
        String [][] kullaniciList={{"zafer","12345"},{"mehmet","34567"},{"sevilay","67890"},{"enver","14568"},{"ali","25896"}};

        return kullaniciList;
    }
}
