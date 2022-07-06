package hw3;

/**
 * Soru1'de istenen concatenate işleminin yapılması için kullanılan sınıftır.
 *
 * Soru1: İki bağlantılı listeyi birleştirmek için bir metot yazın. Verilen
 * listeler l1 = (2, 3, 1) ve l2 = (4, 5), concatenate(l1,l2)'den döndükten
 * sonra l1 listesi l1 = (2, 3, 1, 4, 5) olarak değiştirilmelidir.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Soru1 {
  int value;
  Node ilk;
  Node son;

  /**
   * Soru1 nesnelerini oluşturan constructor.
   *
   * Soru1 nesneleri birer TEK YÖNLÜ bağlı listedir. Liste oluşturulurken eleman
   * eklemek için bu constructor kullanılır.
   *
   * @param degerler Bağlı liste oluşturulurken, eleman eklemek için kullanılır.
   * Değerler değişkeni, virgülle ayrılmış çoklu sayılardır.
   */
  public Soru1(int... degerler) {
    ilk = null;
    son = null;

    for (int deger : degerler) {
      sonaEkle(deger);
    }
  }

  /**
   * Bağlı listenin sonuna yeni eleman eklemek için kullanılan metod.
   *
   * @param val Bağlı listenin sonuna eklenecek olan değer.
   */
  public void sonaEkle(int val) {
    Node newNode = new Node(val, null);

    if (ilk == null) {
      ilk = son = newNode;
    } else {
      Node temp = son;
      temp.next = newNode;
      son = newNode;
    }
  }

  /**
   * Bağlı lisete bulunan elemanların listesini konsola yazdıran metod.
   *
   */
  public void listele() {
    Node temp = ilk;

    if (temp != null) {
      while (temp != null) {
        System.out.print(temp.value + " ");
        temp = temp.next;
      }
      System.out.println();
    } else {
      System.out.println("Hata: Bu bağlı liste boş!");
    }
  }

  /**
   * Soru1'de istenen ve iki bağlı listeyi birleştiren metod.
   *
   * @param liste Diğer bağlı listeye eklenecek olan bağlı liste.
   */
  public void concatenate(Soru1 liste) {
    Node temp = liste.ilk;

    if (temp != null) {
      while (temp != null) {
        this.sonaEkle((int) temp.value);
        temp = temp.next;
      }
    }
  }

  /**
   * Bağlı listedeki düğümleri (node) oluşturan Inner Class'tır. Bu sınıf tek
   * yönlü bağlı liste oluşturur.
   */
  class Node {
    Object value;
    Node next;

    /**
     * Tek yönlü bağlı listenin düğümlerini oluşturmak için kullanılan
     * constructor.
     *
     * @param value Düğümdeki değer.
     * @param next Sonraki düğüm.
     */
    public Node(Object value, Node next) {
      this.value = value;
      this.next = next;
    }
  }
}
