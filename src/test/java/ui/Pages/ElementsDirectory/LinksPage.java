package ui.Pages.ElementsDirectory;

import Elements.Link;
import io.qameta.allure.Step;
import it.lamba.utils.ImageData;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;


import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static it.lamba.utils.KImageCheck.analyzeImage;

public class LinksPage {
    @Step("Click simple link")
    public LinksPage clickSimpleLink(){
        Link.byID("simpleLink").clickLink();
        switchTo().window(1);
        Assertions.assertEquals("https://demoqa.com/", url());
        return this;
    }

    @Step("Close window")
    public LinksPage closeTab(){
        closeWindow();
        return this;
    }

    @Step("Click dynamic link")
    public LinksPage clickDynamicLink(){
        Link.byID("dynamicLink").clickLink();
        switchTo().window(1);
        Assertions.assertEquals("https://demoqa.com/", url());
        return this;
    }

    @Step("Check Image")
    public LinksPage checkImage(URL link) throws IOException {
        InputStream in = new BufferedInputStream(link.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream("image.jpg");
        fos.write(response);
        fos.close();

        Path myPath = Paths.get("image.jpg");
        ImageData imageData = analyzeImage(myPath);
        Assertions.assertTrue(imageData.isImage());

        return this;
    }

}
