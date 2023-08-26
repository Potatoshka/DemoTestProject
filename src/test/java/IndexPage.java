import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static helper.StringUtils.$x;


@Getter
public class IndexPage {
    SelenideElement elements = $x("//div[.='Elements']");
}
