package ui.Tests;

import helper.Faker;
import org.junit.jupiter.api.Test;
import ui.Pages.ElementsPage;

import static ui.Pages.ElementsPage.textBox;

public class ElementsTests extends AbstractTest {

    @Test
    void InputFieldsTest(){
        String name = Faker.fullName;
        String email = Faker.email;
        String address = Faker.address;
        ElementsPage elementsPage = IndexPage.goToElements();
        elementsPage
                .clickMenuValue(textBox)
                .fillInputField("Full Name", name)
                .fillInputField("Email", email)
                .fillInputField("Current Address", address)
                .clickSubmit()
                .checkOutput(name, email, address);
    }
}
