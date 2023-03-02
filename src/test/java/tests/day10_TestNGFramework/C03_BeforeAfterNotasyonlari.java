package tests.day10_TestNGFramework;

import org.testng.annotations.*;

public class C03_BeforeAfterNotasyonlari {
    /*
    Smoke Test
    Regression Test
    EndToEnd(E2E)
    Test Suite: Birden fazla testin bir amac icin bi araya getirilmesidir.
    Test:Bir amac icin bir araya getirilmis test methodlari classlari veya
    package lari içerir.

    Test Hiyerarsisi:
    -Suite
    -Test
    -Groups.package,classes,methods


     */
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suit");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }

    @Test
    public void test01(){
        System.out.println("test1");

    }
    @Test
    public void test02(){
        System.out.println("test2");
    }
    @Test
    public void test03(){
        System.out.println("test3");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
    @AfterClass (groups = "smoke")
    public void afterClass(){
        System.out.println("after class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }
}
