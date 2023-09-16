package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static helper.StringUtils.$x;

public class TextArea {
    SelenideElement element;

    public TextArea(SelenideElement element){this.element = element.shouldBe(Condition.visible);}

    public static TextArea byId(String id){return new TextArea($x("//textarea[@id='{}']", id));}
    public static TextArea byLabel(String label){return new TextArea($x("//label[.='{}']//..//..//textarea", label));}
    public static TextArea byPlaceHolder(String placeHolder){return new TextArea($x("//textarea[@placeholder='{}']", placeHolder));}
    public void inputSetValue(String value){element.setValue(value);}
}
