package ru.netology.tours.Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import ru.netology.tours.Data.UserData;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private SelenideElement cardNumber = $(byText("Номер карты")).parent().$(byClassName("input__control"));
    private SelenideElement month = $(byText("Месяц")).parent().$(byClassName("input__control"));
    private SelenideElement year = $(byText("Год")).parent().$(byClassName("input__control"));
    private SelenideElement owner = $(byText("Владелец")).parent().$(byClassName("input__control"));
    private SelenideElement cvcCvv = $(byText("CVC/CVV")).parent().$(byClassName("input__control"));
    private SelenideElement confirmButton = $(byText("Продолжить"));
    private ElementsCollection notification = $$(byClassName("notification"));
    private SelenideElement cardNumberText = $(byText("Номер карты")).parent().$(byClassName("input__sub"));
    private SelenideElement monthText = $(byText("Месяц")).parent().$(byClassName("input__sub"));
    private SelenideElement yearText = $(byText("Год")).parent().$(byClassName("input__sub"));
    private SelenideElement ownerText = $(byText("Владелец")).parent().$(byClassName("input__sub"));
    private SelenideElement cvcCvvText = $(byText("CVC/CVV")).parent().$(byClassName("input__sub"));

    public void setData(UserData.CardInfo cardInfo){
        cardNumber.setValue(cardInfo.getCardNumber());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        owner.setValue(cardInfo.getOwner());
        cvcCvv.setValue(cardInfo.getCvcCvv());
        clickConfirm();
    }

    public void clickConfirm() {
        confirmButton.click();
    }

    public void checkValidPayment() {
        notification.first().shouldHave(Condition.text("Операция одобрена Банком"), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

    public void checkInvalidPayment() {
        notification.last().shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции"), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

    public void checkErrorsWithCleanFields() {
        cardNumberText.shouldHave(Condition.text("Неверный формат"));
        monthText.shouldHave(Condition.text("Неверный формат"));
        yearText.shouldHave(Condition.text("Неверный формат"));
        ownerText.shouldHave(Condition.text("Поле обязательно для заполнения"));
        cvcCvvText.shouldHave(Condition.text("Неверный формат"));
    }

    public void checkCardErrorNotifications() {
        cardNumberText.shouldHave(Condition.text("Неверный формат"));
    }

    public void checkMonthErrorNotification() {
        monthText.shouldHave(Condition.text("Неверно указан срок действия карты"));
    }

    public void checkYearErrorNotification() {
        yearText.shouldHave(Condition.text("Неверно указан срок действия карты"));
    }

    public void checkNameErrorNotification() {
        ownerText.shouldHave(Condition.text("Неверный формат"));
    }

    public void checkCvvCvcErrorNotification() {
        cvcCvvText.shouldHave(Condition.text("Неверный формат"));
    }
}
