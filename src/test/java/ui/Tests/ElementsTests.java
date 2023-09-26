package ui.Tests;

import helper.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.Pages.ElementsPage;

import static ui.Pages.ElementsPage.*;

public class ElementsTests extends AbstractTest {

    @Test
    @DisplayName("TextBox tests")
    void inputFieldsTest(){
        String name = Faker.fullName;
        String email = Faker.email;
        String address = Faker.address;
        ElementsPage elementsPage = IndexPage.goToElements();
        elementsPage
                .clickMenuValue(textBox)
                .fillInputField("Full Name", name)
                .fillInputField("Email", email)
                .fillTextArea("Current Address", address)
                .clickSubmit()
                .checkOutput(name, email, address);
    }

    @Test
    @DisplayName("CheckBox test")
    void checkBoxTest(){
        ElementsPage elementsPage = IndexPage.goToElements();
        elementsPage
                .clickMenuValue(checkBox)
                .clickExpand()
                .checkTreeExpanded()
                .setCheckBoxes()
                .clickCollapse()
                .checkTreeCollapsed();
    }

    @Test
    @DisplayName("Radio button test")
    void radioButtonTest(){
        ElementsPage elementsPage = IndexPage.goToElements();
        elementsPage
                .clickMenuValue(radioButton)
                .setRadioButtons()
                .radioBtnIsDisabled();
    }


}
