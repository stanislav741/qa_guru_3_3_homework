package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {
    String DepositsUrl = "make-money/deposits/";
    @Test

    void alfaBankDeposits() {
        open("https://alfabank.ru");
        $("#alfa").$(byText("Вклады")).click();
        $("[data-widget-name='Heading']").shouldHave(text("Накопительные продукты"));
        $("#filter").$(byText("Депозиты")).parent().click();
        $("#alfa").$(byText("Архивные счета и депозиты")).parent().click();
        $("#filter").$(byText("Депозиты")).parent().click();
        $$("[data-widget-name='CatalogCard']").shouldHaveSize(5);
    }
    @Test

    void alfaBankInsurance() {
        open("https://alfabank.ru/");
        $("#alfa").$(byText("Вклады")).closest("span").click();
        $("#benefit").$("button").parent().click();
        $("body").shouldHave(text("Страхование вкладов"));
    }
    @Test

    void alfaBankInsuranceTab() {
        open("https://alfabank.ru/");
        $("#alfa").$(byText("Вклады")).click();
        $("#good-to-know").$(byText("Страхование вкладов")).click();
        $("#good-to-know").$(byText("Страхование вкладов")).parent().preceding(0).shouldHave(text("Описание"));
        $("#good-to-know").$(byText("Страхование вкладов")).parent().sibling(0).shouldHave(text("Что такое вклад?"));
    }
}