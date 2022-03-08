package driver.driver;

import com.thoughtworks.gauge.Step;
import driver.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepImplementation_DemoTest {

    private final WebDriver driver;

    public StepImplementation_DemoTest() {
        this.driver = DriverFactory.getDriver();
    }

  @Step("Open the demo site")
  public void gotoSite() throws InterruptedException {

        System.out.println(DriverFactory.getDriver());
        driver.get("https://stage-demo.lambdatest.com/");
        String title = driver.getTitle();
        //assertEquals(title,"Sample page - lambdatest.com");
  }

  @Step("Select the desired location with the number of guests")
  public void selectLocation() throws InterruptedException {

        // Let's select the location
        driver.findElement(By.id("headlessui-listbox-button-1")).click();
        driver.findElement(By.id("Bali")).click();
        System.out.println("Location is selected as Bali.");
        // Let's select the number of guests
        driver.findElement(By.id("headlessui-listbox-button-5")).click();
        driver.findElement(By.id("2")).click();
        System.out.println("Number of guests are selected.");
        driver.findElement(By.xpath("//*[@id='search']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Step("Select the desired hotel from the corresponding search results")
  public void selectHotel() throws InterruptedException {

        // Let's select one of the hotels for booking
        driver.findElement(By.id("reserve-now")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Step("Go through the details to confirm the booking")
  public void confirmHotel() throws InterruptedException {

        driver.findElement(By.id("proceed")).click();
        System.out.println("Booking is confirmed.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Step("Download the invoice")
  public void download() throws InterruptedException {
    
        driver.findElement(By.id("invoice")).click();
        System.out.println("Tests are run successfully!");
  }
}
