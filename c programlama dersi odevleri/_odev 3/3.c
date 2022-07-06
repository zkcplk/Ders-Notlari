#include <stdio.h>
#include <locale.h>
#include <math.h>

int main() {
	float sonuc = 0;
	int temp, sayi, birler, onlar, yuzler, binler, onbinler;
	
	setlocale(LC_ALL,"Turkish");
	printf("Lütfen 5 basamaklý bir sayý giriniz:");
	scanf("%d", &sayi);

	onbinler = sayi / 10000;
	temp = sayi - (onbinler * 10000);
	
	binler = temp / 1000;
	temp = temp - (binler * 1000);
	
	yuzler = temp / 100;
	temp = temp - (yuzler * 100);
	
	onlar = temp / 10;
	temp = temp - (onlar * 10);
	
	birler = sayi % 10;
	
	sonuc = sqrt(onbinler)+sqrt(binler)+sqrt(yuzler)+sqrt(onlar)+sqrt(birler);
	printf("Sonuç: %f", sonuc);
}