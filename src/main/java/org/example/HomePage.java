package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class HomePage
{
    protected static WebDriver driver;

    // Method for Get Text line in output

    public String getTimeStamp()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
    public void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // Method for Get Text line in output
    public String getTextFormElement(By by)
    {
        return driver.findElement(by).getText();
    }
    // Method for click
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    @BeforeTest
    public void openBrowser()
    {
        // To do Auto-generated method sub
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // For keep fullscreen

        driver.get("https://demo.nopcommerce.com/");

    }


    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }

    @Test
    public void verifyUserShouldBeAbleToRegister(){
        clickOnElement(By.className("ico-register"));
        typeText(By.id("FirstName"),"Mahesh");// Enter First Name
        typeText(By.id("LastName"),"Sharma"); // Enter Last Name
        typeText(By.id("Email"),"maheshsharma"+getTimeStamp()+"@gmail.com");// Enter Email with unique id
        typeText(By.id("Password"),"Test&9678");  // Enter Password
        typeText(By.id("ConfirmPassword"),"Test&9678");  // Enter Confirm Password
        clickOnElement(By.name("register-button")); // Click on Register Button
        String regMsg = getTextFormElement(By.className("result"));   // Get Text line after successfully Registartion in output
        System.out.println(regMsg);

    }
    @Test
    public void verifyUserShouldBeAbleTOSeeProductOfDesktopOnComputersPage()
    {

        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));  // Click on Computers on Homepage
        clickOnElement(By.xpath("//h2/a[@href=\"/desktops\"]")); // Click on Desktops on Computers page
        String productComputer1 = getTextFormElement(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));
        System.out.println(productComputer1);
        // Get as a text in output products of desktop(computers)
        String productComputer2 = getTextFormElement(By.xpath("//h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
        System.out.println(productComputer2);
        // Get as a text in output products of desktop(computers)
        String productComputer3 = getTextFormElement(By.xpath("//h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
        System.out.println(productComputer3);
    }

    @Test
    public void verifyUserShouldBeAbleTogoNopCommerceNewReleaseOfNewsAndSuccessfullyAbleToAddComment()
    {

        clickOnElement(By.xpath("//div[@class=\"news-head\"]/a[@href=\"/nopcommerce-new-release\"]"));   // Click on Details of nopCommerce new release
        typeText(By.id("AddNewComment_CommentTitle"),"Product");// Enter Title on nopCommerce new release page
        typeText(By.id("AddNewComment_CommentText"),"All products are good.");  // Enter comment on nopCommerce new release page
        clickOnElement(By.name("add-comment"));// Click on New Comment on nopCommerce new release page
        String newsComment = getTextFormElement(By.className("result"));    // Get Text line after successfully comments in output
        System.out.println(newsComment);

    }
    @Test
    public void verifyUserShouldBeAbleToSeeCategoriesOfHomePage()
    {

        System.out.println("Home-Page Categories");
        String homeCate1 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]"));
        System.out.println(homeCate1);
        // Get name of Home-page Categories in output
        String homeCate2 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]"));
        System.out.println(homeCate2);
        // Get name of Home-page Categories in output
        String homeCate3 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]"));
        System.out.println(homeCate3);
        String homeCate4 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]"));
        System.out.println(homeCate4);
        String homeCate5 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]"));
        System.out.println(homeCate5);
        // Get name of Home-page Categories in output
        String homeCate6 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]"));
        System.out.println(homeCate6);
        // Get name of Home-page Categories in output
        String homeCate7 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[7]"));
        System.out.println(homeCate7);
    }

    @Test
    public void verifyUnregistredUserShouldNotAbleToReferAProductToAFriend()
    {
        // Click on Apple MacBook Pro 13-inch on Homepage
        clickOnElement(By.xpath("//h2/a[@href=\"/apple-macbook-pro-13-inch\"]"));
        // Click on Email a friend on Apple MacBook Pro 13-inch page
        clickOnElement(By.className("email-a-friend"));
        // Enter friend's email on emailafriend page
        typeText(By.className("friend-email"),"tithi"+getTimeStamp()+"@gmail.com");
        // Enter your email on emailafriend page
        typeText(By.className("your-email"),"janvipatel@gmail.com");
        typeText(By.id("PersonalMessage"),"hello..."); // Enter prsonal message on emailafriend page
        clickOnElement(By.name("send-email"));

        // Get Text line after click SEND EMAIL in output
        String emailMsg = getTextFormElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
        System.out.println(emailMsg);

    }

}
