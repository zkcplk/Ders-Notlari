package main;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import static main.Sabitler.ANA_PENCERE;

/**
 * Ana test sınıfıdır. Bu dosya çalıştırıldığında program başlar.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Main extends Application {

  /**
   * JavaFX UI kullanımı için Application sınıfı miras alındığında start()
   * metodunun override edilmesi gerekir.
   *
   * @param primaryStage Arayüzlerin kullanılacağı ana sahnedir.
   * @throws FileNotFoundException Metod içerisinde yapılan okuma işleminde
   * okunacak dosya bulunamazsa, bir istisna fırlatılır.
   */
  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    ANA_PENCERE = primaryStage;

    Oku oku = new Oku();

    // Kütüphaneden alınan ve kütüphanede bulunan tüm kitapların bilgileri ile
    // tüm kütüphane kullanıcıları bilgileri, txt dosyalarından okunur.
    oku.alinanlar();
    oku.bulunanlar();
    oku.kullanicilar();

    // İlk arayüz (login) gösterilir.
    Arayuzler arayuz = new Arayuzler();
    arayuz.sahneDegistir("login");
  }

  public static void main(String[] args) {
    // Programın başlatıldığı yer!
    launch(args);
  }
}
