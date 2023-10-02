package ui.Pages.ElementsDirectory;

import Elements.Button;
import Elements.Table;
import com.codeborne.selenide.SelenideElement;
import helper.Faker;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ui.Pages.BasePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class WebTablesPage extends BasePage {
   final String name = Faker.name;
   final String surname = Faker.lastName;
   final String email = Faker.email;
   final int age = Faker.age;
   final int salary = Faker.salary;
    String department = Faker.department;
    String firstNameColumn = "First Name";
    String lastNameColumn = "Last Name";
    String ageColumn = "Age";
    String emailColumn = "Email";
    String salaryColumn = "Salary";
    String departmentColumn = "Department";
    @Step("Click Add Button")
    public WebTablesPage clickAddButton(){
        Button.byId("addNewRecordButton").clickButton();
        return this;
    }

    @Step("Fill in Registration Form")
    public WebTablesPage fillRegistrationForm(){
        fillInputField(firstNameColumn, name);
        fillInputField(lastNameColumn, surname);
        fillInputField(emailColumn, email);
        fillInputField(ageColumn, String.valueOf(age));
        fillInputField(salaryColumn, String.valueOf(salary));
        fillInputField(departmentColumn, department);
        clickSubmit();
        return this;
    }

    @Step("Check if new values appeared in the table")
    public WebTablesPage checkTable(){
        Table table = Table.byClass("rt-table");
        Assertions.assertTrue(table.isTextInColumn(firstNameColumn, name));
        Assertions.assertTrue(table.isTextInColumn(lastNameColumn, surname));
        Assertions.assertTrue(table.isTextInColumn(emailColumn, email));
        Assertions.assertTrue(table.isTextInColumn(salaryColumn, String.valueOf(salary)));
        Assertions.assertTrue(table.isTextInColumn(ageColumn, String.valueOf(age)));
        Assertions.assertTrue(table.isTextInColumn(departmentColumn, department));
        return this;
    }



    @Step("Get First Name from first row")
    public String getFirstNameFromFirstRow() {
        Table table = Table.byClass("rt-table");
        return table.getDataFromCellInFirstRow(firstNameColumn);
    }

    @Step("Get Last Name from second row")
    public String getLastNameFromSecondRow(){
        Table table = Table.byClass("rt-table");
        return table.getDataFromSecondCellInSecondRow(lastNameColumn);
    }

    @Step("Click Edit in Table where the First row")
    public WebTablesPage clickEdit(){
        $("#edit-record-1").click();
        return this;
    }

    @Step("Clear and fill in First Name input field")
    public WebTablesPage fillFirstName(String value){
        clearInputField(firstNameColumn);
        fillInputField(firstNameColumn, value);
        return this;
    }

    @Step("Check edited First Name")
    public WebTablesPage checkFirstName(String originalName){
        Assertions.assertNotEquals(originalName, getFirstNameFromFirstRow());
        return this;
    }

    @Step("Check that no LastName in the column")
    public WebTablesPage checkNoLastName(String lastName){
        Table table =  Table.byClass("rt-table");
        Assertions.assertFalse(table.isTextInColumn(lastNameColumn, lastName));
        return this;
    }

    @Step("Click Delete in the table")
    public WebTablesPage clickDelete(){
        $("#delete-record-2").click();
        return this;
    }
}
