package hw3;

/**
 * Soru3'te istenen işlemleri gerçekleştirmek için kullanılan sınıftır.
 *
 * Soru3: Sıralanmış bir bağlantılı listede medyan değeri döndüren bir metot
 * yazın. Listenin i uzunluğu tek ise, medyan ceil(i/2) üyesidir. Örneğin, girdi
 * olarak (1, 2, 2, 5, 7, 9, 11) listesi verildiğinde, metot 5 değerini
 * döndürmelidir. Listenin uzunluğu çift ise, medyan i'nin ortalamasıdır. i/2 ve
 * (i/2)+1 üye. Böylece sıralı listenin (2, 4, 8, 9) medyanı (4+8)/2'dir. Son
 * olarak, boş bir listenin medyanını 0 olarak tanımlayın.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Soru3 {
  int value;
  Node ilk;

  /**
   * Soru3 nesnelerini oluşturan constructor.
   *
   * Soru3 nesneleri birer TEK YÖNLÜ bağlı listedir. Liste oluşturulurken eleman
   * eklemek için bu constructor kullanılır.
   *
   * @param degerler Bağlı liste oluşturulurken,eleman eklemek için kullanılır.
   * Değerler değişkeni, virgülle ayrıılmış çoklu sayılardır.
   */
  public Soru3(int... degerler) {
    ilk = null;

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
      ilk = newNode;
    } else {
      Node temp = ilk;

      while (temp.next != null) {
        temp = temp.next;
      }

      temp.next = newNode;
    }
  }

  /**
   * Bağlı listenin eleman sayısını döndürmek için kullanılan metod.
   *
   * @return Bağlı listenin toplam eleman sayısını döndürür.
   */
  public int length() {
    if (ilk != null) {
      Node temp = ilk;

      int i = 0;
      while (temp != null) {
        temp = temp.next;
        i++;
      }

      return i;
    }

    return 0;
  }

  /**
   * Bağlı listenin medyan değerini döndüren metod.
   *
   * @return Bağlı listenin medyan değerini döndürür.
   */
  public double medyan() {
    if (ilk != null) {
      Node temp = ilk;
      int len = length();

      if (len % 2 == 0) {
        int i = 1;
        while (temp != null) {
          if (len / 2 == i) {
            return (((int) temp.value + (int) temp.next.value) / 2.0);
          }

          temp = temp.next;
          i++;
        }
      } else {
        int i = 1;
        while (temp != null) {
          temp = temp.next;

          if (Math.ceil(len / 2) == i) {
            return (int) temp.value;
          }

          i++;
        }
      }
    }

    return 0;
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
