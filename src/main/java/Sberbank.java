import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Написать тест на следующий сценарий
 * 1) Зайти на сайт Сбербанка
 * 2) Навести курсор на пункт меню "Ипотека"
 * 3) Выбрать "Ипотека на готовое жилье"
 * 4) Изменить стоимость недвижимости на сумму 900000
 * 5) Изменить первоночальный взнос на сумму 150000
 * 6) Изменить срок кредита на 30 лет
 * 7) Процентная ставка должна составлять 10,0%
 * 8) Сумма кредита должна быть 750000
 * 9) Ежемясячный платеж должен быть 6582
 *
 * по итогам выполнения теста должен формироваться отчет.
 * Достаточно написать для одного браузера (Mozilla или IE)
 * Код теста выложить в открытый доступ на GitHub
 * Необходимый стек: Java, JUnit/TestiNG, Maven, Allure
 */
public class Sberbank {
  private WebDriver driver;

  public Sberbank(WebDriver driver){
    this.driver = driver;
  }

  private By select_ipoteka = By.cssSelector(".lg-menu__list .lg-menu__item:nth-of-type(2) .lg-menu__text");

  private final String BUYING_COMPLETE_HOUSE = "Ипотека на готовое жильё";

  public Sberbank selectBuyingCompleteHouse() {
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(select_ipoteka)).perform();
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText(BUYING_COMPLETE_HOUSE)).click();
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
 }
}
