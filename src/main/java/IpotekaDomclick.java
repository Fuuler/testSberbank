import org.junit.Assert;
import org.openqa.selenium.*;

public class IpotekaDomclick {
  private static WebDriver dv;
  private WebDriver driver;

  public IpotekaDomclick(WebDriver driver){
    this.driver = driver;
  }


  private By nedvigimost = By.xpath("//input [@id = \"estateCost\"]");
  private By pervonochalniVznos = By.id ("initialFee");
  private By srokCredita = By.id ("creditTerm");
  private By procentStavka = By.cssSelector ("[data-test-id = rate]");
  private By summuCredita = By.cssSelector ("[data-test-id = amountOfCredit]");
  private By monthPlateg = By.cssSelector ("[data-test-id = monthlyPayment]");


  public String rate(){
    return driver.findElement(procentStavka).getText();
  }
  public String amountOfCredit(){
    return driver.findElement(summuCredita).getText();
  }
  public String monthlyPayment(){
    return driver.findElement(monthPlateg).getText();
  }

  public IpotekaDomclick switchTo(){
    driver.switchTo().frame(driver.findElement(By.id("calculator-iframe")));
    return this;
  }

  public IpotekaDomclick izmenitStoimostNedvigimosti(String stoimostNedvigimosti){
    field_realty(stoimostNedvigimosti);
    return this;
  }

  public IpotekaDomclick izmenitPervonochalniVznosNaSummu(String summaPervonochalnogoVznosa){
    field_initial_payment(summaPervonochalnogoVznosa);
    return this;
  }

  public IpotekaDomclick izmenitSrokKredita(String srokKredita){
    field_credit_period(srokKredita);
    return this;
  }

  public IpotekaDomclick proveritProcentStavka() {
    String r = rate();
    Assert.assertEquals("10,0 %", r);
    System.out.println("Процентная ставка 10,0%");
    return this;
  }

  public IpotekaDomclick proveritSummuCredita() {
    String a = amountOfCredit();
    Assert.assertEquals("750 000 \u20BD", a);
    System.out.println("Сумма кредита 750000");
    return this;
  }

  public IpotekaDomclick proveritMonthPlateg() {
     String m = monthlyPayment();
    Assert.assertEquals("6 582 \u20BD", m);
    System.out.println("ежемесячный платеж 6582");
    return this;


    }
  private void field_realty(String stoimostNedvigimosti) {
    driver.findElement(nedvigimost).clear();
    driver.findElement(nedvigimost).click();
    driver.findElement(nedvigimost).clear();
    driver.findElement(nedvigimost).sendKeys(stoimostNedvigimosti);
    try {
      Thread.sleep(7000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void field_initial_payment(String summaPervonochalnogoVznosa) {
    driver.findElement(pervonochalniVznos).clear();
    driver.findElement(pervonochalniVznos).click();
    driver.findElement(pervonochalniVznos).clear();
    driver.findElement(pervonochalniVznos).sendKeys(summaPervonochalnogoVznosa);
  }


  private void field_credit_period(String srokKredita) {
    driver.findElement(srokCredita).clear();
    driver.findElement(srokCredita).click();
    driver.findElement(srokCredita).sendKeys(srokKredita);
  }

}
