# https://leetcode.com/problems/rotate-image/

class Solution:
    def rotate(self, matrix: list[list[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """

        # To rotate a n*n matrix by 90° clockwise, simply switch the x and y
        # coordinates of each number and then reverse the rows of the matrix

        # print("Input Matrix:\n" + "\n".join(str(row) for row in matrix))
        
        cords = dict() # write each number's coordinates to a dict
        for rowIt, rowValue in enumerate(matrix): # iterable and value
            for numberIt, numberValue in enumerate(rowValue): # iterable and value
                cords |= {(numberIt, rowIt):numberValue}

        # print("Coordinates standard:\n" + "\n".join(f"{k}: {v}" for k, v in cords.items()))


        # switch x and y coordinates
        for key, value in cords.items():
            matrix[key[0]][key[1]] = value

        # print("Matrix with inverted coordinates:\n" + "\n".join(str(row) for row in matrix))


        # reverse the rows
        for row in matrix:
            row = row.reverse()

        # print("Matrix with reversed rows:\n" + "\n".join(str(row) for row in matrix))



def main():
    s = Solution()
    s.rotate([[2,29,20,26,16,28],[12,27,9,25,13,21],[32,33,32,2,28,14],[13,14,32,27,22,26],[33,1,20,7,21,7],[4,24,1,6,32,34]])

if __name__ == "__main__":
    main()
