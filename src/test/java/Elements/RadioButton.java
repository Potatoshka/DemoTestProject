package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.Click;

import static helper.StringUtils.$x;

public class RadioButton {
    SelenideElement element;

    public RadioButton(SelenideElement element){this.element = element;}
    public static RadioButton byId(String id){return new RadioButton($x("//input[@id='{}']", id));}
    public static RadioButton byText(String value){return new RadioButton($x("//div[.='{}']//./input", value));}

    public void clickRadioButton(){element.click();}
    public void isDisabled(){element.shouldBe(Condition.disabled);}
}
