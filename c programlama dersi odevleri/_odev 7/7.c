#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>

int main() {
	srand(time(0));
	setlocale(LC_ALL, "Turkish");
	int i=0, temp, tamSayilar[10];
	
	while (i<10) {
		temp = rand();
		if (temp < 101 && temp % 3 == 0) { 
			tamSayilar[i] = temp;
			i++;
		}
	}

	i=0;
	printf("::: Oluþturulan TAM SAYI dizisi :::\n\n");
	for (;i<10;i++) printf("%d. eleman: %d\n",i+1,tamSayilar[i]);
	
    return 0;
}
