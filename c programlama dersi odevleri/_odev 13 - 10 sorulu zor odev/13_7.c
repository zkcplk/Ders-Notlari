//	Klavyeden dizi eleman sayýsý girilecektir. Her bir elemanýn giriþi yapýlacaktýr.
//	Ardýndan istenilen bir eleman, dizi içerisinde aranacak, bulunursa indisi döndürülecek.
//	Aranan eleman dizi içerisinde bulunamazsa, -1 deðeri dönecektir.
//	(Pointer Kullanýlacak)

#include <stdio.h>
#include <locale.h>

void main() {
	setlocale(LC_ALL, "Turkish");
	
	int n;
	printf("Dizi kaç elemanlý olsun?: ");
	scanf("%d", &n);
	printf("---------------------------\n");
	
	int temp, dizi[n];
	for (int i=0;i<n;i++) {
		printf("Lütfen %d. elemaný %d. indisi giriniz: ", (i+1), i);
		scanf("%d", &temp);
		*(dizi + i) = temp;
	}
	
	int ara, sonuc=-1;
	printf("Lütfen dizide aranacak elemaný giriniz: ");
	scanf("%d", &ara);
	
	for (int z=0;z<n;z++) {
		if (*(dizi + z) == ara) {
			sonuc = z;
			break;
		}
	}
	
	printf("Bulunan indis: %d", sonuc);
}
