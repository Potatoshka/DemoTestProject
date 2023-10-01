package ui.Pages.ElementsDirectory;

import Elements.Button;
import Elements.RadioButton;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ui.Pages.BasePage;

import static helper.StringUtils.$x;

public class RadioButtonPage {
    @Step("Set 'Yes' radio button and check")
    public RadioButtonPage setRadioButtons(){
        RadioButton.byText("Yes").clickRadioButton();
        Assertions.assertEquals("Yes", $x("//*[@class='text-success']").getText());
        return this;
    }

    @Step("Check that 'No' button is disabled")
    public RadioButtonPage radioBtnIsDisabled(){
        RadioButton.byText("No").isDisabled();
        return this;
    }

    @Step("Click add button")
    public RadioButtonPage clickAdd(){
        Button.byId("addNewRecordButton").clickButton();
        return this;
    }
}
