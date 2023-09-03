package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static helper.StringUtils.$x;

public class Input {
    SelenideElement element;

    public Input(SelenideElement element){this.element = element.shouldBe(Condition.visible);}

    public static Input byId(String id){return new Input($x("//input[@id='{}']", id));}
    public static Input byLabel(String label){return new Input($x("//label[.='{}']//..//..//input", label));}
    public static Input byPlaceHolder(String placeHolder){return new Input($x("//input[@placeholder='{}']", placeHolder));}
    public void inputSetValue(String value){element.setValue(value);}
}
