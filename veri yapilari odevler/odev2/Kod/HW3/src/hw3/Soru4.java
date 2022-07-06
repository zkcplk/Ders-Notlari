package hw3;

/**
 * Soru4'te istenen işlemleri gerçekleştirmek için kullanılan sınıftır.
 *
 * Soru4: Bağlantılı bir listedeki düğümleri tersine çeviren bir fonksiyon
 * yazın. Metodun zaman karmaşıklığı O(n) olmalıdır, burada n, listenin
 * uzunluğudur. Yeni düğüm oluşturmamalısınız.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Soru4 {
  int value;
  Node ilk;

  /**
   * Soru4 nesnelerini oluşturan constructor.
   *
   * Soru4 nesneleri birer ÇİFT YÖNLÜ bağlı listedir. Liste oluşturulurken
   * eleman eklemek için bu constructor kullanılır.
   *
   * @param degerler Bağlı liste oluşturulurken,eleman eklemek için kullanılır.
   * Değerler değişkeni, virgülle ayrıılmış çoklu sayılardır.
   */
  public Soru4(int... degerler) {
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
    Node newNode = new Node(val, null, null);

    if (ilk == null) {
      ilk = newNode;
    } else {
      Node temp = ilk;

      while (temp.next != null) {
        temp = temp.next;
      }

      newNode.prev = temp;
      temp.next = newNode;
    }
  }

  /**
   * Sıralı bir Bağlı listenin sıralamasını ters çeviren, O(N) zaman
   * karmaşıklığına sahip olan metod.
   *
   */
  public void tersCevir() {
    Node previous = null;
    Node current = ilk;
    Node following = ilk;

    while (current != null) {
      following = following.next;
      current.next = previous;
      previous = current;
      current = following;
    }

    ilk = previous;
  }

  /**
   * Bağlı listede bulunan elemanların listesini konsola yazdıran metod.
   *
   */
  public void listele() {
    if (ilk != null) {
      Node temp = ilk;

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
   * Bağlı listedeki düğümleri (node) oluşturan Inner Class'tır. Bu sınıf çift
   * yönlü bağlı liste oluşturur.
   */
  class Node {
    Object value;
    Node next;
    Node prev;

    /**
     * Çift yönlü bağlı listenin düğümlerini oluşturmak için kullanılan
     * constructor.
     *
     * @param value Düğümdeki değer.
     * @param next Sonraki düğüm.
     * @param prev Önceki düğüm.
     */
    public Node(Object value, Node next, Node prev) {
      this.value = value;
      this.next = next;
      this.prev = prev;
    }
  }
}
