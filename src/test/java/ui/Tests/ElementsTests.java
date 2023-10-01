package ui.Tests;

import helper.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.Pages.BasePage;
import ui.Pages.ElementsDirectory.CheckBoxPage;
import ui.Pages.ElementsDirectory.RadioButtonPage;
import ui.Pages.ElementsDirectory.TextBoxPage;
import ui.Pages.ElementsDirectory.WebTablesPage;

import static ui.Pages.BasePage.*;

public class ElementsTests extends AbstractTest {





    @Test
    @DisplayName("TextBox tests")
    void inputFieldsTest(){
        IndexPage.goToElements().clickMenuValue(textBox);
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage
                .fillData()
                .checkOutput();
    }

    @Test
    @DisplayName("CheckBox test")
    void checkBoxTest(){
        IndexPage.goToElements().clickMenuValue(checkBox);
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        checkBoxPage
                .clickExpandTree()
                .setCheckBoxes()
                .checkTreeCollapsed();
    }

    @Test
    @DisplayName("Radio button test")
    void radioButtonTest(){
        IndexPage.goToElements().clickMenuValue(radioButton);
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        radioButtonPage
                .setRadioButtons()
                .radioBtnIsDisabled();
    }

    @Test
    @DisplayName("Web Table add value test")
    void addUserTableTest(){
        IndexPage.goToElements().clickMenuValue(webTables);
        WebTablesPage webTablesPage = new WebTablesPage();
        webTablesPage
                .clickAddButton()
                .fillRegistrationForm()
                .checkTable();
    }

    @Test
    @DisplayName("Edit user WebTable test")
    void editUserTableTest(){
        IndexPage.goToElements().clickMenuValue(webTables);
        WebTablesPage webTablesPage = new WebTablesPage();
        String originalName = webTablesPage.getFirstNameFromFirstRow();
            webTablesPage
                    .clickEdit()
                    .fillFirstName("EditedName")
                    .clickSubmit();
            webTablesPage.checkFirstName(originalName);

    }


}
