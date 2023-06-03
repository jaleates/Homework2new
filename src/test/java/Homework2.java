import BrowserUtils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework2 {
    @Test
    public void Task1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        BrowserUtils.switchByTitle(driver,"Web Orders");
        Assert.assertEquals(BrowserUtils.getTitlewithJS(driver),"Web Orders");
        System.out.println(  BrowserUtils.getTitlewithJS(driver));
        WebElement header=driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of All Orders");

    }


    @Test
    public void Task2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        WebElement allProductButton=driver.findElement(By.linkText("View all products"));
        allProductButton.click();
        WebElement header=driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");
        BrowserUtils.switchByTitle(driver,"Products");
        driver.getCurrentUrl();

    }
@Test
    public void Task3(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origin=*");
    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
    WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
    username.sendKeys("Tester");
    WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
    password.sendKeys("test");
    WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
    login.click();

    List<WebElement> allLinks=driver.findElements(By.xpath("//li//a"));
BrowserUtils.switchById(driver);
    for(int i=0;i<allLinks.size();i++){
        allLinks.get(i).getAttribute("href");

    }
    List<WebElement> allNames=driver.findElements(By.xpath(" //li//a"));
    for(WebElement element:allNames){
        element.getText().trim();
        System.out.println(element.getText().trim());
    }

}

@Test
    public void task4(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origin=*");
    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
    WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
    username.sendKeys("Tester");
    WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
    password.sendKeys("test");
    WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
    login.click();
WebElement orderButton= driver.findElement(By.linkText("Order"));
orderButton.click();
WebElement Product=driver.findElement(By.xpath("//select[@onchange='productsChanged()']"));
BrowserUtils.selectBy(Product,"ScreenSaver","value");
WebElement quantity= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
quantity.clear();
quantity.sendKeys("5");
WebElement CustomerName=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
CustomerName.sendKeys("CodeFish IT School");
WebElement Street= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
Street.sendKeys("2200 E devon");
WebElement City=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
City.sendKeys("Des Plaines");
WebElement State=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
State.sendKeys("Illinois");
WebElement ZipCode= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
ZipCode.sendKeys("60018");
WebElement MasterCArd= driver.findElement(By.xpath("//input[@value='MasterCard']"));
MasterCArd.click();
WebElement carNumber=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
carNumber.sendKeys("444993876233");
WebElement expireDate=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
expireDate.sendKeys("03/24");
WebElement proccessButton=driver.findElement(By.linkText("Process"));
proccessButton.click();

WebElement message= driver.findElement(By.xpath("//div//strong"));
Assert.assertEquals(BrowserUtils.getText(message),"New order has been successfully added.");
WebElement viewAllOrder= driver.findElement(By.linkText("View all orders"));
viewAllOrder.click();
WebElement codevalidation=driver.findElement(By.xpath("//td[2]"));
Assert.assertTrue(codevalidation.getText().contains("CodeFish IT School"));


}

}