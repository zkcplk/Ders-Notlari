package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Palindrome tespitinde kullanılan sınıftır. İlgili dosyadan satır satır okuma
 * işlemi yapar, her satırın tek tek palindrome olup olmadığını kontrol eder ve
 * liste olarak sunar.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Palindrome {
  private File dosya;
  private MyStack stack;
  private ArrayList<String> palindromeListesi;

  /**
   * Palindrome nesnelerini oluşturmak için kullanılan constructor.
   *
   * @param dosya palindrome'ların aranacağı File veri tipinde txt dosyası.
   * @param stack palindrome tespitinde kullanılacak stack veri yapısı.
   */
  public Palindrome(File dosya, MyStack stack) {
    this.dosya = dosya;
    this.stack = stack;

    palindromeListesi = new ArrayList<>();
  }

  /**
   * Verilen txt dosyasında bulunan palindrome'ları liste halinde konsola
   * yazdoran metottur.
   *
   * @throws FileNotFoundException istisnası fırlatabilir.
   */
  public void bulunanlar() throws FileNotFoundException {
    oku();

    System.out.println("------------------------------");
    System.out.println("odev.txt içerisinde bulunan palindrome'lar: ");
    System.out.println("------------------------------");

    for (String palindrome : palindromeListesi) {
      System.out.println("* " + palindrome);
    }

    System.out.println("------------------------------");
  }

  /**
   * Verilen bir string ifadenin palindrome olup olmadığını kontrol eden
   * metottur.
   *
   * @param str palindorme olup olmadığı kontrol edilecek string ifade.
   * @return palindorme olduğunu tespit ederse true, aksi halde false döndürür.
   */
  private boolean palindromMu(String str) {
    int len = str.length();

    int i, ortasi = len / 2;
    for (i = 0; i < ortasi; i++) {
      stack.push(str.charAt(i));
    }

    if (len % 2 != 0) {
      i++;
    }

    while (i < len) {
      char harf = stack.pop();
      if (harf != str.charAt(i)) {
        return false;
      }

      i++;
    }

    return true;
  }

  /**
   * Verilen txt dosyasından satır satır okuma işlemi yapan ve okunan her bir
   * satırın palindrome olup olmadığını kontrol eden metottur.
   *
   * @throws FileNotFoundException istisnası fırlatabilir.
   */
  private void oku() throws FileNotFoundException {
    Scanner okuyucu = new Scanner(dosya);
    while (okuyucu.hasNextLine()) {
      String data = okuyucu.nextLine();
      String temp = temizle(data);

      if (palindromMu(temp)) {
        palindromeListesi.add(data);
      }
    }
  }

  /**
   * Kontrolü yapılacak string ifadeleri, harf harici gereksiz karakterlerden
   * arındıran metottur.
   *
   * @param str temizlenecek string ifade.
   * @return temizlenen string ifadeyi döndürür.
   */
  private String temizle(String str) {
    return str.replaceAll("[^a-zA-ZçğıöşüÇĞİÖŞÜ]", "").toLowerCase();
  }
}
