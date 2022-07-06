package hw3;

/**
 * Soru2'de istenen işlemleri gerçekleştirmek için kullanılan sınıftır.
 *
 * Soru2: Sıralanmış bir bağlantılı listeye bir sayı eklemek için bir metot
 * yazın. Listenin en küçükten en büyüğe doğru sıralandığını varsayalım.
 * Ekledikten sonra, liste hala sıralanmış olmalıdır. L1 = (3, 17, 18, 27)
 * listesi ve 20 değeri verildiğinde, L1'in dönüşünde liste (3, 17, 18, 20, 27)
 * olur.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Soru2 {
  int value;
  Node ilk;

  /**
   * Soru2 nesnelerini oluşturan constructor.
   *
   * Soru2 nesneleri birer ÇİFT YÖNLÜ bağlı listedir. Liste oluşturulurken
   * eleman eklemek için bu constructor kullanılır.
   *
   * @param degerler Bağlı liste oluşturulurken,eleman eklemek için kullanılır.
   * Değerler değişkeni, virgülle ayrıılmış çoklu sayılardır.
   */
  public Soru2(int... degerler) {
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
   * Bağlı listenin başına yeni eleman eklemek için kullanılan metod.
   *
   * @param val Bağlı listenin başına eklenecek olan değer.
   */
  public void basaEkle(int val) {
    Node newNode = new Node(val, null, null);

    if (ilk == null) {
      ilk = newNode;
    } else {
      ilk.prev = newNode;
      newNode.prev = null;
      newNode.next = ilk;
      ilk = newNode;
    }
  }

  /**
   * Bağlı lisete bulunan elemanların listesini konsola yazdıran metod.
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
   * Çift yönlü bağlı listede, -başa veya sona değil- herhangi iki eleman
   * arasına yeni eleman ekleme işlemini yapan metod.
   *
   * @param val İki elaman arasına eklenecek olan değer.
   */
  public void arayaEkle(int val) {
    Node newNode = new Node(val, null, null);

    if (ilk != null) {
      Node temp = ilk;

      // yeni eklenecek değer, listedeki en küçük değerden küçükse.
      if ((int) ilk.value > val) {
        basaEkle(val);
      } else {
        boolean enBuyuk = true;

        while (temp != null) {
          // yeni eklenecek değer, listedeki herhangi iki eleman arasına eklenecekse.
          if ((int) temp.value > val) {
            enBuyuk = false;

            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;

            break;
          }

          temp = temp.next;
        }

        // yeni eklenecek değer, listedeki tüm değerlerden büyükse.
        if (enBuyuk) {
          sonaEkle(val);
        }
      }
    } else {
      System.out.println(""
              + "Hata: Bu metod, boş listeye ekleme yapmak için kullanılmaz! "
              + "Boş listeye ekleme yapmak için sonaEkle(...) metodunu kullanın.");
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
