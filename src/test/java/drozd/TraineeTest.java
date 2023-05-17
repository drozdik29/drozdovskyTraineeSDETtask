package drozd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

//click the green triangle button to run tests
public class TraineeTest {
    static WebDriver driver = null;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GameOn\\IdeaProjects\\drozdovskyTraineeSDETtask\\src\\main\\resources\\chromedriver1.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testNavigate() {
        driver.navigate().to(" https://www.imdb.com/");
        assertThat(driver.getTitle()).isEqualTo("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows");
    }

    @Test(priority = 2)
    public void testMaximizeWindow() {
        driver.manage().window().maximize();
    }

    @Test(priority = 3)
    public void testSearch() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"suggestion-search\"]")).sendKeys("Back to the future");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"iconContext-magnify\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]/ul/li[1]/div[2]/div/a")).click();
    }

    @Test(priority = 4)
    public void testDescription() {
        assertThat(driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/section/p/span[3]")).
                getText()).
                isEqualTo("Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.");
        System.out.println((driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/section/p/span[3]")).getText()));
    }
}
