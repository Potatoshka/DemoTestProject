package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static helper.StringUtils.$x;

public class Table {
    SelenideElement table;


    public Table(SelenideElement table) {
        this.table = table.shouldBe(Condition.visible);
    }

    public static Table byClass(String className) {
        return new Table($(".rt-table"));
    }

    public SelenideElement getRowByNumber(int rowNumber) {
        ElementsCollection rows = table.$$(".rt-tr");
        return rows.get(rowNumber);
    }

    public SelenideElement getFirstRow(){
        return getRowByNumber(1);
    }
    public SelenideElement getSecondRow(){return getRowByNumber(2);}

    int getColumnIndex(String columnName){
        ElementsCollection headers = table.$$x(".//*[@role='columnheader']");
        int columnIndex = -1;
        for(SelenideElement element : headers){
            if (element.getText().equals(columnName)){
                columnIndex = headers.indexOf(element) + 1;
            }
        }
        if (columnIndex == -1) throw new RuntimeException("Column not found");
        return columnIndex;
    }

    public ElementsCollection getColumnByName(String columnName){
        return table.$$x(".//*[@role='row']/./*[@role='gridcell'][" + getColumnIndex(columnName) + "]");
    }


    public boolean isTextInColumn(String columnName, String text) {
        for(SelenideElement element : getColumnByName(columnName)){
            if (element.getText().equals(text)){
                return true;
            }
        }
        return false;
    }
  public String getDataFromCellInFirstRow(String columnName){
        return getFirstRow().$x(".//*[@role='gridcell'][" + getColumnIndex(columnName) + "]").getText();
    }
    public String getDataFromSecondCellInSecondRow(String columnName){
        return getSecondRow().$x(".//*[@role='gridcell'][" + getColumnIndex(columnName) + "]").getText();
    }
}
