package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test01 {
    @Test
    public void test01() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");

        WebDriver driver =  new ChromeDriver();
        String baseUrl="https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
        WebElement loginmenu=driver.findElement(By.className("header-links").cssSelector("a[href='/register?returnUrl=%2F']"));
        loginmenu.click();

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

        WebElement firstname=driver.findElement(By.cssSelector("input[name='FirstName']"));
        WebElement lastname=driver.findElement(By.cssSelector("input[name='LastName']"));

        firstname.sendKeys("emer");

        lastname.sendKeys("mbiemer");

        Select date = new Select(driver.findElement(By.name("DateOfBirthDay")));
        date.selectByVisibleText("1");
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText("January");
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("2023");

        WebElement email=driver.findElement(By.cssSelector("input[type='email']"));

        email.sendKeys("abc@email.com");

        WebElement company=driver.findElement(By.cssSelector("input[name='Company']"));

        company.sendKeys("company");

        WebElement checkbox = driver.findElement(By.cssSelector("input[id='Newsletter']"));

        checkbox.click();

        WebElement password = driver.findElement(By.cssSelector("input[id='Password']"));

        password.sendKeys("test11");
        WebElement confPass = driver.findElement(By.cssSelector("input[id='ConfirmPassword']"));

        confPass.sendKeys("test11");

        //input[id='register-button']
        driver.findElement(By.id("register-button")).submit();
    }}


