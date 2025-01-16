// https://leetcode.com/problems/bitwise-xor-of-all-pairings/?envType=daily-question&envId=2025-01-16

int xorAllNums(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int x1 = 0;
    int x2 =0;

    if (nums1Size %2!=0){
        for (int i=0; i<nums2Size; i++){
            x2 = x2 ^ nums2[i];
        }
    }

    if (nums2Size %2!=0){
        for (int i=0; i<nums1Size; i++){
            x1 = x1 ^ nums1[i];
        }
    }
    return x1^x2;
}