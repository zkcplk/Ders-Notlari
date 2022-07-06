#include <stdio.h>
#include <locale.h>

int asalmi (int bak);
int topla (int tek, int bak);
int main() {
	int bak,asal,toplam;
	setlocale(LC_ALL,"Turkish");
	
	printf("Lütfen pozitif bir tam sayý giriniz: ");
	scanf("%d",&bak);
	
	if (asalmi(bak)) printf("\nGirilen: %d, ASAL\nTek Sayýlar Toplamý: %d\n", bak, topla (1, bak));
	else printf("\nGirilen: %d, ASAL DEÐÝL\nÇift Sayýlar Toplamý: %d\n", bak, topla (0, bak));
	
	return 0;
}

int asalmi (int bak) {
	int i=2;
	
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

int topla (int tek, int bak) {
	int i=0, toplam=0;
	
	if (tek) { 
		while (i<=bak) { 
			if (i % 2 != 0) toplam += i;
			i++;
		}
	}
	else {
		while (i<=bak) { 
			if (i % 2 == 0) toplam += i;
			i++;
		}
	}
	
	return toplam;
}
