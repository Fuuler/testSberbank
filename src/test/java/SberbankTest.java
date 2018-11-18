import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class SberbankTest {
  private WebDriver driver;
  private Sberbank sberbank;
  private IpotekaDomclick ipotekaDomclick;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//    System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
    driver = new ChromeDriver();
//    driver = new FireFoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    driver.get("https://www.sberbank.ru");
    sberbank = new Sberbank(driver);
    ipotekaDomclick = new IpotekaDomclick(driver);
  }

  @Test
  public void test() throws Exception {
    sberbank.selectBuyingCompleteHouse();
    ipotekaDomclick.switchTo();
    ipotekaDomclick.izmenitStoimostNedvigimosti("900000");
    ipotekaDomclick.izmenitPervonochalniVznosNaSummu("150000");
    ipotekaDomclick.izmenitSrokKredita("30");
    ipotekaDomclick.rate();
    ipotekaDomclick.proveritProcentStavka();
    ipotekaDomclick.amountOfCredit();
    ipotekaDomclick.proveritSummuCredita();
    ipotekaDomclick.monthlyPayment();
    ipotekaDomclick.proveritMonthPlateg();
  }

  @After
  public void tearDown() throws Exception {
 //   driver.quit();

    }
  }


