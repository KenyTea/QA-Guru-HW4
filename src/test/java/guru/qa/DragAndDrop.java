package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

        @BeforeAll
        static void config() {
            Configuration.startMaximized = true;
            //Configuration.headless = true; не открывает страницу браузера
        }

        @Test
        void dragAndDrop() {

            // Открываем браузер
            open("https://the-internet.herokuapp.com/drag_and_drop");

            String squareA = "#column-a";
            String squareB = "#column-b";

            if($(squareA).$(byText("A")).is(Condition.visible)){
                // Drag and Drop
                $(squareA).dragAndDropTo(squareB);
                //Проверяем
                $(squareA).parent().shouldHave(Condition.text("B"));
                // Вывод в лог
                System.out.println("\nSuccessful movement of " + squareA + "\n");
            }
            else {
                $(squareB).dragAndDropTo(squareA);
                $(squareA).parent().shouldHave(Condition.text("A"));
                System.out.println("\nSuccessful movement of " + squareB + "\n");
            }


            sleep(5000);
        }
    }

