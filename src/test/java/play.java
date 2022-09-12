import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.TestRunner.PriorityWeight.priority;

public class play {
    @BeforeClass
    public static  void beforeClass() throws Exception {

    }
    @AfterClass
    public static void afterClass(){



    }
    @BeforeGroups()
    public static void beforGroups(){


    }
    @AfterGroups()
    public static void AfterGroups(){

    }
    @Test()
    public void play1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/dynamicid");
        WebElement button =  driver.findElement(By.cssSelector(".btn.btn-primary"));
        button.click();

        String buttonText  = button.getText();
        String realText = "Button with Dynamic ID";

        Assert.assertEquals(buttonText, realText);
        Thread.sleep(5000);

        driver.quit();




    }
    @Test()
    public void play2() throws InterruptedException {
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://uitestingplayground.com/classattr");
            WebElement button = driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]"));
            button.click();
            Thread.sleep(2000);
            driver.switchTo().alert().dismiss();
            // String naser = button.getText();
            //   String naser2= "Button";
            // Assert.assertEquals(naser,naser2);
            Thread.sleep(2000);
            driver.quit();


        }catch (Exception e){
            System.out.println("err test");
        }
    }
    @Test()
    public void play3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/hiddenlayers");
        try {


            driver.findElement(By.id("greenButton")).click();


            Thread.sleep(2000);

            System.out.println("לחיצה ראשונה  ");

        }catch (Exception e){  System.err.println("לחיצה נכשלה   ");
        }
        try {
            driver.findElement(By.id("greenButton")).click();
            System.out.println("לחיצה שניה ");
        }catch (Exception e){
            System.err.println("לחיצה נכשילה ");
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
