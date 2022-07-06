#include <stdio.h>

int main() {
	int gir, elliKurus, yirmiKurus, onKurus, besKurus, ucKurus;
	
	printf("0-100 arasi bir deger giriniz: ");
	scanf("%d",&gir);
	
	if (gir >= 50) {
		elliKurus = gir / 50;
		printf("%d elli kurus\n", elliKurus);
		gir -= elliKurus * 50;
	}
	
	if (gir >= 20) {
		yirmiKurus = gir / 20;
		printf("%d yirmi kurus\n", yirmiKurus);
		gir -= yirmiKurus * 20;
	}
	
	if (gir >= 10) {
		onKurus = gir / 10;
		printf("%d on kurus\n", onKurus);
		gir -= onKurus * 10;
	}
	
	if (gir >= 5) {
		besKurus = gir / 5;
		printf("%d bes kurus\n", besKurus);
		gir -= besKurus * 5;
	}
	
	if (gir >= 3) {
		ucKurus = gir / 3;
		printf("%d uc kurus\n", ucKurus);
		gir -= ucKurus * 3;
	}
	
	if (gir < 3 && gir != 0) printf("%d bir kurus\n", gir);
	
	return 0;
}