#include <stdio.h>
#include <locale.h>
#include <string.h>
#include <stdlib.h>
#define MAX 1000

void main() {
    FILE *fp;
    char str[MAX], t = ' ';
    char* filename = "C:\\Users\\Zeki\\Desktop\\ogrenci.txt";
	setlocale(LC_ALL,"Turkish");
 
    fp = fopen(filename, "r");
    if (fp == NULL) printf("ogrenci.txt bulunamadý: %s\n",filename);

	printf("No%c | Ýsim %7c | Vize | Final | Ort %3c \n",t,t,t);
	printf("------------------------------------------\n");
	
    while (fgets(str, MAX, fp) != NULL) {
		char *no,*isim,*vize,*final;
		no = strtok(str, ",");
		isim = strtok(NULL, ",");
		vize = strtok(NULL, ",");
		final = strtok(NULL, ",");

		if (isim != NULL && vize != NULL && final != NULL) {
			double ort = atoi(vize) * 0.3 + atoi(final) * 0.7;
			printf("%3s | %12s | %4s | %5s | %.1lf\n",no,isim,vize,final,ort);
		}
	}
        
    fclose(fp);
}