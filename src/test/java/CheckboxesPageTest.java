import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CheckboxesPageTest {

    private WebDriver driver;
    private CheckboxesPage checkboxesPage;
    public static String site = "the-internet.herokuapp.com";

    @Before    // annotation for starting activities before each testing method
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\MorphisecTaskProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //  Chrome driver initialization
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    //  waiting for appearing of element which wasn't found
        driver.manage().window().maximize();    //  full window size
        driver.get("https://"+site);
        checkboxesPage = new CheckboxesPage(driver);
    }

    @Test    // annotation for main activities for each testing method
    public void method1() {
        checkboxesPage.clickCheckboxesPage();
        checkboxesPage.resolveCheckboxes();
        Assert.assertTrue(checkboxesPage.checkStatuses());
    }

    @After    // annotation for closing activities after each testing method
    public void tearDown() {
        //driver.quit();  //  quit Chrome driver
    }

}