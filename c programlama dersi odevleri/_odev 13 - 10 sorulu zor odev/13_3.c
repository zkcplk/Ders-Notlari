//	Girilen 10 adet sayý bir diziye atanacaktýr.
//	Bu dizi divide fonksiyonuna argüment olarak gönderilecektir.
//	Fonksiyon pozitifleri bir diziye, negatifleri baþka bir diziye atayacaktýr. 
//	Bu programýn C kodunu yazýnýz.

#include <stdio.h>
#include <locale.h>
#define BOYUT 10

void divide (int *sayilar, int *negatifler, int *pozitifler, int boyut);
void main() {
	setlocale(LC_ALL, "Turkish");
	int sayilar[BOYUT], temp;
	
	for(int i=0;i<BOYUT;i++) {
		printf(" Lütfen %d. tamsayýyý giriniz: ", (i+1));
		scanf("%d", &temp);
		sayilar[i] = temp;
	}
	
	int pozitifler[BOYUT] = {0,0,0,0,0,0,0,0,0,0};
	int negatifler[BOYUT] = {0,0,0,0,0,0,0,0,0,0};
	
	divide (sayilar, negatifler, pozitifler, BOYUT);

	printf("------------------------------------\n");
	printf(" Girilen sayýlardan POZÝTÝF olanlar: \n");
	for (int x=0;x<BOYUT;x++) if (pozitifler[x] != 0) printf(" %d ", pozitifler[x]);
	
	printf("\n------------------------------------\n");
	printf(" Girilen sayýlardan NEGATÝF olanlar: \n");
	for (int y=0;y<BOYUT;y++) if (negatifler[y] != 0) printf(" %d ", negatifler[y]);
}

void divide (int *sayilar, int *negatifler, int *pozitifler, int boyut) {
	int n=0, p=0;
	for (int i=0;i<boyut;i++) {
		if (*(sayilar + i) < 0) { 
			*(negatifler + n) = *(sayilar + i);
			n++;
		}
		else {
			*(pozitifler + p) = *(sayilar + i);
			p++;
		}
	}
}