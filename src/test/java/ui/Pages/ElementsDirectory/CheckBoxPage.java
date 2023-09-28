package ui.Pages.ElementsDirectory;

import Elements.CheckBox;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ui.Pages.BasePage;

import java.util.List;

import static helper.StringUtils.$$x;
import static helper.StringUtils.$x;

public class CheckBoxPage extends BasePage {
    SelenideElement desktopToggle = $x("//span[contains(@class, 'rct-title') and text() = 'Desktop']");
    SelenideElement documentsToggle = $x("//span[contains(@class, 'rct-title') and text() = 'Desktop']");
    SelenideElement downloadsToggle = $x("//span[contains(@class, 'rct-title') and text() = 'Desktop']");
    @Step("Expand the tree and check that the tree has expanded")
    public CheckBoxPage clickExpandTree(){
        clickExpand();
        Assertions.assertTrue(desktopToggle.is(Condition.visible));
        Assertions.assertTrue(documentsToggle.is(Condition.visible));
        Assertions.assertTrue(downloadsToggle.is(Condition.visible));
        return this;
    }

    @Step("Check that tree has collapsed")
    public CheckBoxPage checkTreeCollapsed(){
        clickCollapse();
        Assertions.assertFalse(desktopToggle.is(Condition.visible));
        Assertions.assertFalse(documentsToggle.is(Condition.visible));
        Assertions.assertFalse(downloadsToggle.is(Condition.visible));
        return this;
    }

    @Step("set checkboxes")
    public CheckBoxPage setCheckBoxes(){
        CheckBox.byLabel("tree-node-desktop").clickCheckBox();
        List<String> selectedValues = $$x("//span[@class='text-success']").texts();
        Assertions.assertTrue(listContainsValue(selectedValues, "desktop"));
        Assertions.assertTrue(listContainsValue(selectedValues, "notes"));
        Assertions.assertTrue(listContainsValue(selectedValues, "commands"));
        return this;
    }

}
