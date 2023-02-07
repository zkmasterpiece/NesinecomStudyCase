@tag
Feature: Test Case 1

  @tag2
  Scenario: First Test
    Given Nesine.com adresine giriş yapılır.
    When Kullanıcı adı ve şifre girilir.
    When Populer Bahisler butonuna tıklanır ve sayfa linki kontrol edilir.
    When Futbol Tabı seçilir.
    Then GetPopularBets servisi tetiklenerek, sayfada bulunan tüm etkinlikler için Kod ve Oynanma sayılarının doğruluğu kontrol edilir.
    When Hesabım butonuna tıklanır ve Çıkış işlemi gerçekleştirilir.
    Then Browser Kapatılır.
