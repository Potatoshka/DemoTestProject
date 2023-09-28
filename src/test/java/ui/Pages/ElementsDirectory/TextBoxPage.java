package ui.Pages.ElementsDirectory;

import com.codeborne.selenide.Condition;
import helper.Faker;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ui.Pages.BasePage;

import static helper.StringUtils.$x;

public class TextBoxPage extends BasePage{
    final String name = Faker.fullName;
    final String email = Faker.email;
    final String address = Faker.address;
    @Step("Fill data")
    public TextBoxPage fillData(){
        fillInputField("Full Name", name);
        fillInputField("Email", email);
        fillTextArea("Current Address", address);
        clickSubmit();
        return this;
    }
    @Step("Check that field 'Output' is correct")
    public void checkOutput(){
        $x("//div[@id='output']").shouldBe(Condition.visible);
        Assertions.assertEquals( "Name:" + name , $x("//div[@id='output']//p[@id='name']").getText());
        Assertions.assertEquals( "Email:" + email, $x("//div[@id='output']//p[@id='email']").getText());
        Assertions.assertEquals( "Current Address :" + address, $x("//div[@id='output']//p[@id='currentAddress']").getText());
    }
}
