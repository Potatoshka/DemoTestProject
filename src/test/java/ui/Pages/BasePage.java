package ui.Pages;

import Elements.Button;
import Elements.Input;
import Elements.Menu;
import Elements.TextArea;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static ui.Tests.IndexPage.mainHeader;

public class BasePage {
   public static Menu textBox = Menu.byText("Text Box");
   public static Menu checkBox = Menu.byText("Check Box");
   public static Menu radioButton = Menu.byText("Radio Button");
   public static Menu webTables = Menu.byText("Web Tables");
    Menu buttons = Menu.byText("Buttons");
    Menu links = Menu.byText("Links");
    Menu brokenLinks = Menu.byText("Broken Links - Images");
    Menu upload = Menu.byText("Upload and Download");
    Menu dynamicProperties = Menu.byText("Dynamic Properties");


    @Step("Click '{menu}' menu")
    public BasePage clickMenuValue(Menu menu){
        menu.clickMenu();
     Assertions.assertEquals(menu.getText() ,mainHeader.getText());
     return this;
    }

    @Step("Fill input field: {label}")
    public BasePage fillInputField(String label, String text){
        Input.byLabel(label).inputSetValue(text);
        return this;
    }

    public BasePage clearInputField(String label){
        Input.byLabel(label).clearValue();
        return this;
    }

    @Step("Fill textArea: {placeholder}")
    public BasePage fillTextArea(String placeholder, String text){
        TextArea.byPlaceHolder(placeholder).inputSetValue(text);
        return this;
    }

    @Step("Click Submit button")
    public BasePage clickSubmit(){
        Button.byId("submit").clickButton();
        return this;
    }

    @Step("Click expand button")
    public BasePage clickExpand(){
        Button.byAriaLabel("Expand all").clickButton();
        return this;
    }

    @Step("Click collapse button")
    public BasePage clickCollapse(){
        Button.byAriaLabel("Collapse all").clickButton();
        return this;
    }





   public boolean listContainsValue(List<String> list, String value){
        return list.stream().anyMatch(s -> s.equals(value));
    }

}
