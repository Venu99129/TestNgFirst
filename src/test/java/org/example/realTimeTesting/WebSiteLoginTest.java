package org.example.realTimeTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class WebSiteLoginTest extends LoginDataProvider {

    @Test(dataProvider ="positiveCredentials")
    public void validLogin(LoginData data){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("user-name")).sendKeys(data.userName());
        driver.findElement(By.id("password")).sendKeys(data.password());
        driver.findElement(By.id("login-button")).click();

        String checkText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        assertEquals("Products", checkText);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        
        assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");

    }
    @Test(dataProvider ="negitiveCredentals")
    public void inValidLogin(LoginData data) {
    	 driver.get("https://www.saucedemo.com/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
         
         driver.findElement(By.id("user-name")).sendKeys(data.userName());
         driver.findElement(By.id("password")).sendKeys(data.password());
         driver.findElement(By.id("login-button")).click();
         
         String checkTest = driver.findElement(By.xpath("//h3[@data-test]")).getText();

        String failTest1 = "Epic sadface: Username and password do not match any user in this service";
        String failTest2 = "Epic sadface: Sorry, this user has been locked out.";
        String failTest3 = "Epic sadface: Username is required";
        String failTest4 = "Epic sadface: Password is required";

        assertTrue((checkTest.contains(failTest1)|| checkTest.contains(failTest3) || checkTest.contains(failTest4) || checkTest.contains(failTest2)));


    }
    
}
