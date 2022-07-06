#include<stdio.h>
#include<locale.h>

int main() {
	setlocale(LC_ALL, "Turkish");
	
	printf("BAÞLA!\n\n");
	
	int n=8, m=0, y=1;
	
	while (m != n) {
		m = m + 2;
		y = y * m;
	}
	
	printf("m: %d, n: %d, y: %d\n\n", m, n, y);

	printf("BÝTÝÞ!");
}
