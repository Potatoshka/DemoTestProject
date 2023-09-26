package ui.Pages;

import Elements.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static helper.StringUtils.$$x;
import static helper.StringUtils.$x;
import static ui.Tests.IndexPage.mainHeader;

public class ElementsPage {
   public static Menu textBox = Menu.byText("Text Box");
   public static Menu checkBox = Menu.byText("Check Box");
   public static Menu radioButton = Menu.byText("Radio Button");
    Menu webTables = Menu.byText("Web Tables");
    Menu buttons = Menu.byText("Buttons");
    Menu links = Menu.byText("Links");
    Menu brokenLinks = Menu.byText("Broken Links - Images");
    Menu upload = Menu.byText("Upload and Download");
    Menu dynamicProperties = Menu.byText("Dynamic Properties");
    SelenideElement desktopToggle = $x("//span[contains(@class, 'rct-title') and text() = 'Desktop']");
    SelenideElement documentsToggle = $x("//span[contains(@class, 'rct-title') and text() = 'Desktop']");
    SelenideElement downloadsToggle = $x("//span[contains(@class, 'rct-title') and text() = 'Desktop']");

    @Step("Click 'Text Box' menu")
    public ElementsPage clickMenuValue(Menu menu){
        menu.clickMenu();
     Assertions.assertEquals(menu.getText() ,mainHeader.getText());
     return this;
    }

    @Step("Check that field 'Output' is correct")
 public ElementsPage checkOutput(String name, String email, String address){
     $x("//div[@id='output']").shouldBe(Condition.visible);
     Assertions.assertEquals( "Name:" + name , $x("//div[@id='output']//p[@id='name']").getText());
     Assertions.assertEquals( "Email:" + email, $x("//div[@id='output']//p[@id='email']").getText());
     Assertions.assertEquals( "Current Address :" + address, $x("//div[@id='output']//p[@id='currentAddress']").getText());
     return this;
    }

    @Step("Fill input field: {label}")
    public ElementsPage fillInputField(String label, String text){
        Input.byLabel(label).inputSetValue(text);
        return this;
    }

    @Step("Fill textArea: {placeholder}")
    public ElementsPage fillTextArea(String placeholder, String text){
        TextArea.byPlaceHolder(placeholder).inputSetValue(text);
        return this;
    }

    @Step("Click Submit button")
    public ElementsPage clickSubmit(){
        Button.byId("submit").clickButton();
        return this;
    }

    @Step("Click expand button")
    public ElementsPage clickExpand(){
        Button.byAriaLabel("Expand all").clickButton();
        return this;
    }

    @Step("Click collapse button")
    public ElementsPage clickCollapse(){
        Button.byAriaLabel("Collapse all").clickButton();
        return this;
    }

    @Step("Check that tree has expanded")
    public ElementsPage checkTreeExpanded(){
        Assertions.assertTrue(desktopToggle.is(Condition.visible));
        Assertions.assertTrue(documentsToggle.is(Condition.visible));
        Assertions.assertTrue(downloadsToggle.is(Condition.visible));
        return this;
    }

    @Step("Check that tree has collapsed")
    public ElementsPage checkTreeCollapsed(){
        Assertions.assertFalse(desktopToggle.is(Condition.visible));
        Assertions.assertFalse(documentsToggle.is(Condition.visible));
        Assertions.assertFalse(downloadsToggle.is(Condition.visible));
        return this;
    }

    @Step("set checkboxes")
    public ElementsPage setCheckBoxes(){
        CheckBox.byLabel("tree-node-desktop").clickCheckBox();
        List<String> selectedValues = $$x("//span[@class='text-success']").texts();
        Assertions.assertTrue(listContainsValue(selectedValues, "desktop"));
        Assertions.assertTrue(listContainsValue(selectedValues, "notes"));
        Assertions.assertTrue(listContainsValue(selectedValues, "commands"));
        return this;
    }

    @Step("Set 'Yes' radio button and check")
    public ElementsPage setRadioButtons(){
        RadioButton.byText("Yes").clickRadioButton();
        Assertions.assertEquals("Yes", $x("//*[@class='text-success']").getText());
        return this;
    }

    @Step("Check that 'No' button is disabled")
    public ElementsPage radioBtnIsDisabled(){
        RadioButton.byText("No").isDisabled();
        return this;
    }

    boolean listContainsValue(List<String> list, String value){
        return list.stream().anyMatch(s -> s.equals(value));
    }

}
