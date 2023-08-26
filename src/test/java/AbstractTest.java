import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class AbstractTest {
    @BeforeEach
    @DisplayName("Открываем главную страницу")
    void beforeEach(){
        open("https://demoqa.com");
    }

}
