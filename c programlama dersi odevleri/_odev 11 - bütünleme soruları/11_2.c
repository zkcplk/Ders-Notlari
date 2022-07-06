#include<stdio.h>
#include<locale.h>

int main() {
	int i=0,j=0,matris[5][5],simetrik=1;
	setlocale(LC_ALL,"Turkish");
	
	// Matrise eleman doldurma.
	for (i=0;i<5;i++) {
		printf("\n%d\n",i);
		for (j=0;j<5;j++) {
			printf("%d. satýr, %d. sütun: ",i,j);
			scanf("%d", &matris[i][j]);
		}
	}

	//	Simetrik olma koþulu.
	i=0,j=0;
	for (i=0;i<5;i++) {
		for (j=0;j<5;j++) {
			if (i != j && matris[i][j] != matris[j][i]) {
				simetrik=0; 
				break;
			}
		}
	}
	
	if (simetrik) printf("\n\nMATRÝS SÝMETRÝK!");
	else printf("\n\nMATRÝS SÝMETRÝK DEÐÝL!");
	
	return 0;
}