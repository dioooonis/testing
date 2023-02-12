import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Detyra1 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");

        WebDriver driver =  new ChromeDriver();
        String baseUrl="https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
        WebElement menu=driver.findElement(By.className("header-links").cssSelector("a[href='/register?returnUrl=%2F']"));
        menu.click();
        Thread.sleep(2000);
        String title=driver.getTitle();

        String expected="nopCommerce demo store. Register";
        if (expected.equalsIgnoreCase(title)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        WebElement male=driver.findElement(By.id("gender-male"));

        WebElement female=driver.findElement(By.id("gender-female"));

        male.click();
        Thread.sleep(1000);

        WebElement emri=driver.findElement(By.cssSelector("input[name='FirstName']"));
        WebElement mbiemri=driver.findElement(By.cssSelector("input[name='LastName']"));
        Thread.sleep(1000);
        emri.sendKeys("Dionis");
        Thread.sleep(1000);
        mbiemri.sendKeys("Cura");
        Thread.sleep(1000);
        Select date = new Select(driver.findElement(By.name("DateOfBirthDay")));

        date.selectByVisibleText("9");
        Thread.sleep(1000);

        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText("September");
        Thread.sleep(1000);

        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("2002");
        Thread.sleep(1000);
        WebElement email=driver.findElement(By.cssSelector("input[type='email']"));

        email.sendKeys("dionis@gmail.com");
        Thread.sleep(1000);
        WebElement company=driver.findElement(By.cssSelector("input[name='Company']"));

        company.sendKeys("Aqua");
        Thread.sleep(1000);
        WebElement checkbox = driver.findElement(By.cssSelector("input[id='Newsletter']"));
        checkbox.click();

        Thread.sleep(1000);
        WebElement password = driver.findElement(By.cssSelector("input[id='Password']"));

        password.sendKeys("dionis001");
        Thread.sleep(1000);
        WebElement confirmation = driver.findElement(By.cssSelector("input[id='ConfirmPassword']"));
        confirmation.sendKeys("dionis001");
        Thread.sleep(1000);

        driver.findElement(By.id("register-button")).submit();
        Thread.sleep(1000);

        WebElement continuee= driver.findElement(By.className("register-continue-button"));
        continuee.click();
        Thread.sleep(1000);
        WebElement loginbtn=driver.findElement(By.className("header-links").cssSelector("a[href='/login?returnUrl=%2F']"));
        loginbtn.click();
        Thread.sleep(1000);
        WebElement loginEm=driver.findElement(By.className("inputs").cssSelector("input[name='Email']"));
        loginEm.sendKeys("dionis@gmail.com");
        Thread.sleep(1000);
        WebElement loginPass=driver.findElement(By.cssSelector("input[name='Password']"));
        loginPass.sendKeys("dionis001");
        Thread.sleep(1000);

        driver.findElement(By.className("login-button")).submit();
        Thread.sleep(1000);
        WebElement lout=driver.findElement(By.className("header-links").cssSelector("a[href='/logout']"));
        lout.click();

        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }
}