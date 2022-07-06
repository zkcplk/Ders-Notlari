package main;

/**
 * Kütüphane personellerini (çalışanlarını) tanımlamak için kullanılan sınıftır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Personel extends Kullanici {

  /**
   * Girilen parametreler ile bir kütüphane personeli nesnesi aşağıdaki
   * constructor ile oluşturulur.
   *
   * @param id Kütüphane personelinin txt dosyasına yazılacak id'sidir.
   * @param adSoyad Kütüphane personelinin adı ve soyadıdır.
   * @param user Kütüphane personelinin sisteme girerken kullanacağı kullanıcı
   * adıdır.
   * @param pass Kütüphane personelinin sisteme girerken kullanacağı şifredir.
   */
  public Personel(String id, String adSoyad, String user, String pass) {
    super(id, adSoyad, user, pass, "personel");
  }
}
