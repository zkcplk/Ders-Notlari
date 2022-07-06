#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <stdlib.h>
#include <conio.h>

#define MAX_UZUNLUK 32
#define MAX_DERS 100

void basla();
void ders_ekle(int* t, char dersler[][MAX_UZUNLUK], int krediler[], float notlar[]);
void liste(int* t, char dersler[][MAX_UZUNLUK], int krediler[], float notlar[]);

int main() {
	int t=0;
	char devam;
	char dersler[MAX_DERS][MAX_UZUNLUK];
	int krediler[MAX_DERS];
	float notlar[MAX_DERS];
	setlocale(0, "Turkish");
	basla();
	
	do {
		t++;
		fflush(stdin);
		ders_ekle(&t, dersler, krediler, notlar);
		
		printf("\nBaþka ders ekleyecek misiniz? e/h\n");
		scanf(" %c", &devam);
	} while (devam=='e'||devam=='E');
	
	system("cls");
	liste(&t, dersler, krediler, notlar);
	
	getch();
	return 0;
}

void liste(int* t, char dersler[][MAX_UZUNLUK], int krediler[], float notlar[]) {
	int krediToplam = 0;
	float ortalama = 0.0, krediNotToplam = 0.0;
	
	printf("\n---------------------------------\n");
	printf(" %11.11s %11s %6s\n","DERS ADI", "KREDÝ", "NOT");
	printf("---------------------------------\n");
	
	for (int j=1; j<*t+1; j++) {
		krediToplam += krediler[j];
		krediNotToplam += krediler[j] * notlar[j];
		printf(" %11.11s %9d %9.2f\n", dersler[j], krediler[j], notlar[j]);
	}
	
	ortalama = krediNotToplam / krediToplam;
	
	printf("---------------------------------\n\n");
	printf(" %11.11s %11.2f\n", "ORTALAMA", ortalama);
	printf("\n---------------------------------\n");
}

void ders_ekle(int* t, char dersler[][MAX_UZUNLUK], int krediler[], float notlar[]) {
	printf("\nLütfen bir ders ismi giriniz: ");
	gets(dersler[*t]);
	
	printf("* %s dersinin KREDÝSÝ: ", dersler[*t]);
	scanf("%d", &krediler[*t]);

	printf("* %s dersinin NOTU: ", dersler[*t]);
	scanf("%f", &notlar[*t]);
}

void basla() {
	printf("------------------------------------------\n");
	printf("  Not Ortalamasý Hesaplama Programý\n");
	printf("  Kodlayan: Zeki ÇIPLAK\n\n\n");
	printf("  Ders isimlerini, kredi miktarlarýný ve\n  notlarýný girerek baþlayabilirsiniz...\n");
	printf("------------------------------------------\n");
}