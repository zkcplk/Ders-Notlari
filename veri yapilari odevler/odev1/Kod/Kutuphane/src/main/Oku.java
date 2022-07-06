package main;

import java.io.FileNotFoundException;
import java.util.Scanner;
import static main.Sabitler.ALINANLAR;
import static main.Sabitler.BULUNANLAR;
import static main.Sabitler.DOSYA_ALINANLAR;
import static main.Sabitler.DOSYA_BULUNANLAR;
import static main.Sabitler.DOSYA_KULLANICILAR;
import static main.Sabitler.KULLANICILAR;

/**
 * Txt dosyalarını okuma işlemleri için kullanılan metodların barındırıldığı
 * sınıftır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Oku {
  public Oku() {

  }

  /**
   * Kütüphaneden alınan kitapların yer aldığı DOSYA_ALINANLAR dosyasının
   * okunması için kullanılan metottur.
   *
   * @throws FileNotFoundException Okunacak dosya bulunamazsa, bir istisna
   * fırlatılır.
   */
  public void alinanlar() throws FileNotFoundException {
    Scanner okuyucu = new Scanner(DOSYA_ALINANLAR);
    while (okuyucu.hasNextLine()) {
      String data = okuyucu.nextLine();
      String id = data.split("\t")[0].trim();
      String baslik = data.split("\t")[1].split("\\ - ")[0].trim();
      String yazar = data.split("\t")[1].split("\\ - ")[1].trim();
      ALINANLAR.add(new Kitap(id, baslik, yazar));
    }
  }

  /**
   * Kütüphanede bulunan kitapların yer aldığı DOSYA_BULUNANLAR dosyasının
   * okunması için kullanılan metottur.
   *
   * @throws FileNotFoundException Okunacak dosya bulunamazsa, bir istisna
   * fırlatılır.
   */
  public void bulunanlar() throws FileNotFoundException {
    Scanner okuyucu = new Scanner(DOSYA_BULUNANLAR);
    while (okuyucu.hasNextLine()) {
      String data = okuyucu.nextLine();
      String baslik = data.split("\\ - ")[0].trim();
      String yazar = data.split("\\ - ")[1].trim();
      BULUNANLAR.add(new Kitap(null, baslik, yazar));
    }
  }

  /**
   * Kütüphaneye kayıtlı kullanıcıların (üye veya personel) yer aldığı
   * DOSYA_KULLANICILAR dosyasının okunması için kullanılan metottur.
   *
   * @throws FileNotFoundException Okunacak dosya bulunamazsa, bir istisna
   * fırlatılır.
   */
  public void kullanicilar() throws FileNotFoundException {
    Scanner okuyucu = new Scanner(DOSYA_KULLANICILAR);
    while (okuyucu.hasNextLine()) {
      String data = okuyucu.nextLine();
      String id = data.split("\t")[0].trim();
      String tip = data.split("\t")[1].trim();
      String adSoyad = data.split("\t")[2].split("\\ - ")[0].trim();
      String user = data.split("\t")[2].split("\\ - ")[1].split("\\,")[0].trim();
      String pass = data.split("\t")[2].split("\\ - ")[1].split("\\,")[1].trim();
      KULLANICILAR.add(new Kullanici(id, adSoyad, user, pass, tip));
    }
  }
}
