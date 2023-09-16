package ui.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class AbstractTest {
    @BeforeEach
    @DisplayName("Открываем главную страницу")
    void beforeEach(){
        open("https://demoqa.com");
    }

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1366x768";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }



}
