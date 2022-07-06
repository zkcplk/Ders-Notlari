#include <stdio.h>
#include <math.h>

int main() {
	int i=1;
	float toplam=0;
	
	for (;i<102;i+=2) 
		toplam += sqrt(i);
	
	printf("Toplam: %f\n",toplam);
	return 0;
}