/**
 * Main.
 *
 * Group: Julio Rosario
 *        Jeson Rosario
 *        Ryan Wilson
 *        Lisa D. Smith
 */

#include <stdio.h>
#include <unistd.h>
#include<sys/wait.h>

void produceSequence(int);

int main(){
    
    int n = 0;
    do {
        
        //Get user input
        printf("Enter a number ");
        scanf("%d",&n);
        if(n<1) printf("Input must be a positive number!\n");
        
    }while(n < 1);
    
    if(fork() == 0) {
        produceSequence(n);
    } else {
        wait(0);
    }
    
    return 0;
}

void produceSequence(int n) {
    //Calculate sequence.
    while (n != 1) {
        printf("%d ", n);
        if(n % 2== 0) {
            n = n/2;
        } else {
            n = 3*n + 1;
        }
    }
}
