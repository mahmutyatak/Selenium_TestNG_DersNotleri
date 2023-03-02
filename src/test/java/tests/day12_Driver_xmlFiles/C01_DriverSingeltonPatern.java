package tests.day12_Driver_xmlFiles;

import org.testng.annotations.Test;

public class C01_DriverSingeltonPatern {
    @Test
    public void test01(){
        /*
        POM webDriver olarak driver classındki getdriver methodunun
        kullanılması üzerine kurgulanmıştır.
        Driver.getDriver();

        Driver classının obje olusturularak kullanılmasını engellemek icin POM
        u tasarlayanlar bir onlem koymak istemisler.

        Java da bir class dan obje olusturulmasini engellemek isterseniz
        Sıngelton Patern kullanabilirsiniz.

        Sıngelton Patern : Bir class dan obje olusturulmasını engellemek/sinirlamak icin
        kullanılan bir yöntemdir. Temel fikir obje olusturmak icin kullanılan default
        constructor yerine gorunur parametresiz bir constructor olusturup
        bu constructor ın acsess modifier ını private kullanılmasını engellemektir.
         */

        //Driver objeDriver=new Driver();
    }
}
