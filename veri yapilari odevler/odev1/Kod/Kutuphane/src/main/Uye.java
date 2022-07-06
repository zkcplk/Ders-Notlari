package main;

/**
 * Kütüphane üyelerini tanımlamak için kullanılan sınıftır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Uye extends Kullanici {

  /**
   * Girilen parametreler ile bir kütüphane üyesi nesnesi aşağıdaki constructor
   * ile oluşturulur.
   *
   * @param id Kütüphane üyesinin txt dosyasına yazılacak id'sidir.
   * @param adSoyad Kütüphane üyesinin adı ve soyadıdır.
   * @param user Kütüphane üyesinin sisteme girerken kullanacağı kullanıcı
   * adıdır.
   * @param pass Kütüphane üyesinin sisteme girerken kullanacağı şifredir.
   */
  public Uye(String id, String adSoyad, String user, String pass) {
    super(id, adSoyad, user, pass, "uye");
  }
}
