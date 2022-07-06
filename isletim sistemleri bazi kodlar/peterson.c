#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdbool.h>

int buffer[5];
int in=0;
int out=0;
bool flag[2];
int turn;

void* produce(){
	do{
		flag[0]=true;
		turn=1;
		while(flag[1]&&turn==1);
		int item=rand();
		buffer[in]=item;
		printf("Produce : %d \n",buffer[in]);
		flag[0]=false;
		in=(in+1)%5;
		sleep(1);
	} while(1);
	
	return NULL;
}

void* consume(){
	int item;

	do{
		flag[1]=true;
		turn=0;
		while(flag[0] && turn==0);
		item=buffer[out];
		out=(out+1)%5;
		printf("Consume : %d\n",item);
		flag[1]=false;
		sleep(1);
	} while(1);
	
	return NULL;
}



int main(){
	pthread_t t1,t2;
	pthread_create(&t1,NULL,produce,NULL);
	pthread_create(&t2,NULL,consume,NULL);
	pthread_join(t1,NULL);
	sleep(1);
	return 0;
}
