#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {

    // allocate memory for the result
    int* result = (int*)malloc(2*sizeof(int));
    *returnSize = 2;

    // iterate through every possible combination to find the one that adds to the target
    for (int i = 0; i < numsSize; i++) {
        for (int j = i+1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    // if there was no combination found, return NULL
    *returnSize = 0;
    return NULL;
}

void main() {
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    int returnSize;
    int* result = twoSum(nums, 4, target, &returnSize);

    if (result != NULL) {
        printf("Indices: [%d, %d]\n", result[0], result[1]);
        free(result); // Speicher freigeben
    } else {
        printf("No solution found.\n");
    }
}