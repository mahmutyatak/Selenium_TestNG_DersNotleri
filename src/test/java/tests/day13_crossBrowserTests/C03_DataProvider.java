package tests.day13_crossBrowserTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;

public class C03_DataProvider {



    /*
        verilen 4 farkli web sitesine gidin o sayfaya gidildigini test edin sayfayi kaptin

        amazonurl
        wiseurl
        qdurl
        youtubeurl
         */
    @Test(dataProvider = "urlListesi")
    public void urlTest(String gidilecekSite){
        Driver.getdriever().get(ConfigReader.getProperty(gidilecekSite));
        ReusableMethods.bekle(2);
        String actualUrl=Driver.getdriever().getCurrentUrl();
        Assert.assertEquals(actualUrl,ConfigReader.getProperty(gidilecekSite)+"/");
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] urlListesi() {
        String [][] siteListesi={{"amazonUrl"},{"wiseUrl"},{"qdUrl"},{"youtubeUrl"}};

        return siteListesi;
    }
}
