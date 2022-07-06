package main;

import java.io.File;
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 * Farklı sınıflarda kullanılabilmesi için static olarak oluşturulan ve kullanım
 * kolaylığı sağlayan değişkenlerin tanımlandığı sınıftır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Sabitler {
  public Sabitler() {

  }

  /**
   * Sistemin verilerinin yazılacağı dosyaların dizin değişkenidir.
   */
  public static final File DIZIN = new File("dosyalar");

  /**
   * Kütüphaneden alınan kitapların, listesinin yer aldığı dosyanın, dizin
   * değişkenidir.
   */
  public static final File DOSYA_ALINANLAR = new File("dosyalar/alinanlar.txt");

  /**
   * Kütüphanede bulunan kitapların, listesinin yer aldığı dosyanın, dizin
   * değişkenidir.
   */
  public static final File DOSYA_BULUNANLAR = new File("dosyalar/bulunanlar.txt");

  /**
   * Kütüphane sistemine kayıtlı olan kullanıcıların (üye veya personel),
   * bilgilerinin yer aldığı dosyanın, dizin değişkenidir.
   */
  public static final File DOSYA_KULLANICILAR = new File("dosyalar/kullanicilar.txt");

  /**
   * Kütüphaneden alınan kitapların listesidir.
   */
  public static ArrayList<Kitap> ALINANLAR = new ArrayList<>();

  /**
   * Kütüphanede bulunan (yani alınmamış) kitapların listesidir.
   */
  public static ArrayList<Kitap> BULUNANLAR = new ArrayList<>();

  /**
   * Kütüphane sistemine kayıtlı kullanıcıların (üye veya personel),
   * bilgilerinin yer aldığı listedir.
   */
  public static ArrayList<Kullanici> KULLANICILAR = new ArrayList<>();

  /**
   * Sisteme giriş yapmış olan kullanıcı bilgilerini taşıyan değişkendir.
   */
  public static Kullanici LOGIN_KULLANICI;

  /**
   * Temel arayüz değişkenidir. Bu değişken üzerinde sahne değişimleri
   * yapılarak, farklı arayüzlere geçiş yapılır.
   */
  public static Stage ANA_PENCERE;
}
