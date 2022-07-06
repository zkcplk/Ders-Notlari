#include <stdio.h>
#include <string.h>

int main() {
	char girilen[99], yazdir[99] = "", degisken[99] = "";
	
	printf("Girilen String: ");
	scanf("%s", &girilen);
	
	strncat(yazdir, &girilen[0], 1);
	printf("%s\n", yazdir);
	
	size_t len = strlen(girilen);
	for (int i=1; i<len; i++) {
		strncat(degisken, &girilen[i], 1);
		strcat(degisken, yazdir);
		strncat(degisken, &girilen[i], 1);
		
		printf("%s \n", degisken);
		
		strcpy(yazdir, degisken);
		strcpy(degisken, "");
	}
	
	return 0;
}