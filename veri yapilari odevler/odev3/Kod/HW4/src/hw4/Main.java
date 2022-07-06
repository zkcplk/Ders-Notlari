package hw4;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Ana test sınıfıdır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    // Öncelikler MyStack sınıfından nesne oluşturulur.
    MyStack stack = new MyStack();

    // Palindrome kontrolünün yapılacağı txt dosyası tanıtılır.
    File dosya = new File("odev.txt");

    // Palindrome sınıfı çağırılır ve bulunan palindorme'lar listelenir.
    Palindrome palindrome = new Palindrome(dosya, stack);
    palindrome.bulunanlar();
  }
}
