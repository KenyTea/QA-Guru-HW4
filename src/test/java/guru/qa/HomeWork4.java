package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork4 {
//    @Rule
//    public  TestRule report = new TestReporter();

    @BeforeAll
    static void config() {
        Configuration.startMaximized = true;
        //Configuration.headless = true; не открывает страницу браузера
    }

    @Test
    void checkJunit5() {

//        Разработайте следующий автотест:
//
//        - Откройте страницу Selenide в Github
//
//        - Перейдите в раздел Wiki проекта
//
//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//
//                - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5


        // Открываем браузер
        open("https://github.com/selenide/selenide");

        // Переходим на вкладку Wiki
        $(byText("Wiki")).click();

        // Проверяем переход на страницу Wiki
        $("#user-content-welcome-to-the-selenide-wiki").
                should(Condition.visible, Duration.ofSeconds(10));

        // Кликаем на Soft assertions
        $(byText("Soft assertions")).should(Condition.visible);
        $(byText("Soft assertions")).click();

        // Проверяем переход на страницу SoftAssertions
        $(byText("SoftAssertions")).shouldBe(Condition.visible,Duration.ofSeconds(10));

        // Проверяем наличие примера кода для JUnit5 (тест отрабатывает за 12s)
        $("ol li").parent().shouldHave(Condition.text("com.codeborne.selenide.junit5.SoftAssertsExtension"));

        // Судя по тому, что тест не поломался разницы между $("ol li") и  $("ol").$("li") нет. (тест отрабатывает за теже 12s)
        // Больше похоже на упрощение кода
        $("ol").$("li").parent().shouldHave(Condition.text("com.codeborne.selenide.junit5.SoftAssertsExtension"));

        // Задержна для проверки
        //sleep(5000);
    }





}
