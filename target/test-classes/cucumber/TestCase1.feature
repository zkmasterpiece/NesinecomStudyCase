@tag
Feature: Test Case 1

  @tag1
  Scenario: First Test
    Given Nesine.com adresine giriş yapılır.
    * Kullanıcı adı ve şifre girilir.
    * Populer Bahisler butonuna tıklanır ve sayfa linki kontrol edilir.
    * Futbol Tabı seçilir.
    * GetPopularBets servisi tetiklenerek, sayfada bulunan tüm etkinlikler için Kod ve Oynanma sayılarının doğruluğu kontrol edilir.
    * Hesabım butonuna tıklanır ve Çıkış işlemi gerçekleştirilir.
    * Browser Kapatılır.
