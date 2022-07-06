#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct ogrenci {
	int no;
	int yas;
	int not;
	char ad[20];
	
	enum Cinsiyet {
		erkek = 0,
		kadin = 1
	} cinsiyet;
	
	enum Sube {
		a1 = 0,
		b1 = 1,
		c1 = 2,
		d1 = 3
	} sube;
};

void main() {
	char devam_et;
	float ortalamalar[4]={0.0};
	int toplamlar[4]={0};
	int adetler[4]={0};
	int minler[4]={100, 100, 100, 100};
	int maxlar[4]={0};
	
	FILE *dosya;
	dosya = fopen("ogrenci.dat", "w");
	if (dosya == NULL) {
		fprintf(stderr, "\nHATA: Dosya olusturma islemi basarisiz!\n");
		exit(1);
	}
	else {
		printf("\nogrenci.dat olusturuldu! program basladi!\n");
		struct ogrenci temp_ogrenci;
		
		do {
			printf("\nogrencinin subesi: (1A=0, 1B=1, 1C=2, 1D=3)?: ");
			scanf("%d", &temp_ogrenci.sube);
			
			printf("ogrencinin numarasi: ");
			scanf("%d", &temp_ogrenci.no);
			
			printf("ogrencinin yasi: ");
			scanf("%d", &temp_ogrenci.yas);
			
			printf("ogrencinin notu: ");
			scanf("%d", &temp_ogrenci.not);
			
			printf("ogrencinin adi: ");
			scanf("%s", &temp_ogrenci.ad);
			
			printf("ogrencinin cinsiyeti (Kadin=1, Erkek=0)?: ");
			scanf("%d", &temp_ogrenci.cinsiyet);
			
			printf("\n");		
			
			fwrite(&temp_ogrenci, sizeof(struct ogrenci), 1, dosya);
			if (fwrite != 0) printf("icerik basarili bir sekilde eklendi !\n");
			else printf("HATA: icerik dosyaya yazilamadi !\n");

			printf("Yeni ogrenci ekleyecek misiniz? (E/e veya H/h)?: ");
			scanf(" %c", &devam_et);
		} while (devam_et=='E'||devam_et=='e');
	}
	
	fclose(dosya);
	printf("Kayit islemleri tamamlandi!\n\n");
	
	//---------------------------------------------------------//
	
	printf("Kayitlar okunuyor... \n");
	struct ogrenci temp;
	dosya = fopen("ogrenci.dat", "r");
	if (dosya == NULL) {
		fprintf(stderr, "\nHATA: Dosya okuma islemi basarisiz!\n");
		exit(1);
	}

	while(fread(&temp, sizeof(struct ogrenci), 1, dosya)) {
		printf ("no:%d, ad:%s, not:%d, yas:%d, cinsiyet:%d, sube:%d\n", temp.no, temp.ad, temp.not, temp.yas, temp.cinsiyet, temp.sube);
		
		if (temp.not) adetler[temp.sube]++;
		if (temp.not > maxlar[temp.sube]) maxlar[temp.sube] = temp.not;
		if (temp.not < minler[temp.sube]) minler[temp.sube] = temp.not;
		toplamlar[temp.sube] += temp.not;
	}

	fclose(dosya);
	printf("Kayitlar okundu!\n\n");
	printf("Istatistikler: \n");
	
	char sube;
	for (int i=0; i<4; i++) {
		if (adetler[i] != 0) { 
			ortalamalar[i] = (float)toplamlar[i]/adetler[i];
			
			if (i == 0) sube = 'A';
			else if (i == 1) sube = 'B';
			else if (i == 2) sube = 'C';
			else sube = 'D';
			
			printf("Sube: 1%c, MaxNot: %d, MinNot: %d, Ort: %.2f\n", sube, maxlar[i], minler[i], ortalamalar[i]);
		}
	}
}

