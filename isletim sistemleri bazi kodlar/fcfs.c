#include <stdio.h>
#define PROCESS_SIZE 3

int main() {
	int process[] = {1,2,3};
	int burstTimes[] = {24,3,3};
	int arrivalTimes[] = {0,2,1};
	
	int waitTimes[PROCESS_SIZE];
	int turnAroundTimes[PROCESS_SIZE];
	int completionTimes[PROCESS_SIZE];
	
	for (int i=0; i<PROCESS_SIZE; i++) {
		waitTimes[i] = 0;
		turnAroundTimes[i] = 0;
		completionTimes[i] = 0;
	}
	
	// completion times
	for (int i=0; i<PROCESS_SIZE; i++) {
		for (int j=0; j<=i; j++) {
			completionTimes[i] += burstTimes[j];
		}
	}
	
	// turn around times
	for (int i=0; i<PROCESS_SIZE; i++) {
		turnAroundTimes[i] = completionTimes[i] - arrivalTimes[i];
	}
	
	// wait times
	for (int i=0; i<PROCESS_SIZE; i++) {
		waitTimes[i]  = turnAroundTimes[i] - burstTimes[i];
	}
	
	printf("Process No\t Arrival Time\t Burst Time\t Waiting Time\t TurnAround Time\n");
	
	for (int i=0; i<PROCESS_SIZE; i++) {
		printf("%d\t\t %d\t\t %d\t\t %d\t\t %d\n", process[i], arrivalTimes[i], 
		burstTimes[i], waitTimes[i], turnAroundTimes[i]);
	}
	
	printf("----------------------------------------------\n");
	
	double toplamTurnAround = 0, toplamWaiting = 0;
	for (int i=0; i<PROCESS_SIZE; i++) {
		toplamTurnAround += turnAroundTimes[i];
		toplamWaiting += waitTimes[i];
	}
	
	// ortalama turn around time ve ortalama waiting time
	printf("Ortalama TurnAround Time: %f\n", (toplamTurnAround / PROCESS_SIZE));
	printf("Ortalama Waiting Time: %f", (toplamWaiting / PROCESS_SIZE));
}

