import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;
    public static String site = "the-internet.herokuapp.com";
    public static String name = "Bogdan Fostenko";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\MorphisecTaskProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //  Chrome driver initialization
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    //  waiting for appearing of element which wasn't found
        driver.manage().window().maximize();    //  full window size
        driver.get("https://"+site);

        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);   //  Class initialization
        FramesPage framesPage = new FramesPage(driver);
        DynamicPage dynamicPage = new DynamicPage(driver);

        checkboxesPage.clickCheckboxesPage();
        checkboxesPage.resolveCheckboxes();
        checkboxesPage.checkStatuses();
        framesPage.clickFramesPage();
        framesPage.clickIFramePage();
        framesPage.writeName(name);
        dynamicPage.clickDynamicPage();
        dynamicPage.clickExample2Page();
        dynamicPage.clickStartButton();
        dynamicPage.checkElementExists();

        driver.quit();  //  quit Chrome driver
    }

}
