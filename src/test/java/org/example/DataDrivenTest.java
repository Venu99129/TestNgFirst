package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
    @DataProvider(name = "negative")
    public Object[] negitiveData(){
        return new Object[]{"-1","-2","10/2"};
    }
    @DataProvider(name = "positive")
    public Object[] positiveData(){
        return new Object[]{"1","02","100.2"};
    }


    @Test(dataProvider = "positive")
    public void positiveTester(String str){
        System.out.println("positive :"+str);
    }

    @Test(dataProvider = "negative")
    public void negativeTester(String str){
        System.out.println("negative :"+str);
    }
}
