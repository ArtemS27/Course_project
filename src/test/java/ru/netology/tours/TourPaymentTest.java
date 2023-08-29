package ru.netology.tours;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.tours.Data.SQL_Helper;
import ru.netology.tours.Data.UserData;
import ru.netology.tours.Data.UserData.CardInfo;
import ru.netology.tours.Page.MainPage;
import ru.netology.tours.Page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class TourPaymentTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    void payByCardWithApprovedCardNumber(){
        CardInfo cardInfo = UserData.getValidDataApproved();
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.setData(cardInfo);
        paymentPage.checkValidPayment();
        String actual = SQL_Helper.getCardOperationStatus();
        String expected = "APPROVED";
        Assertions.assertLinesMatch(actual.lines(), expected.lines());
    }

    @Test
    void payByCreditWithApprovedCardNumber(){
        CardInfo cardInfo = UserData.getValidDataApproved();
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.setData(cardInfo);
        paymentPage.checkValidPayment();
        String actual = SQL_Helper.getCreditOperationStatus();
        String expected = "APPROVED";
        Assertions.assertLinesMatch(actual.lines(), expected.lines());
    }

    @Test
    void payByCardWithDeclinedCardNumber(){
        CardInfo cardInfo = UserData.getValidDataDecline();
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.setData(cardInfo);
        paymentPage.checkInvalidPayment();
        String actual = SQL_Helper.getCardOperationStatus();
        String expected = "DECLINED";
        Assertions.assertLinesMatch(actual.lines(), expected.lines());
    }

    @Test
    void payByCreditWithDeclinedCardNumber() {
        CardInfo cardInfo = UserData.getValidDataDecline();
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.setData(cardInfo);
        paymentPage.checkInvalidPayment();
        String actual = SQL_Helper.getCreditOperationStatus();
        String expected = "DECLINED";
        Assertions.assertLinesMatch(actual.lines(), expected.lines());
    }

    @Test
    void payByCardWithInvalidCardNumber() {
        CardInfo cardInfo = new CardInfo(UserData.generateInvalidCardNumber(), UserData.generateValidMonth(), UserData.generateValidYear(), UserData.generateValidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.setData(cardInfo);
        paymentPage.checkCardErrorNotifications();
    }

    @Test
    void payByCardWithInvalidMonth() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateInvalidMonth(), UserData.generateValidYear(), UserData.generateValidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.setData(cardInfo);
        paymentPage.checkMonthErrorNotification();
    }

    @Test
    void payByCardWithInvalidYear() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateValidMonth(), UserData.generateInvalidYear(), UserData.generateValidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.setData(cardInfo);
        paymentPage.checkYearErrorNotification();
    }

    @Test
    void payByCardWithInvalidName() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateValidMonth(), UserData.generateValidYear(), UserData.generateInvalidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.setData(cardInfo);
        paymentPage.checkNameErrorNotification();
    }

    @Test
    void payByCardWithInvalidCvcCvv() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateValidMonth(), UserData.generateValidYear(), UserData.generateValidName(), UserData.generateInvalidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.setData(cardInfo);
        paymentPage.checkCvvCvcErrorNotification();
    }

    @Test
    void payByCreditWithInvalidCardNumber() {
        CardInfo cardInfo = new CardInfo(UserData.generateInvalidCardNumber(), UserData.generateValidMonth(), UserData.generateValidYear(), UserData.generateValidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.setData(cardInfo);
        paymentPage.checkCardErrorNotifications();
    }

    @Test
    void payByCreditWithInvalidMonth() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateInvalidMonth(), UserData.generateValidYear(), UserData.generateValidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.setData(cardInfo);
        paymentPage.checkMonthErrorNotification();
    }

    @Test
    void payByCreditWithInvalidYear() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateValidMonth(), UserData.generateInvalidYear(), UserData.generateValidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.setData(cardInfo);
        paymentPage.checkYearErrorNotification();
    }

    @Test
    void payByCreditWithInvalidName() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateValidMonth(), UserData.generateValidYear(), UserData.generateInvalidName(), UserData.generateValidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.setData(cardInfo);
        paymentPage.checkNameErrorNotification();
    }

    @Test
    void payByCreditWithInvalidCvcCvv() {
        CardInfo cardInfo = new CardInfo(UserData.getValidCardNumberApproved(), UserData.generateValidMonth(), UserData.generateValidYear(), UserData.generateValidName(), UserData.generateInvalidCvcCvv());
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.setData(cardInfo);
        paymentPage.checkCvvCvcErrorNotification();
    }

    @Test
    void payByCardWithCleanFields() {
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCard();
        paymentPage.clickConfirm();
        paymentPage.checkErrorsWithCleanFields();
    }


    @Test
    void payByCreditWithCleanFields() {
        PaymentPage paymentPage = new PaymentPage();
        MainPage mainPage = new MainPage();
        mainPage.payByCredit();
        paymentPage.clickConfirm();
        paymentPage.checkErrorsWithCleanFields();
    }
}
