//	Radyoaktif elementin kütle (m_0) ve yarýlanma süresi (dt) ve süres (t) bilgisi 
//	fonksiyona gönderilecektir. Ýlgili programýn C kodunu yazýnýz. 
//	(n = t/dt) ve (m=m_0/2^n)

#include <stdio.h>
#include <math.h>
#include <locale.h>

void fonksiyon (double m_0, double dt, double t);

void main() {
	setlocale(LC_ALL, "Turkish");
	
	double m_0, dt, t;
	printf("Lütfen m_0 deðerini giriniz: ");
	scanf("%lf", &m_0);
	
	printf("Lütfen dt deðerini giriniz: ");
	scanf("%lf", &dt);
	
	printf("Lütfen t deðerini giriniz: ");
	scanf("%lf", &t);
	
	fonksiyon (m_0, dt, t);
}

void fonksiyon (double m_0, double dt, double t) { 
	double n = t/dt;
	double m = m_0/pow(2,n);
	printf("Fonksiyon sonucu: %lf", m);
}
