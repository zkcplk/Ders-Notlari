package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static main.Sabitler.DIZIN;
import static main.Sabitler.DOSYA_ALINANLAR;
import static main.Sabitler.DOSYA_BULUNANLAR;
import static main.Sabitler.DOSYA_KULLANICILAR;

/**
 * Txt dosyalarına yazma işlemleri için kullanılan metodların barındırıldığı
 * sınıftır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Yaz {
  /**
   * Herhangi bir yazma işlemi gerçekleştirilmeden önce, constructor içerisinde
   * "dosyalar" dizininin varlığı kontrol edilmelidir. Eğer ilgili dizin yoksa,
   * oluşturulur.
   */
  public Yaz() {
    if (!DIZIN.exists()) {
      DIZIN.mkdir();
    }
  }

  /**
   * Kütüphaneden ödünç alınmış olan kitapları, DOSYA_ALINANLAR dosyasına yazmak
   * için kullanılan metottur.
   *
   * @param kitaplar İlgili txt dosyasına yazılacak olan kitapların listesidir.
   * @throws FileNotFoundException Yazılacak dosya yoksa, istisna fırlatılır.
   */
  public void alinanlar(ArrayList<Kitap> kitaplar) throws FileNotFoundException {
    try (PrintWriter output = new PrintWriter(DOSYA_ALINANLAR);) {
      for (Kitap kitap : kitaplar) {
        output.printf("%4s\t%s - %s", kitap.getId(), kitap.getBaslik(), kitap.getYazar());
        output.println();
      }
    }
  }

  /**
   * Kütüphaneden alınmamış ve halihazırda kütüphanede bulunan kitapları,
   * DOSYA_BULUNANLAR dosyasına yazmak için kullanılan metottur.
   *
   * @param kitaplar İlgili txt dosyasına yazılacak olan kitapların listesidir.
   * @throws FileNotFoundException Yazılacak dosya yoksa, istisna fırlatılır.
   */
  public void bulunanlar(ArrayList<Kitap> kitaplar) throws FileNotFoundException {
    try (PrintWriter output = new PrintWriter(DOSYA_BULUNANLAR);) {
      for (Kitap kitap : kitaplar) {
        output.printf("%s - %s", kitap.getBaslik(), kitap.getYazar());
        output.println();
      }
    }
  }

  /**
   * Kütüphane kullanıcılarını, DOSYA_KULLANICILAR dosyasına yazmak için
   * kullanılan metottur.
   *
   * @param kullanicilar İlgili txt dosyasına yazılacak olan kullanıcıların
   * listesidir.
   * @throws FileNotFoundException Yazılacak dosya yoksa, istisna fırlatılır.
   */
  public void kullanicilar(ArrayList<Kullanici> kullanicilar) throws FileNotFoundException {
    try (PrintWriter output = new PrintWriter(DOSYA_KULLANICILAR);) {
      for (Kullanici kullanici : kullanicilar) {
        output.printf(
                "%4s\t%8s\t%s - %s,%s",
                kullanici.getId(),
                kullanici.getTip(),
                kullanici.getAdSoyad(),
                kullanici.getUser(),
                kullanici.getPass()
        );
        output.println();
      }
    }
  }
}
