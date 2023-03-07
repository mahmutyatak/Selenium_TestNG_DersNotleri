package tests.day13_crossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.Driver;
import utulities.DriverCross;
import utulities.TestBaseCross;

public class C02_amazorTestiCross extends TestBaseCross {
    @Test
    public void amazonTesti(){
        driver.get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik2="Nutella";
        String actualSonucYazisi=aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik2));

    }

}
