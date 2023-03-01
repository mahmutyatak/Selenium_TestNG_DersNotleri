package tests.day11_POM_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssert_SoftAssert {

    @Test
    public void hardAssertionTesti(){
        //hatalari ilk verdigi yerde duruyor.
        //4 hatayi duzelmek icin 4 kere calistirmam gerekli
        Assert.assertTrue(15>8);
        Assert.assertFalse(8==9);
        Assert.assertEquals(5,5);
        Assert.assertNotEquals(6,7);
    }
    @Test
    public void softAssertionTesti(){
        /*
        JUNİT DEKİ assert class i tesng de de vardır ancak bir test metodunda birden fazla
        failed olan assertion varsa ilk failed olan assertion calismayi durdurup exception fırlattigindan
        tum hatayi bir dafa da görüp hepsini duzeltme sansımız olmaz

            Testng bunun icin bir alternatif sunmus
            Bu alternatfide assert classındaki static methodlari kulanmak  yerine
            SoftAssert classından bir obje olusturup
             o obje uzerinden istedigimiz testleri yapıyorz.
            SoftAssert objesi ile yapılan assertionlar failed olsa da testimiz calismaya devam eder
            Ancak testlerin sonucuu görmek istedigimizde
            SortAssert.assertAll ile tum yaptıgı testleri raporlamasini söyleyebiliriz.

            HardAssert de biönceki ssertin ismi olmus.yani ilk hata da duran assert
            AssertAll methodunun calistigi satirda exception olabilir.
         */
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(5>8,"trueTesti failed oldu");
        softAssert.assertFalse(8==8,"falseTesti failed oldu");
        softAssert.assertEquals(5,6,"equalsTesti failed oldu");
        softAssert.assertNotEquals(6,6,"notequalsTesti failed oldu");
        //hepsi failed olmasına ragmen test passed gösterdi.testlerimizin sonuclarını AssertAll
        //ile goruyoruz.


        softAssert.assertAll();
    }
}
