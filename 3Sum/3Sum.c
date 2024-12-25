#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {

    // amount of triplets found
    *returnSize = 0;

    // amount of numbers in every triplet (typically 3, sometimes NULL)
    *returnColumnSizes = NULL;

    // sort the array first
    qsort(nums, numsSize, sizeof(int), compare);

    int** result = (int**)malloc(numsSize * numsSize *sizeof(int*));
    *returnColumnSizes = (int*)malloc(numsSize * numsSize * sizeof(int));

    // set the first number
    for (int i = 0; i < numsSize-2; i++) {

        // skip duplicates for the first number
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        int target = -nums[i];
        int left = i + 1, right = numsSize - 1;

        // find the remaining two numbers
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {

                // store the triplet in sorted order
                result[*returnSize] = (int*)malloc(sizeof(int) * 3);
                result[*returnSize][0] = nums[i];
                result[*returnSize][1] = nums[left];
                result[*returnSize][2] = nums[right];
                (*returnColumnSizes)[*returnSize] = 3;
                (*returnSize)++;

                // skip duplicates for the second and third numbers
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;

                // move pointers inward
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    if (*returnSize > 0) {
        return result;
    } else {
        // no triplets found
        free(result);
        free(*returnColumnSizes);
        *returnColumnSizes = NULL;
        return NULL;
    }
}

int main() {
    return 1;
}