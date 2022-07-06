#include <stdio.h>
#include <math.h>
#include <locale.h>

#define PI 3.14159265

void main() {
	double x, sonuc;
	
	setlocale(LC_ALL,"Turkish");
	printf("Lütfen bir tam sayý giriniz: ");
	scanf("%lf",&x);
	
	if (x>0 && x<50) sonuc = 2*x-(x/4);
	else if (50<=x && x<100) { 
		double val = PI/180;
		sonuc = sin(x*val) + x*x;
	}
	else if (100<=x) {
		for (int i=1;i<=x;i++)
			sonuc += 1/(double)i;
	}
	
	printf("\nSonuç: %lf\n",sonuc);
}