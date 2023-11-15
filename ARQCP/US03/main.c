#include <stdio.h>
#include "asm.h"


int main(void) {

    int array[] = {4,3,5,7,9,2,1,6,8,10,12,13};
    int length = 12;  //Number in array
    int read = 0;     //First position in array
    int write = 11;    //First position in vec
    int num = 8;      //Number in new vec
    int vec[num];

    int a = move_num_vec(array,length,&read,&write,num,vec);

      //printf("The value of a is: %d\n", a);
    if (a == 1) {
        printf("Elements copied.\n");
        for (int i = 0; i < num; i++) {
            printf("%d ", vec[i]);
        }
        printf("\n");
    } else {
        printf("Not enough elements to copy.\n");
    }
    return 0;
}
