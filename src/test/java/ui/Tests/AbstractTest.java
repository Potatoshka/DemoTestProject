package ui.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import ui.Pages.ElementsDirectory.CheckBoxPage;
import ui.Pages.ElementsDirectory.RadioButtonPage;
import ui.Pages.ElementsDirectory.TextBoxPage;
import ui.Pages.ElementsDirectory.WebTablesPage;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.open;

public class AbstractTest {

    @BeforeEach
    @DisplayName("Open main page")
    void beforeEach(){
        open("https://demoqa.com");
    }

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1366x768";
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }



}
