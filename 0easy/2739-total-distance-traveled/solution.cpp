// https://leetcode.com/problems/total-distance-traveled/

#include <iostream>

class Solution
{
public:
    int distanceTraveled(int mainTank, int additionalTank)
    {
        int totalDistance = 0;
        int counter = 0;
        while (mainTank > 0)
        {
            totalDistance += 10;
            counter++;
            mainTank--;
            if (counter == 5 && additionalTank != 0)
            {
                mainTank++;
                additionalTank--;
                counter = 0;
            }
        }
        return totalDistance;
    }
};

int main()
{
    Solution s;

    // Test Case 1
    int result1 = s.distanceTraveled(5, 10);
    std::cout << "Test 1: " << result1 << " (Expected: 60)" << std::endl;

    // Test Case 2
    int result2 = s.distanceTraveled(1, 2);
    std::cout << "Test 2: " << result2 << " (Expected: 10)" << std::endl;

    // Test Case 3
    int result3 = s.distanceTraveled(9, 2);
    std::cout << "Test 3: " << result3 << " (Expected: 110)" << std::endl;

    // Test Case 3
    int result4 = s.distanceTraveled(10, 1);
    std::cout << "Test 4: " << result4 << " (Expected: 110)" << std::endl;

    // Test Case 3
    int result5 = s.distanceTraveled(29, 7);
    std::cout << "Test 5: " << result5 << " (Expected: 360)" << std::endl;

    return 0;
}