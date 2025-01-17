// https://leetcode.com/problems/neighboring-bitwise-xor/description/?envType=daily-question&envId=2025-01-17

#include <stdbool.h>

bool doesValidArrayExist(int* derived, int derivedSize) {
    int xor = 0;

    // xor all elements from derived
    for (int i = 0; i < derivedSize; i++) {
        xor = xor ^ derived[i];
    }

    // if xor is 0, return 1 (true)
    // else return 0 (false)
    return !xor;
}