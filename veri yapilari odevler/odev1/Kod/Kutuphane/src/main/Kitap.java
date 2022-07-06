package main;

/**
 * Kütüphane sistemine eklenecek veya silinecek olan Kitap nesnelerinin
 * tanımlandığı sınıftır.
 *
 * @author Zeki
 * @version 1.0
 */
public class Kitap {
  private final String id;
  private final String baslik;
  private final String yazar;

  /**
   * Kitap nesnelerinin oluşturan constructor.
   *
   * @param id Bu tanımlama değişkeni, kitabı değil, kitabı alan üyenin
   * id'sidir. Kütüphanede bulunan kitapların id'leri null olarak belirlenir.
   * @param baslik Kitabın başlığıdır.
   * @param yazar Kitabın yazarıdır.
   */
  public Kitap(String id, String baslik, String yazar) {
    this.id = id;
    this.baslik = baslik;
    this.yazar = yazar;
  }

  public String getId() {
    return id;
  }

  public String getBaslik() {
    return baslik;
  }

  public String getYazar() {
    return yazar;
  }
}
