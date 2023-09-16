package ui.Pages;

import Elements.Button;
import Elements.Input;
import Elements.Menu;
import Elements.TextArea;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static helper.StringUtils.$x;
import static ui.Tests.IndexPage.mainHeader;

public class ElementsPage {
   public static Menu textBox = Menu.byText("Text Box");
    Menu checkBox = Menu.byText("Check Box");
    Menu radioButton = Menu.byText("Radio Button");
    Menu webTables = Menu.byText("Web Tables");
    Menu buttons = Menu.byText("Buttons");
    Menu links = Menu.byText("Links");
    Menu brokenLinks = Menu.byText("Broken Links - Images");
    Menu upload = Menu.byText("Upload and Download");
    Menu dynamicProperties = Menu.byText("Dynamic Properties");
    @DisplayName("Click 'Text Box' menu")
    public ElementsPage clickMenuValue(Menu menu){
        menu.clickMenu();
     Assertions.assertEquals(mainHeader.getText(), "Text Box");
     return this;
    }

    @DisplayName("Check that field 'Output' is correct")
 public ElementsPage checkOutput(String name, String email, String address){
     $x("//div[@id='output']").shouldBe(Condition.visible);
     Assertions.assertEquals( "Name:" + name , $x("//div[@id='output']//p[@id='name']").getText());
     Assertions.assertEquals( "Email:" + email, $x("//div[@id='output']//p[@id='email']").getText());
     Assertions.assertEquals( "Current Address :" + address, $x("//div[@id='output']//p[@id='currentAddress']").getText());
     return this;
    }

    @DisplayName("Fill input field: {label}")
    public ElementsPage fillInputField(String label, String text){
        Input.byLabel(label).inputSetValue(text);
        return this;
    }

    @DisplayName("Fill textArea: {placeholder}")
    public ElementsPage fillTextArea(String placeholder, String text){
        TextArea.byPlaceHolder(placeholder).inputSetValue(text);
        return this;
    }

    @DisplayName("Click Submit button")
    public ElementsPage clickSubmit(){

        Button.byId("submit").clickButton();
        return this;
    }


}
