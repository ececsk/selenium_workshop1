package org.etiya;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
10 adet selenium hazır fonksiyonu kullanım örneği ve örneklerin üzerinde fonksiyonun işlevinin
anlatıldığı yorum satırını içeren kodları yazınız.
*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //ChromeDriver(): Chrome tarayıcısını başlatmak için kullanılan WebDriver'ın ChromeDriver sınıfının bir örneğini oluşturur.
        WebDriver webdriver = new ChromeDriver();
        // navigate().to(): Belirtilen URL'ye gitmek için kullanılır.
        webdriver.navigate().to("https://www.saucedemo.com/v1/");
        //getTitle(): Bulunulan sayfanın başlığını almak için kullanılır.
        String title = webdriver.getTitle();
        System.out.println(title);

        //findElement(By.id()): Belirtilen ID'ye sahip bir elementi bulmak için kullanılır.
        WebElement input = webdriver.findElement(By.id("user-name"));
        //sendKeys(): Bir HTML öğesine metin girmek için kullanılır.
        input.sendKeys("deneme");
        //Thread.sleep(): Belirli bir süre beklemek için kullanılır.
        Thread.sleep(1000);
        //clear(): Bir HTML öğesinin içeriğini temizlemek için kullanılır.
        input.clear(); //girilen inputu siler.
        input.sendKeys("standard_user"); //text alanına yazma
        Thread.sleep(1000);

        WebElement passwordinput = webdriver.findElement(By.id("password"));
        passwordinput.sendKeys("secret_sauce");
        Thread.sleep(1000);


        WebElement loginBtn = webdriver.findElement(By.id("login-button"));
        //click(): Bir HTML öğesine tıklamak için kullanılır.
        loginBtn.click();
        Thread.sleep(1000);


       // Hata mesajını kontrol etme

       //getText(): Bir HTML öğesinin metin içeriğini almak için kullanılır.
       //isDisplayed(): Bir HTML öğesinin görünürlüğünü kontrol etmek için kullanılır.

/*        WebElement errorElement = webdriver.findElement(By.xpath("//h3[@data-test='error']")); //XPath ile bir hata mesajı gösterilen alanı bul
        if (errorElement.isDisplayed()) //hata mesajını içeren alanın görünürlüğünü kontrol eder
        {
            System.out.println("Giriş yapılamadı. Karşılaşılan Hata mesajı: " + errorElement.getText()); //hata mesajındaki metni almak için getText kullanıldı.
        } else {
            System.out.println("Giriş başarılı!"); //username ve password doğru bir şekilde girilmişse
        }
*/
        WebElement errorElement;
        try {
            errorElement = webdriver.findElement(By.xpath("//h3[@data-test='error']"));
            if (errorElement.isDisplayed()) {
                System.out.println("Giriş yapılamadı. Karşılaşılan Hata mesajı: " + errorElement.getText());
            }
        } catch (NoSuchElementException e) {
            System.out.println("Giriş başarılı!");
        }

        //Giriş yapıldıktan sonra

        //refresh();mevcut sayfayı yenilemek için kullanılır
        webdriver.navigate().refresh();
        WebElement menuButton = webdriver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
        menuButton.click();
        Thread.sleep(1000);

        WebElement about_menu_item = webdriver.findElement(By.id("about_sidebar_link")); //menudeki about itemını id ile bulma
        about_menu_item.click(); // açılan menüden abouta tıklanır


        //getCurrentUrl(): Geçerli sayfanın URL'sini almak için kullanılır.
        String aboutpageurl = webdriver.getCurrentUrl();
        System.out.println("About sayfasının urlsi: " + aboutpageurl);
        //navigate().back(): Bir sayfa geri gitmek için kullanılır.
        webdriver.navigate().back();


        Thread.sleep(5000); //5 saniye bekle
        //quit(): Tarayıcıyı kapatmak için kullanılır.
        webdriver.quit();

    }
}