// https://leetcode.com/problems/reverse-bits/

#include <stdbool.h>

int reverseBits(int n) {
  int result = 0;
  for (int i = 0; i < 31; i++) {
    bool smallest = n & 1; // take rightmost bit of n
    result += smallest;    // add it to result
    result <<= 1; // shift result 1 to left to make space for the next bit
    n >>= 1; // shift n 1 to right to get the next bit in the next iteration
  }
  return result;
}