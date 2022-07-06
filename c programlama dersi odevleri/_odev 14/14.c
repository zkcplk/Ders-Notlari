#include <stdio.h>

void f(int n) {
	printf("Toplam: %d\n", n);
	printf("Bir sayi girin: ");
	
	int girilen;
	scanf("%d", &girilen);
	
	if (girilen == 0) printf("Bitti!");
	else {
		n += girilen;
		f(n);
	}
}

void main() {
	f(3);
}