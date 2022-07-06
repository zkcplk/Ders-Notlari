package main;

/**
 * Kütüphane personeli ve kütüphane üyesi nesnelerinin oluşturulmasında
 * kullanılan üst sınıftır.
 *
 * @author Zeki
 * @version 1.0
 */
public class Kullanici {
  private final String id;
  private final String adSoyad;
  private final String user;
  private final String pass;
  private final String tip;

  /**
   * Girilen parametrelerle kullanici nesnesi aşağıdaki consturctor ile
   * oluşturulur.
   *
   * @param id Kullanıcının tanımlandığı id'dir.
   * @param adSoyad Kullanıcının adı ve soyadıdır.
   * @param user Kullanıcının sisteme girerken kullanacağı kullanıcı adıdır.
   * @param pass Kullanıcının sisteme girerken kullanacağı şifredir.
   * @param tip Kullanıcının tip bilgisidir (üye veya personel).
   */
  public Kullanici(String id, String adSoyad, String user, String pass, String tip) {
    this.id = id;
    this.adSoyad = adSoyad;
    this.user = user;
    this.pass = pass;
    this.tip = tip;
  }

  public String getId() {
    return id;
  }

  public String getAdSoyad() {
    return adSoyad;
  }

  public String getUser() {
    return user;
  }

  public String getPass() {
    return pass;
  }

  public String getTip() {
    return tip;
  }
}
