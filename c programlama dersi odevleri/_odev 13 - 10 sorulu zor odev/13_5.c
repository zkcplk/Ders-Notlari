//	Maksimum boyutu 1000 karakterlik bir string (klavyeden girilecektir) 
//	içerisinde istenilen karakterden kaç tane olduðunu bulan C programýný yazýnýz.

#include <stdio.h>
#include <string.h>
#include <locale.h>

void main() {
	setlocale(LC_ALL, "Turkish");
	
	char karakter, string[1000];
	printf("Lütfen max 1000 karakter olacak bir yazý giriniz: ");
	gets(string);
	
	fflush(stdin);
	
	printf("\nLütfen girdiðiniz metinde aranacak olan karakteri giriniz: ");
	scanf("%c", &karakter);
	
	int toplam, len=strlen(string);
	for (int i=0; i<len; i++) if (string[i] == karakter) toplam++;
	
	printf("Girdiðiniz metinde bulunan %c sayýsý: %d", karakter, toplam);
}