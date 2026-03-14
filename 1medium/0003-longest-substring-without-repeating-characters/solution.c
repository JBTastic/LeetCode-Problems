// https://leetcode.com/problems/longest-substring-without-repeating-characters/

#include <stdbool.h>

int lengthOfLongestSubstring(char *s) {

  // Use boolean array instead of hash set for C solution
  bool seen[128] = {false}; // We assume ASCII character set
  int left = 0;
  int maximum = 0;

  // Slide the window
  for (int right = 0; s[right] != '\0'; right++) {
    unsigned char c = s[right];

    // If we see a duplicate, move the left pointer until we remove the
    // duplicate
    while (seen[c]) {
      seen[s[left]] = false;
      left++;
    }

    // Mark the current character as seen and update the maximum length
    seen[c] = true;
    maximum = (maximum > (right - left + 1)) ? maximum : (right - left + 1);
  }

  return maximum;
}