package ru.yandex.practikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.practikum.pages.MakingOrder;

import static org.junit.Assert.assertEquals;

public class MakingOrderTest {
    private WebDriver driver;
    public static WebDriver createDriver(String browser) {
        WebDriver webdriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            // Создаем экземпляр ChromeDriver
            webdriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Создаем экземпляр FirefoxDriver
            webdriver = new FirefoxDriver();
        } else {
            System.out.println("Неподдерживаемый браузер: " + browser);
        }
        return webdriver;
    }

    @Test
    public void createOrder(){
        WebDriver driver = createDriver("firefox");
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MakingOrder order = new MakingOrder(driver);
        boolean actualResult = order.createOrderAfterClick("Никита", "Кардин", "Артельная 10А", "Бульвар Рокоссовского", "89101470050","29-е февраля 2024 г.", "двое суток", "black", "Верхняя");
        assertEquals(true, actualResult);
        driver.quit();
    }

}
