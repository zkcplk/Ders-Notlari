package hw3;

/**
 * Ana test sınıfıdır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("--------- SORU 1 ---------");
    // Öncelikle l1 ve l2 bağlı listeleri oluşturulur.
    Soru1 l1 = new Soru1(2, 3, 1);
    l1.listele();
    Soru1 l2 = new Soru1(4, 5);
    l2.listele();

    // l2 listesi, l1 listesine eklenerek, iki bağlı liste birleştirilir.
    l1.concatenate(l2);
    l1.listele();

    System.out.println("--------- SORU 2 ---------");
    // Önce soruda verilen bağlı liste (l3) oluşturulur.
    Soru2 l3 = new Soru2(3, 17, 18, 27);
    l3.listele();

    // Bağlı listeye eklenen sayının büyüklüğüne göre,
    // liste içinde eklendiği yer, arayaEkle() metodu ile düzenlenir.
    l3.arayaEkle(2);
    l3.arayaEkle(22);
    l3.arayaEkle(222);

    // l3 bağlı listesini gezerek;
    // 2, 22 ve 222 sayılarının eklendiği yerleri görebiliriz.
    l3.listele();

    System.out.println("--------- SORU 3 ---------");
    // Toplam eleman sayısı tek sayı olan liste1'in medyan değerinin hesaplanması.
    Soru3 liste1 = new Soru3(1, 2, 2, 5, 7, 9, 11);
    System.out.println("liste1 medyan: " + liste1.medyan());

    // Toplam eleman sayısı çift sayı olan liste2'in medyan değerinin hesaplanması.
    Soru3 liste2 = new Soru3(2, 4, 8, 9);
    System.out.println("liste2 medyan: " + liste2.medyan());

    System.out.println("--------- SORU 4 ---------");
    // Sıralı bir bağlı liste düğümlerini tersine çeviren
    // tersCevir() metodunun uygulanışı.
    Soru4 listy = new Soru4(1, 2, 3);
    // Önce listenin ilk halini görüyoruz.
    listy.listele();

    // tersCevir() metodunu uyguluyoruz.
    listy.tersCevir();
    // listy listesi ters yönde sıralanmış oluyor.
    listy.listele();
  }
}
