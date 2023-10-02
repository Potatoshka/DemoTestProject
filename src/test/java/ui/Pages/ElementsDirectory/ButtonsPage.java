package ui.Pages.ElementsDirectory;

import Elements.Button;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class ButtonsPage {

    @Step("Double click button check")
    public ButtonsPage doubleClick(){
        Button.byId("doubleClickBtn").doubleClickButton();
       Assertions.assertTrue($("#doubleClickMessage").is(Condition.visible));
        return this;
    }

    @Step("Right click button check")
    public ButtonsPage rightClick(){
        Button.byId("rightClickBtn").rightClickButton();
        Assertions.assertTrue($("#rightClickMessage").is(Condition.visible));
        return this;
    }

    @Step("Click Dynamic button check")
    public  ButtonsPage clickDynamicButton(){
        Button.byText("Click Me").clickButton();
        Assertions.assertTrue($("#dynamicClickMessage").is(Condition.visible));
        return this;
    }
}
