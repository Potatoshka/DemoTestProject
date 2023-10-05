package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static helper.StringUtils.$x;

public class Link {
    static SelenideElement element;

    public Link(SelenideElement element){this.element = element.shouldBe(Condition.visible);}

    public static Link byID(String id){return new Link($x("//*[@id='{}']", id));}

    public  void clickLink(){element.click();}
}
