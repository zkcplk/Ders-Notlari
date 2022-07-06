#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#include <unistd.h>
#include <stdio.h>

sem_t chopstick[5];

void eat(int n);
void * philos(void *);

int main(){

	int i, n[5];
	pthread_t T[5];
	
	for(i =0;i<5;i++){
		sem_init(&chopstick[i],0,1);	
	}
	
	for(i=0;i<5;i++){
		n[i]=i;
		pthread_create(&T[i],NULL,philos,(void *)&n[i]);
	}
	
	for (i=0;i<5;i++){
		pthread_join(T[i],NULL);
	}
}

void *philos(void *n){
	int ph =*(int *)n;
	printf("Filozof %d yemek istiyor.\n",ph);
	printf("Filozof %d solundaki çubuğu almak istiyor.\n",ph);
	sem_wait(&chopstick[ph]);
	printf("Filozof %d solundaki çubuğu aldı\n",ph);
	printf("Filozof %d sağındaki çubuğu almak istiyor.\n",ph);
	sem_wait(&chopstick[(ph+1)%5]);
	printf("Filozof %d sağındaki çubuğu aldı \n",ph);
	eat(ph);
	sleep(2);
	printf("Filozof %d yemeğini bitirdi.\n",ph);
	printf("Filozof %d sağındaki çubuğu bıraktı.\n",ph);
	sem_post(&chopstick[(ph+1)%5]);
	printf("Filozof %d solundaki çubuğu bıraktı.\n",ph);
	sem_post(&chopstick[ph]);
}

void eat(int n){
	printf("Filozof %d yemek yedi.\n",n);
}
