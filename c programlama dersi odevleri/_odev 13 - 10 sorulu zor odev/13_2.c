//	Klavyeden girilen iki sayý arasýndaki asal sayýlarý bir diziye atan 
//	ve bu diziyi görüntüleyen C program kodunuzu yazýnýz.


#include <stdio.h>
#include <locale.h>
int asalmi (int bak);
void main() {
	//	Yaþasýn TÜRKÇE!
	setlocale(LC_ALL, "Turkish");
	
	int num1, num2, dizi[1000];
	printf("Lütfen iki sayý giriniz: ");
	scanf("%d %d", &num1, &num2);
	
	int max, min;
	if (num2 > num1) { 
		max = num2;
		min = num1;
	}
	else {
		max = num1;
		min = num2;
	}
	
	int temp=0, j=0;
	for (int i=min; i<max; i++) {
		temp = asalmi(i);
		if (temp) {
			dizi[j] = i;
			j++;
		}
	}
		
	printf("%d ile %d arasýndaki asal sayýlar: \n", min, max);
	for (int z=0; z<j; z++) 
		printf("%d. eleman: %d \n", (z+1), dizi[z]);
}

int asalmi (int bak) {
	int sonuc=1,i=2;
	
	if (bak == 2) return 1;
	else if (bak < 2) return 0;
	else {
		while(i<bak) {
			if (bak % i == 0) return 0;
			i++;
		}
	}
	
	return 1;
}