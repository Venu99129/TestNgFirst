package org.example;

import org.testng.annotations.Test;


public class MainTest extends BasicTest{

    @Test(groups = "smoke")
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test
    public void test3(){
        System.out.println("test3");
    }

}