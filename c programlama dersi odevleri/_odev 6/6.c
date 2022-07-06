#include<stdio.h>
#include<locale.h>
#include<string.h>

int main() {
	int toplam;
	char girilen_cumle[100];
	char *parcali, *en_kucuk_kelime;
	setlocale(LC_ALL, "Turkish");
	
	printf("Lütfen bir CÜMLE giriniz: ");
	gets(girilen_cumle);

	parcali = strtok (girilen_cumle, " ");
	toplam = strlen(parcali);
	en_kucuk_kelime = parcali;
	
	//	Döngülü
	int temp;
	while (parcali != NULL)  {
		parcali = strtok (NULL, " ");
		
		//	Bu kýsým önemli
		// 	Döngü içinde strlen() kullanýnca yeniden sorgulama yapmak gerekiyor.
		//	Aksi halde döngüde problem çýkýyor.
		// 	https://stackoverflow.com/questions/20305853/length-of-string-returned-by-strtok
		if (parcali != NULL) temp = strlen(parcali);
		
		if (toplam > temp) { 
			toplam = temp;
			en_kucuk_kelime = parcali;
		}
	}
	
	printf("\nGirilen cümledeki en kýsa ilk kelime: %s", en_kucuk_kelime);
	return 0;
}