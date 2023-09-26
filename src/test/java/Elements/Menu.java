package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static helper.StringUtils.$x;

public class Menu {
    SelenideElement element;

    public Menu(SelenideElement element){this.element = element.shouldBe(Condition.visible);}
    public static Menu byText(String text){return new Menu($x("//li[.='{}']", text));}

    public void clickMenu(){
        element.click();
    }

    public String getText(){return element.text();}
}
