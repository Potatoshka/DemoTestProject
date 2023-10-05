package ui.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.Pages.ElementsDirectory.*;

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

    @Test
    @DisplayName("Delete user from table")
    void deleteUserFromTableTest(){
        IndexPage.goToElements().clickMenuValue(webTables);
        WebTablesPage webTablesPage = new WebTablesPage();
        String toBeDeletedName = webTablesPage.getLastNameFromSecondRow();
        webTablesPage
                .clickDelete()
                .checkNoLastName(toBeDeletedName);
    }

    @Test
    @DisplayName("Buttons test")
    void clickButtonsTest(){
        IndexPage.goToElements().clickMenuValue(buttons);
        ButtonsPage buttonsPage = new ButtonsPage();
        buttonsPage
                .doubleClick()
                .rightClick()
                .clickDynamicButton();
    }

    @Test
    @DisplayName("Simple link test")
    void linksTest(){
        IndexPage.goToElements().clickMenuValue(links);
        new LinksPage()
                .clickSimpleLink();
    }

    @Test
    @DisplayName("Dynamic link test")
    void dynamicLinkTest(){
        IndexPage.goToElements().clickMenuValue(links);
        new LinksPage()
                .clickDynamicLink();
    }

    @Test
    @DisplayName("Links with API response test")
    void apiLinksTest(){

    }


}
