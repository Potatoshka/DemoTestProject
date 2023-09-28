package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static helper.StringUtils.$x;

public class Table {
    SelenideElement table;

    public Table(SelenideElement table){this.table = table.shouldBe(Condition.visible);}

    public static Table byClass(String className){
        return new Table($x("//*[@class='rt-table']"));
    }

    public void findValueInColumn(String columnName, String value){

    }
    public  SelenideElement getRowByNumber(int rowNumber){
        ElementsCollection rows = table.$$x("//*[@class='rt-tr-group']");
        return rows.get(rowNumber);
    }

    public List<SelenideElement> getColumnByName(String columnName){
        ElementsCollection headers = table.$$x("*[@role='columnheader']");
        int columnIndex = -1;
        for(SelenideElement element: headers){
            if(element.getText().equals(columnName)){
                columnIndex = headers.indexOf(element) + 1;
            }
        }
        ElementsCollection rows = table.$$x("*[@class='rt-tr-group']");
        List<SelenideElement> column = new ArrayList<>();
        for(SelenideElement row : rows){
            column.add(row.$x("(*[@role='gridcell'])", columnIndex));
        }
        return column;
    }

    public boolean isTextInColumn(String columnName, String text){
        List<SelenideElement> column = getColumnByName(columnName);
        for (SelenideElement element : column){
            if (element.getText().equals(text)){
                return true;
            }
        }
        return false;
    }
}
