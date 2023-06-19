package Class02;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions extends CommonMethods {

        //Go to HRMS
        //Enter username
        //Enter wrong password
        //Click on login
        //Verify that the error message Invalid credentials is displayed
        //Also confirm that the error message is Displayed

        //I will put in pre-conditions for my test case in the Before Method


    @BeforeMethod(alwaysRun = true)
    public void OpenBrowserAndNavigate(){
        openBrowserAndNavigateToURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login","chrome");
    }

        //Post conditions
    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        //driver.quit();
    }

        //Test  case 1:
    @Test(groups = "smoke")
    public void verifyTheErrorMessage(){
        //Send username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        //Send password
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("abracadabra");

        //Click login
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
        //Get the error message
        WebElement errorMsg = driver.findElement(By.id("spanMessage"));

        String actualErrorMessage = errorMsg.getText();
        String expectedErrorMessage="Invalid credential";

        //Comparing two strings, which assertion to use
        Assert.assertEquals( actualErrorMessage,expectedErrorMessage);
        System.out.println("check that assert number 2 is runing or not");
        //Check if it is displayed
        boolean errorMsgIsDisplayed = errorMsg.isDisplayed();
        Assert.assertTrue(errorMsgIsDisplayed);
    }
}
