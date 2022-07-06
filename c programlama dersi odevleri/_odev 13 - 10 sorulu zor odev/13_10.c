#include <stdio.h>
#include <locale.h>

void main() {
  int i,j,n;
  char ch;

  setlocale(LC_ALL, "Turkish");
  
  printf("Lütfen satýr sayýsýný giriniz: ");
  scanf("%d%c",&n,&ch);

  printf("Lütfen sembol giriniz: ");
  ch=getchar();

  for(i=0;i<n;i++) {
    for(j=0;j<n;j++) {
      if (j<n-i) printf("%c",ch);
      else printf(" ");
    }
      
    for(j=0;j<n;j++) {
      if (j<i) printf(" ");
      else printf("%c",ch);
    }

    printf("\n");
  }            
          
  for(i=1;i<=n;i++) {
    for(j=0;j<n;j++) {
      if (j<i) printf("%c",ch);
      else printf(" ");
    }

    for(j=0;j<n;j++) {
      if (j<n-i) printf(" ");
      else printf("%c",ch);
    }

    printf("\n");
  }
}