package ui.Pages.ElementsDirectory;

import Elements.Button;
import Elements.Table;
import helper.Faker;
import io.qameta.allure.Step;
import ui.Pages.BasePage;

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
        table.isTextInColumn(firstNameColumn, name);
        table.isTextInColumn(lastNameColumn, surname);
        table.isTextInColumn(emailColumn, email);
        table.isTextInColumn(salaryColumn, String.valueOf(salary));
        table.isTextInColumn(ageColumn, String.valueOf(age));
        table.isTextInColumn(departmentColumn, department);
        return this;
    }

}
