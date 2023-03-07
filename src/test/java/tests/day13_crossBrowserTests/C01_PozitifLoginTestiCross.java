package tests.day13_crossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utulities.*;

public class C01_PozitifLoginTestiCross extends TestBaseCross {

    @Test
    public void pozitifLoginTesti(){
        // qdemy anasayfaya gidin

        driver.get(ConfigReader.getProperty("qdUrl"));
        // login linkine tıklayin
        WebElement ilkLoginLinki=driver.findElement(By.linkText("Log in"));
        ilkLoginLinki.click();
        // gecerli kullanici adi ve password ile giris yapin
        WebElement emailKutusu=driver.findElement(By.id("login-email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        WebElement passwordKutusu=driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        driver.findElement(By.xpath("//a[text()='Accept']")).click();
        ReusableMethodsE.bekle(2);

        driver.findElement(By.xpath("//button[text()='Login']")).click();
        // basarili bir sekilde giris yapildigini test edin
        WebElement basariliGrisElementi=driver.findElement(By.xpath("//a[text()='Instructor']"));
        Assert.assertTrue(basariliGrisElementi.isDisplayed());

    }
}
