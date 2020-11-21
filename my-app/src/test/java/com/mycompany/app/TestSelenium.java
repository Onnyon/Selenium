import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TestSelenium {
    public static void main(String[] args){
//        loginLogoutTest();
        homePage();
    }
    public static void loginLogoutTest() {
        FirefoxDriver driver=new FirefoxDriver();
        driver.get("https://demo.opencart.com/");
        WebElement myAccountButton=driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountButton.click();

        WebElement loginButton=driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("andressa@email.com");
        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("andressa");

        WebElement loginButton2=driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton2.click();

        WebElement myAccountButton2=driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountButton2.click();
        WebElement logout=driver.findElement(By.linkText("Logout"));
        logout.click();
    }
    public static void homePage() {
        FirefoxDriver driver=new FirefoxDriver();
        driver.get("https://demo.opencart.com/");
        WebElement myAccountButton=driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountButton.click();

        WebElement loginButton=driver.findElement(By.linkText("Login"));
        Assert.assertTrue(loginButton.isDisplayed());

        WebElement tabletsButton=driver.findElement(By.linkText("Tablets"));
        tabletsButton.click();

        WebElement samsung=driver.findElement(By.xpath("//img[@title='Samsung Galaxy Tab 10.1']"));
        Assert.assertTrue(samsung.isDisplayed());

        driver.get("https://demo.opencart.com/");

        List<WebElement> featuredImages= (List<WebElement>) driver.findElements(By.xpath(
                "//div[@class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12']//img[@class='img-responsive']"
        ));

        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(featuredImages.get(i).isDisplayed());
        }

        List<WebElement> featuredAddToCartButtons= (List<WebElement>) driver.findElements(By.xpath(
                "//div[@class='button-group']//button[@type='button'][1]"
        ));

        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(featuredAddToCartButtons.get(i).isDisplayed());
        }

        List<WebElement> headerDropdown= (List<WebElement>) driver.findElements(By.xpath(
                "//li[@class='dropdown']"
        ));

        for (int i = 1; i < 4; i++) {
            Assert.assertTrue(headerDropdown.get(i).isDisplayed());
        }

    }
}