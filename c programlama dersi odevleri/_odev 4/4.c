#include<stdio.h>
#include<locale.h>
#include<math.h>

int main() {
	setlocale(LC_ALL, "Turkish");
	int x1,x2,x3,x4,y1,y2,y3,y4;
	
	printf("x1 deðerini giriniz: ");
	scanf("%d", &x1);
	
	printf("y1 deðerini giriniz: ");
	scanf("%d", &y1);
	
	printf("x2 deðerini giriniz: ");
	scanf("%d", &x2);	
	
	printf("y2 deðerini giriniz: ");
	scanf("%d", &y2);	
	
	printf("x3 deðerini giriniz: ");
	scanf("%d", &x3);	
	
	printf("y3 deðerini giriniz: ");
	scanf("%d", &y3);	
	
	printf("x4 deðerini giriniz: ");
	scanf("%d", &x4);	
	
	printf("y4 deðerini giriniz: ");
	scanf("%d", &y4);
	
	float p1p2 = sqrt(pow(x2-x1,2)+pow(y2-y1,2));
	float p3p4 = sqrt(pow(x4-x3,2)+pow(y4-y3,2));
	float sonuc = p1p2+p3p4;

	printf("\n\nP1-P2 Uzaklýðý: %f\nP3-P4 Uzaklýðý: %f\nÝki Uzaklýðýn Toplamý: %f", p1p2, p3p4, sonuc);
}
