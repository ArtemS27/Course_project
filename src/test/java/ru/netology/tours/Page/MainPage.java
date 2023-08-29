package ru.netology.tours.Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement payButton = $(byText("Купить"));
    private SelenideElement creditPayButton = $(byText("Купить в кредит"));
    private SelenideElement payByCardText = $(byText("Оплата по карте"));
    private SelenideElement payByCreditText = $(byText("Кредит по данным карты"));

    public void payByCard(){
        payButton.click();
        payByCardText.shouldBe(Condition.visible);
    }

    public void payByCredit(){
        creditPayButton.click();
        payByCreditText.shouldBe(Condition.visible);
    }
}
