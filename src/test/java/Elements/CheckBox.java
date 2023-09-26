package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static helper.StringUtils.$x;

public class CheckBox {
SelenideElement element;

public CheckBox(SelenideElement element){this.element = element.shouldBe(Condition.visible);}

    public static CheckBox byLabel(String label){
    return new CheckBox($x("//label[@for='{}']//span[contains(@class,'checkbox')]", label));
    }
    public static CheckBox byName(String name){
    return new CheckBox($x("//span[.='{}']//.//span[@class='rct-checkbox']", name));
    }

    public void clickCheckBox(){element.click();}
}
