package ui.Pages.ElementsDirectory;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ui.Pages.BasePage;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class UploadPage extends BasePage {
    @Step("Download file")
    public UploadPage downLoadFile() throws FileNotFoundException {
      File file =  $("#downloadButton").download();
        Assertions.assertTrue(file.exists());
        file.delete();
        return this;
    }
}
