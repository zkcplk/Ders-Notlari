//	Klavyeden bir metin girilecektir. 
//	Bu metin içerisinde sadece (A-Z/a-z) karakterlerini tutan, 
//	diðer karakterleri char dizisinden atan C programýný yazýnýz.

#include <stdio.h>
#include <string.h>

void main() {
	char metin[1000];
	printf("Lutfen bir metin giriniz: ");
	gets(metin);
	
	int temp, len=strlen(metin);
	for (int i=0;i<len;i++) {
		temp = (int) metin[i];
		
		if (temp < 65) metin[i] = ' ';
		else if (temp > 90 && temp < 97) metin[i] = ' ';
		else if (temp > 122) metin[i] = ' ';
	}
	
	printf("metnin son hali: %s", metin);
}