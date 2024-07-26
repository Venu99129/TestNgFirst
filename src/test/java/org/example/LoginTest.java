package org.example;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest{

    @Test(groups = "smoke", dependsOnMethods = "test5")
    public void test4(){
        System.out.println("test4");
    }

//    @Parameters({"browser","environment"})
    @Test(groups = "smoke" , dependsOnMethods = "test6")
    public void test5(){
        //String browser , String environment
//        System.out.println(browser);
//        System.out.println(environment);
        System.out.println("test5");
    }
    @Test
    public void test6(){
        System.out.println("test6");
    }
}
