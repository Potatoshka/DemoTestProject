package ui.Tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import ui.Pages.BasePage;

import static helper.StringUtils.$x;


@Getter
public class IndexPage {

    public static SelenideElement mainHeader = $x("//div[@class='main-header']");
    static SelenideElement elements = $x("//div[.='Elements']");
    SelenideElement forms = $x("//div[.='Forms']");
    SelenideElement alerts = $x("//div[.='Alerts, Frame & Windows']");
    SelenideElement widgets = $x("//div[.='Widgets']");
    SelenideElement interactions = $x("//div[.='Interactions']");
    SelenideElement store = $x("//div[.='Book Store Application']");
    @Step("Go to Elements page")
    public static BasePage goToElements(){
        elements.click();
        return new BasePage();
    }

    public void checkHeader(String value){

    }

}
