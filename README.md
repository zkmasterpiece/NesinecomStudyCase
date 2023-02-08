# NesinecomStudyCase
• Nesine.com adresine giriş yapılır. ✔

• Kullanıcı adı ve şifre alanları doldurularak, "Giriş" butonuna tıklanır. ✔
  o Kullanıcı adı ve şifrenin pom.xml üzerinden alınması gerekiyor
  
• "Popüler Bahisler" butonuna tıklanır ve sayfa linki kontrol edilir. ✔ 
  ("https://www.nesine.com/iddaa/populer-bahisler")
  
• Futbol tabı seçilir. ✔

• (Post) /Iddaa/GetPopularBets servisi tetiklenerek, sayfada bulunan tüm 
etkinlikler için "Kod" ve "Oynanma" sayılarının doğruluğu kontrol edilir. ❌

    o Request Payload: {"eventType":1,"date":null}
    
    o PlayedCount: Oynanma Sayısı
  
    o MarketNo: Kod 
  
  
• Hesabım butonuna tıklanır ve "Çıkış" işlemi gerçekleştirilir. ✔
