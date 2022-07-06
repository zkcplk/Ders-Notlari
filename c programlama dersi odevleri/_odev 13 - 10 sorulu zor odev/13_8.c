//	Klavyeden girilen 3 basamaklý sayýnýn, 
//	basamak deðerleri toplamýna sahip diðer sayýlarý listeleyen C kodunu yazýnýz.

#include <stdio.h>
#include <locale.h>

void main() {
	setlocale(LC_ALL, "Turkish");
	
	int toplam;
	char sayi[3]; 
	
	printf("Lütfen 3 basamaklý bir sayý giriniz: ");
	scanf("%s", sayi);
	
	for (int i=0;i<3;i++) 
		toplam += sayi[i] - '0';
		
	printf("Girdiðiniz sayýnýn basamak deðerleri toplamý: %d \n", toplam);
	printf("Ayný toplama sahip diðer 3 basamaklý sayýlar: \n");
	
	int temp;
	for (int a=0; a<10; a++) {
		for (int b=0; b<10; b++) {
			for (int c=0; c<10; c++) {
				temp = a + b + c;
				if (temp == toplam && a != 0) printf("* %d%d%d \n", a,b,c);
			}
		}
	}
}