#include<stdio.h>
#include<locale.h>

void main() {
	int girilen,listede=0,toplam=0;
	int dizi1[10] = {0,0,0,0,0,0,0,0,0,0};
	setlocale(LC_ALL,"Turkish");
	
	for (int i=0;i<10;i++) {
		listede = 0;
		printf("1'den büyük bir tam sayý giriniz: ");
		scanf("%d",&girilen);
		
		if (girilen > 1) {
			for (int j=0;j<10;j++) {
				if (dizi1[j] == girilen) {
					listede = 1;
					break;
				}
			}	
			
			if (listede == 0) { 
				printf("%d eklenecek!\n",girilen);
				dizi1[toplam] = girilen;
				toplam++;
			}
		}
	}
	
	// dizi1 listesi
	printf("\nGirilenlerden kabul edilen toplam eleman sayýsý: %d\n\nEleman listesi:\n",toplam);
	
	int sayToplam=0;
	for (int z=0;z<toplam;z++) {
		printf("%d\n",dizi1[z]);
		sayToplam += dizi1[z];
	}
	
	printf("\nGirilen sayýlarýn toplamý: %d",sayToplam);
		
}