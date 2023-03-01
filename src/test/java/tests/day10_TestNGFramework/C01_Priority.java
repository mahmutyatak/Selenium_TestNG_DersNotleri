package tests.day10_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.Driver;

public class C01_Priority {
    /*
    TestNG test methodlarini calistiriken standart olarak harf siralamasina bakar.
    test methodlarini isminin ilk harfine göre.
    Ancak siralamayi bizim kontrol etmemeize olanak tanir
    istedigimiz test metoduna istedgimiz onceligi priority ile tanımlayabiliriz.
    Selenium test methodlarini priority si kucukten buyuge olacak sekilde calistirir.
    priority degeri aynı olam test metodlari harf sirasina gore calisir.

    hic bir pirority atamazsak default deger 0 olan atanır.hepsi 0 olursa harf siralamasi olur
    0 dan buyuk veya kucuk degerler alan priorityler ona gore siralanir.
     */

    @Test(priority = 25)
    public void amazonTesti(){
        //amazon anasayfaya gidip, amazona gittigimizi test edelim
        Driver.getdriever().get("https://www.amazon.com");
        //url amazon iceriyormu test edelim

        String expectedIcerik="amazon";
        String actualUrl=Driver.getdriever().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }
    @Test(priority = 19)
    public void wiseTesti(){
        //wisequarter anasayfaya gidip, wisequarter gittigimizi test edelim
        Driver.getdriever().get("https://www.wisequarter.com");
        //url amazon iceriyormu test edelim

        String expectedIcerik="wisequarter";
        String actualUrl=Driver.getdriever().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }
    @Test(priority = 15)
    public void youtubeTesti(){
        //youtube anasayfaya gidip, youtube gittigimizi test edelim
        Driver.getdriever().get("https://www.youtube.com");
        //url amazon iceriyormu test edelim

        String expectedIcerik="youtube";
        String actualUrl=Driver.getdriever().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }
}
