import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FramesPageTest {

    private WebDriver driver;
    private FramesPage framesPage;
    public static String site = "the-internet.herokuapp.com";
    public static String name = "Bogdan Fostenko";

    @Before    // annotation for starting activities before each testing method
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\MorphisecTaskProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //  Chrome driver initialization
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    //  waiting for appearing of element which wasn't found
        driver.manage().window().maximize();    //  full window size
        driver.get("https://"+site);
        framesPage = new FramesPage(driver);
    }

    @Test    // annotation for main activities for each testing method
    public void method1() {
        framesPage.clickFramesPage();
        framesPage.clickIFramePage();
        framesPage.writeName(name);
        /*String contentField = driver.findElement(b3FramesPage.contentField).getText();
        Assert.assertEquals(contentField,name);*/
    }

    @After    // annotation for closing activities after each testing method
    public void tearDown() {
        //driver.quit();  //  quit Chrome driver
    }

}