package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static helper.StringUtils.$x;

public class Button {
    SelenideElement element;

    public Button(SelenideElement element){this.element = element.scrollIntoView(true).shouldBe(Condition.visible);}

    public static Button byId(String id){return new Button($x("//button[@id='{}']", id));}
    public static Button byAriaLabel(String label){return new Button($x("//button[@aria-label='{}']", label));}

    public void clickButton(){element.click();}

}
