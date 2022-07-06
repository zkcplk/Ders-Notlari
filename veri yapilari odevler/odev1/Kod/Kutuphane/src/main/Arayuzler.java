package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import static main.Sabitler.ALINANLAR;
import static main.Sabitler.ANA_PENCERE;
import static main.Sabitler.BULUNANLAR;
import static main.Sabitler.KULLANICILAR;
import static main.Sabitler.LOGIN_KULLANICI;

/**
 * Sistemde kullanılacak tüm arayüzler ile sahne değişimi, uyarı ve ekranın
 * ortalanması metotlarının barındırıldığı sınıftır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class Arayuzler {
  public Arayuzler() {

  }

  /**
   * Program başladığında görünecek olan ilk arayüzdür. Sisteme giriş yapacak
   * kullanıcılar, bu arayüze kullanıcı adı ve şifre girerler. Girilen bilgiler
   * doğruysa, bilgileri giren kullanıcının üyelik tipine göre (üye veya
   * personel), yeni bir arayüze geçiş yapılır.
   *
   * @return GridPane tipinde, Login arayüzünü döndürür.
   */
  public GridPane login() {
    TextField user = new TextField();
    PasswordField pass = new PasswordField();
    Button btn = new Button("Giriş Yap");

    GridPane login = new GridPane();
    login.setPadding(new Insets(25));
    login.setHgap(10);
    login.setVgap(10);
    login.setAlignment(Pos.CENTER);
    login.add(new Label("Kullanıcı: "), 0, 0);
    login.add(user, 1, 0);
    login.add(new Label("Şifre: "), 0, 1);
    login.add(pass, 1, 1);
    login.add(btn, 1, 2);
    GridPane.setHalignment(btn, HPos.RIGHT);

    // Giriş Yap butonuna tıklandığında, yapılan işlemler
    btn.setOnAction(e -> {
      boolean devam = false;

      for (Kullanici kullanici : KULLANICILAR) {
        if (kullanici.getUser().equals(user.getText()) && kullanici.getPass().equals(pass.getText())) {
          LOGIN_KULLANICI = new Kullanici(
                  kullanici.getId(),
                  kullanici.getAdSoyad(),
                  kullanici.getUser(),
                  kullanici.getPass(),
                  kullanici.getTip()
          );

          // Giriş yapan kullanıcıya göre, farklı arayüzler gösterilir.
          if (LOGIN_KULLANICI.getTip().equals("personel")) {
            sahneDegistir("personel");
          } else {
            sahneDegistir("uye");
          }

          devam = true;
          break;
        }
      }

      // Kullanıcı adı veya Şifre yanlış girilirse, yeniden girilmesi istenir.
      if (!devam) {
        uyari("Kullanıcı adı veya şifre yanlış!");
        user.setText("");
        pass.setText("");
        user.requestFocus();
      }
    });

    return login;
  }

  /**
   * Sisteme personel olarak giriş yapıldığında, gözüken yönetim panelidir. Bu
   * panelde "Üye Ekle/Sil", "Kitap Ekle/Sil" ve "Kitap Listesi" şeklinde üç
   * temel buton bulunur. Her bir buton farklı bir arayüze geçişi sağlar.
   *
   * @return VBox tipinde, Personel arayüzünü döndürür.
   */
  public VBox personel() {
    Button btnUyeler = new Button("Üye Ekle/Sil");
    Button btnKitaplar = new Button("Kitap Ekle/Sil");
    Button btnKitapListe = new Button("Kitap Listesi");

    btnUyeler.setPrefSize(100, 35);
    btnKitaplar.setPrefSize(100, 35);
    btnKitapListe.setPrefSize(100, 35);

    VBox personel = new VBox(btnKitapListe, btnKitaplar, btnUyeler);
    personel.setSpacing(20);
    personel.setAlignment(Pos.CENTER);

    // Seçilen personel işlemine göre, yeni bir arayüze geçiş yapılır.
    btnKitapListe.setOnAction(e -> sahneDegistir("kitapListe"));
    btnKitaplar.setOnAction(e -> sahneDegistir("kitapEkleSil"));
    btnUyeler.setOnAction(e -> sahneDegistir("uyeEkleSil"));

    return personel;
  }

  /**
   * Sisteme üye olarak giriş yapıldığında, gözüken yönetim panelidir. Üyeler
   * kütüphaneden kitap ödünç alma ve aldıkları kitabı geri verme haklarına
   * sahiptir. Arayüzde bu haklara dair butonlar bulunur.
   * <p>
   * İki ayrı liste vardır. Soldaki liste, üyenin kütüphaneden aldığı kitapları;
   * sağdaki liste ise, kütüphanede halihazırda bulunan kitapları gösterir. Son
   * olarak "Kaydet !" butonuna basılarak işlemler tamamlanır ve programdan
   * çıkılır.
   *
   * @return BorderPane tipinde, Üye arayüzünü döndürür.
   */
  public BorderPane uye() {
    ListView lvLeft = new ListView<>();
    ListView lvRight = new ListView<>();

    ArrayList<Kitap> tempKitaplar = new ArrayList<>();
    for (Kitap kitap : ALINANLAR) {
      if (LOGIN_KULLANICI.getId().equals(kitap.getId())) {
        lvLeft.getItems().add(kitap.getBaslik() + " - " + kitap.getYazar());
      } else {
        tempKitaplar.add(kitap);
      }
    }

    for (Kitap kitap : BULUNANLAR) {
      lvRight.getItems().add(kitap.getBaslik() + " - " + kitap.getYazar());
    }

    Button btnOduncAl = new Button("<<< Ödünç Al");
    Button btnGeriVer = new Button("Geri Ver >>>");

    Label lbl = new Label("Login Üye: " + LOGIN_KULLANICI.getAdSoyad());
    lbl.setAlignment(Pos.CENTER);
    lbl.setMaxSize(Double.MAX_VALUE, 20);

    Button btnOK = new Button("Kaydet !");
    HBox hb = new HBox(btnOK);
    hb.setAlignment(Pos.CENTER);
    hb.setPadding(new Insets(20, 0, 0, 0));

    btnOduncAl.setPrefSize(100, 35);
    btnGeriVer.setPrefSize(100, 35);
    btnOK.setPrefSize(150, 35);

    VBox butonlar = new VBox(btnOduncAl, btnGeriVer);
    butonlar.setAlignment(Pos.CENTER);
    butonlar.setSpacing(20);

    BorderPane uye = new BorderPane();
    uye.setPadding(new Insets(15));
    uye.setTop(lbl);
    uye.setCenter(butonlar);
    uye.setLeft(lvLeft);
    uye.setRight(lvRight);
    uye.setBottom(hb);

    // Kaydet butonuna basıldığında gerçekleşecek işlemler.
    btnOK.setOnAction(e -> {
      Yaz yaz = new Yaz();

      BULUNANLAR.clear();
      ObservableList itemRight = lvRight.getItems();
      for (int i = 0; i < itemRight.size(); i++) {
        String baslik = itemRight.get(i).toString().split("\\ - ")[0].trim();
        String yazar = itemRight.get(i).toString().split("\\ - ")[1].trim();
        BULUNANLAR.add(new Kitap(null, baslik, yazar));
      }

      try {
        yaz.bulunanlar(BULUNANLAR);
      } catch (FileNotFoundException ex) {
        uyari("uye() -> Bulunanlar yazılamadı: " + ex);
      }

      ALINANLAR.clear();
      ObservableList itemLeft = lvLeft.getItems();
      for (int i = 0; i < itemLeft.size(); i++) {
        String baslik = itemLeft.get(i).toString().split("\\ - ")[0].trim();
        String yazar = itemLeft.get(i).toString().split("\\ - ")[1].trim();
        ALINANLAR.add(new Kitap(LOGIN_KULLANICI.getId(), baslik, yazar));
      }

      for (Kitap kitap : tempKitaplar) {
        ALINANLAR.add(new Kitap(kitap.getId(), kitap.getBaslik(), kitap.getYazar()));
      }

      try {
        yaz.alinanlar(ALINANLAR);
      } catch (FileNotFoundException ex) {
        uyari("uye() -> Alınanlar yazılamadı: " + ex);
      }

      ANA_PENCERE.close();
    });

    // Ödünç Al butonuna basıldığında gerçekleşecek işlemler.
    btnOduncAl.setOnAction(e -> {
      MultipleSelectionModel secilen = lvRight.getSelectionModel();
      if (secilen.getSelectedItem() != null) {
        lvLeft.getItems().add(secilen.getSelectedItem());
        lvRight.getItems().remove(secilen.getSelectedIndex());
      }
    });

    // Geri Ver butonuna basıldığında gerçekleşecek işlemler.
    btnGeriVer.setOnAction(e -> {
      MultipleSelectionModel secilen = lvLeft.getSelectionModel();
      if (secilen.getSelectedItem() != null) {
        lvRight.getItems().add(secilen.getSelectedItem());
        lvLeft.getItems().remove(secilen.getSelectedIndex());
      }
    });

    return uye;
  }

  /**
   * Kütüphane personelinin, kütüphanede bulunan ve kütüphaneden alınmış olan
   * kitapları listeleyebileceği arayüzdür. Hangi kitabı kimin aldığı ve
   * halihazırda kütüphanede alınmamış kitapların hangileri olduğu hakkında
   * bilgi edinilebilir. "Geri dön" butonu ile "personel" arayüzüne geçiş
   * yapılır.
   *
   * @return BorderPane tipinde, Kitap Listesi arayüzünü döndürür.
   */
  public BorderPane kitapListe() {
    ListView lvCenter = new ListView<>();
    Button btnAlinanlar = new Button("Alınan Kitaplar");
    Button btnBulunanlar = new Button("Bulunan Kitaplar");
    Button btnGeri = new Button("Geri dön");

    btnAlinanlar.setPrefSize(120, 35);
    btnBulunanlar.setPrefSize(120, 35);
    btnGeri.setPrefSize(120, 35);

    HBox hb1 = new HBox(50, btnAlinanlar, btnBulunanlar);
    hb1.setAlignment(Pos.CENTER);
    hb1.setPadding(new Insets(0, 0, 20, 0));

    HBox hb2 = new HBox(btnGeri);
    hb2.setAlignment(Pos.CENTER);
    hb2.setPadding(new Insets(20, 0, 0, 0));

    BorderPane kl = new BorderPane();
    kl.setTop(hb1);
    kl.setCenter(lvCenter);
    kl.setBottom(hb2);
    kl.setPadding(new Insets(20));

    btnGeri.setOnAction(e -> sahneDegistir("personel"));

    btnAlinanlar.setOnAction(e -> {
      lvCenter.getItems().clear();

      for (Kitap kitap : ALINANLAR) {
        for (Kullanici kullanici : KULLANICILAR) {
          if (kullanici.getId().equals(kitap.getId())) {
            lvCenter.getItems().add(kullanici.getAdSoyad() + " <<< " + kitap.getBaslik() + " - " + kitap.getYazar());
          }
        }
      }
    });

    btnBulunanlar.setOnAction(e -> {
      lvCenter.getItems().clear();

      for (Kitap kitap : BULUNANLAR) {
        lvCenter.getItems().add(kitap.getBaslik() + " - " + kitap.getYazar());
      }
    });

    return kl;
  }

  /**
   * Kütüphane personelinin, sisteme yeni kitap eklemesi veya var olan bir
   * kitabı kütüphaneden silmesi için kullandığı arayüzdür. Eğer kütüphaneden
   * zaten alınmış bir kitap, kütüphaneden silinirse, alınan kitaplar
   * listesinden de silinmiş olur.
   *
   * @return BorderPane tipinde, Kitap Ekle/Sil arayüzünü döndürür.
   */
  public BorderPane kitapEkleSil() {
    TextField kitapBaslik = new TextField();
    TextField kitapYazar = new TextField();

    Button btnEkle = new Button("Ekle");
    btnEkle.setPrefSize(150, 30);
    GridPane.setHalignment(btnEkle, HPos.RIGHT);

    GridPane gp = new GridPane();
    gp.add(new Label("Başlık: "), 0, 0);
    gp.add(kitapBaslik, 1, 0);
    gp.add(new Label("Yazar: "), 0, 1);
    gp.add(kitapYazar, 1, 1);
    gp.add(btnEkle, 1, 2);
    gp.setAlignment(Pos.TOP_CENTER);
    gp.setHgap(10);
    gp.setVgap(10);

    Button btnSil = new Button("Seçilen Kitabı Sil");
    btnSil.setPrefSize(120, 35);

    ListView kitapListesi = new ListView();
    kitapListesi.setPrefSize(300, 400);

    HBox hb = new HBox(20, gp, kitapListesi, btnSil);

    Label lbl = new Label("Login Personel: " + LOGIN_KULLANICI.getAdSoyad());
    lbl.setAlignment(Pos.CENTER);
    lbl.setMaxSize(Double.MAX_VALUE, 20);
    lbl.setPadding(new Insets(10));

    Button btnGeri = new Button("Geri dön");
    btnGeri.setPrefSize(120, 35);

    HBox hbGeri = new HBox(btnGeri);
    hbGeri.setAlignment(Pos.CENTER);
    hbGeri.setPadding(new Insets(20, 0, 0, 0));

    BorderPane bp = new BorderPane();
    bp.setCenter(hb);
    bp.setTop(lbl);
    bp.setBottom(hbGeri);
    bp.setPadding(new Insets(20));

    kitapListesi.getItems().clear();

    for (Kitap kitap : ALINANLAR) {
      kitapListesi.getItems().add(kitap.getBaslik() + " - " + kitap.getYazar());
    }

    for (Kitap kitap : BULUNANLAR) {
      kitapListesi.getItems().add(kitap.getBaslik() + " - " + kitap.getYazar());
    }

    // Seçilen Kitabı Sil butonuna basıldığında gerçekleşecek işlemler.
    btnSil.setOnAction(e -> {
      MultipleSelectionModel secilen = kitapListesi.getSelectionModel();
      if (secilen.getSelectedItem() != null) {

        Kitap silinenKitap = null;
        for (Kitap kitap : ALINANLAR) {
          if (secilen.getSelectedItem().equals(kitap.getBaslik() + " - " + kitap.getYazar())) {
            silinenKitap = kitap;
          }
        }
        ALINANLAR.remove(silinenKitap);

        silinenKitap = null;
        for (Kitap kitap : BULUNANLAR) {
          if (secilen.getSelectedItem().equals(kitap.getBaslik() + " - " + kitap.getYazar())) {
            silinenKitap = kitap;
          }
        }
        BULUNANLAR.remove(silinenKitap);
        kitapListesi.getItems().remove(secilen.getSelectedIndex());

        Yaz yaz = new Yaz();

        try {
          yaz.bulunanlar(BULUNANLAR);
        } catch (FileNotFoundException ex) {
          uyari("kitapEkleSil() -> Bulunanlar yazılamadı: " + ex);
        }

        try {
          yaz.alinanlar(ALINANLAR);
        } catch (FileNotFoundException ex) {
          uyari("kitapEkleSil() -> Alınanlar yazılamadı: " + ex);
        }
      }
    });

    // Ekle butonuna basıldığında gerçekleşecek işlemler.
    btnEkle.setOnAction(e -> {
      if (!kitapBaslik.getText().equals("") && !kitapYazar.getText().equals("")) {
        Kitap kitap = new Kitap(null, kitapBaslik.getText(), kitapYazar.getText());
        kitapListesi.getItems().add(kitap.getBaslik() + " - " + kitap.getYazar());
        BULUNANLAR.add(kitap);

        kitapBaslik.setText("");
        kitapYazar.setText("");

        Yaz yaz = new Yaz();
        try {
          yaz.bulunanlar(BULUNANLAR);
        } catch (FileNotFoundException ex) {
          uyari("kitapEkleSil() -> Bulunanlar yazılamadı: " + ex);
        }
      } else {
        uyari("Kitap başlığı veya yazar bilgisi boş olmamalıdır!");
      }
    });

    // Geri dön butonuna basıldığında personel arayüzüne geçiş yapılır.
    btnGeri.setOnAction(e -> sahneDegistir("personel"));

    return bp;
  }

  /**
   * Kütüphane personelinin, kütüphane sistemine yeni üye eklemesi veya var olan
   * bir üyeyi silmesi için kullanılan arayüzdür. Silinmek istenen bir üyenin,
   * kütüphaneden aldığı bir kitap varsa, o kitap da kütüphaneden silinmiş olur.
   *
   * @return BorderPane tipinde, Üye Ekle/Sil arayüzünü döndürür.
   */
  public BorderPane uyeEkleSil() {
    TextField uyeAdSoyad = new TextField();
    TextField uyeUser = new TextField();
    TextField uyePass = new TextField();
    CheckBox uyeTip = new CheckBox("Personel olarak ekle");

    Button btnEkle = new Button("Ekle");
    btnEkle.setPrefSize(150, 30);
    GridPane.setHalignment(btnEkle, HPos.RIGHT);

    GridPane gp = new GridPane();
    gp.add(new Label("Ad Soyad:"), 0, 0);
    gp.add(uyeAdSoyad, 1, 0);
    gp.add(new Label("Kullanıcı: "), 0, 1);
    gp.add(uyeUser, 1, 1);
    gp.add(new Label("Şifre: "), 0, 2);
    gp.add(uyePass, 1, 2);
    gp.add(uyeTip, 1, 3);
    gp.add(btnEkle, 1, 4);
    gp.setAlignment(Pos.TOP_CENTER);
    gp.setHgap(10);
    gp.setVgap(10);

    Button btnSil = new Button("Seçilen Üyeyi Sil");
    btnSil.setPrefSize(120, 35);

    ListView uyeListesi = new ListView();
    uyeListesi.setPrefSize(300, 400);

    HBox hb = new HBox(20, gp, uyeListesi, btnSil);

    Label lbl = new Label("Login Personel: " + LOGIN_KULLANICI.getAdSoyad());
    lbl.setAlignment(Pos.CENTER);
    lbl.setMaxSize(Double.MAX_VALUE, 20);
    lbl.setPadding(new Insets(10));

    Button btnGeri = new Button("Geri dön");
    btnGeri.setPrefSize(120, 35);

    HBox hbGeri = new HBox(btnGeri);
    hbGeri.setAlignment(Pos.CENTER);
    hbGeri.setPadding(new Insets(20, 0, 0, 0));

    BorderPane bp = new BorderPane();
    bp.setCenter(hb);
    bp.setTop(lbl);
    bp.setBottom(hbGeri);
    bp.setPadding(new Insets(20));

    for (Kullanici kullanici : KULLANICILAR) {
      uyeListesi.getItems().add(
              kullanici.getId() + ") "
              + kullanici.getAdSoyad()
              + " <<< " + kullanici.getTip() + " >>> "
              + kullanici.getUser() + "," + kullanici.getPass()
      );
    }

    // Seçilen Üyeyi Sil butonuna basıldığında gerçekleşecek işlemler.
    btnSil.setOnAction(e -> {
      MultipleSelectionModel secilen = uyeListesi.getSelectionModel();
      if (secilen.getSelectedItem() != null) {
        String silinenUyeId = secilen.getSelectedItem().toString().split("\\)")[0];

        if (!silinenUyeId.equals(LOGIN_KULLANICI.getId())) {
          Kullanici silinenKullanici = null;
          for (Kullanici kullanici : KULLANICILAR) {
            // 1 numaralı üye asla silinmemelidir!
            if (kullanici.getId().equals(silinenUyeId) && !"1".equals(silinenUyeId)) {
              silinenKullanici = kullanici;
            }

            // Yönetici hesabının silinemeyeceği ile ilgili uyarı.
            if ("1".equals(silinenUyeId)) {
              uyari("Yönetici hesabını silemezsiniz!");
            }
          }

          if (silinenKullanici != null) {
            KULLANICILAR.remove(silinenKullanici);
            uyeListesi.getItems().remove(secilen.getSelectedIndex());
          }

          // Kitap almış bir üye silinirse,
          // veri tutarsızlığı olmaması için iade etmediği kitap da silinmelidir.
          Kitap silinenKitap = null;
          for (Kitap kitap : ALINANLAR) {
            if (silinenUyeId.equals(kitap.getId())) {
              silinenKitap = kitap;
            }
          }
          ALINANLAR.remove(silinenKitap);

          Yaz yaz = new Yaz();
          try {
            yaz.kullanicilar(KULLANICILAR);
          } catch (FileNotFoundException ex) {
            uyari("uyeEkleSil() -> Kullanıcılar yazılamadı: " + ex);
          }

          try {
            yaz.alinanlar(ALINANLAR);
          } catch (FileNotFoundException ex) {
            uyari("uyeEkleSil() -> Alınanlar yazılamadı: " + ex);
          }
        } else {
          uyari("Kendinizi silemezsiniz!");
        }
      }
    });

    // Ekle butonuna basıldığında gerçekleşecek işlemler.
    btnEkle.setOnAction(e -> {
      if (!uyeAdSoyad.getText().equals("")
              && !uyeUser.getText().equals("")
              && !uyePass.getText().equals("")
              && !uyeUser.getText().equals(LOGIN_KULLANICI.getUser())) {

        Kullanici kullanici = new Kullanici(
                "" + (Integer.parseInt(KULLANICILAR.get(KULLANICILAR.size() - 1).getId()) + 1),
                uyeAdSoyad.getText(),
                uyeUser.getText(),
                uyePass.getText(),
                (uyeTip.isSelected() ? "personel" : "uye")
        );

        KULLANICILAR.add(kullanici);
        uyeListesi.getItems().add(
                kullanici.getId() + ") "
                + kullanici.getAdSoyad()
                + " <<< " + kullanici.getTip() + " >>> "
                + kullanici.getUser() + "," + kullanici.getPass()
        );

        Yaz yaz = new Yaz();
        try {
          yaz.kullanicilar(KULLANICILAR);
        } catch (FileNotFoundException ex) {
          uyari("uyeEkleSil() -> Kullanıcılar yazılamadı: " + ex);
        }

        uyeAdSoyad.setText("");
        uyeUser.setText("");
        uyePass.setText("");
      } else {
        uyari("Ad Soyad, Kullanıcı adı ve Şifre bölümleri boş bırakalamaz."
                + "\nAyrıca aynı kullanıcıyı yeniden ekleyemezsiniz!");
      }
    });

    // Geri dön butonuna basıldığında personel arayüzüne geçiş yapılır.
    btnGeri.setOnAction(e -> sahneDegistir("personel"));

    return bp;
  }

  /**
   * Arayüz değişimlerinde, yeni gösterilen arayüzün, her zaman ekranın
   * ortasında gözükmesi için kullanılan metottur.
   */
  public void ekraniOrtala() {
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    ANA_PENCERE.setX((screenBounds.getWidth() - ANA_PENCERE.getWidth()) / 2);
    ANA_PENCERE.setY((screenBounds.getHeight() - ANA_PENCERE.getHeight()) / 2);
  }

  /**
   * Arayüzlerde meydana gelen hatalı kullanımların, ekranda bir uyarı şeklinde
   * gösterilebilmesi için kullanılan metottur.
   *
   * @param mesaj Ekranda gözükmesi istenen uyarı mesajıdır.
   */
  public void uyari(String mesaj) {
    Alert uyar = new Alert(Alert.AlertType.ERROR);
    uyar.setContentText(mesaj);
    uyar.show();
  }

  /**
   * Girilen parametreye göre arayüz değişiminin yapıldığı metottur. "login"
   * arayüzü her kullanıcıya gözükür.
   * <p>
   * Üyeler, sadece "uye" arayüzünü görüntüleyebilir. Personellerin
   * görüntüleyebileceği arayüzler ise; "personel", "kitapListe",
   * "kitapEkleSil", "uyeEkleSil" arayüzleridir.
   *
   * @param sahne 6 farklı arayüz için, 6 farklı değer alabilen değişkendir.
   */
  public void sahneDegistir(String sahne) {
    switch (sahne) {
      case "login":
        ANA_PENCERE.setTitle("Kütüphane Sistemi | Giriş");
        ANA_PENCERE.setScene(new Scene(login(), 320, 180));
        ANA_PENCERE.show();
        break;

      case "uye":
        ANA_PENCERE.setTitle("Kütüphane | Üye Paneli");
        ANA_PENCERE.setScene(new Scene(uye(), 700, 600));
        ekraniOrtala();
        ANA_PENCERE.show();
        break;

      case "personel":
        ANA_PENCERE.setTitle("Kütüphane | Personel Paneli");
        ANA_PENCERE.setScene(new Scene(personel(), 320, 240));
        ekraniOrtala();
        ANA_PENCERE.show();
        break;

      case "kitapListe":
        ANA_PENCERE.setTitle("Kütüphanede bulunan ve Kütüphaneden alınan kitaplar listesi");
        ANA_PENCERE.setScene(new Scene(kitapListe(), 500, 600));
        ekraniOrtala();
        ANA_PENCERE.show();
        break;

      case "kitapEkleSil":
        ANA_PENCERE.setTitle("Kitap ekleme ve silme işlemleri");
        ANA_PENCERE.setScene(new Scene(kitapEkleSil(), 750, 500));
        ekraniOrtala();
        ANA_PENCERE.show();
        break;

      case "uyeEkleSil":
        ANA_PENCERE.setTitle("Kullanıcı ekleme ve silme işlemleri");
        ANA_PENCERE.setScene(new Scene(uyeEkleSil(), 750, 500));
        ekraniOrtala();
        ANA_PENCERE.show();
        break;

      default:
        uyari("sahneDegistir() -> Arayüz değişiminde hata meydana geldi!");
    }
  }
}
