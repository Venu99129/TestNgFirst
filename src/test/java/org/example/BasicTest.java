package org.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BasicTest {
    @BeforeTest(alwaysRun = true)
    public  void setup(){
        System.out.println("Before");
    }

    @AfterTest(alwaysRun = true)
    public void clean(){
        System.out.println("after");
    }
}
