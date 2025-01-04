class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        x = 0
        for entry in operations:
            if entry == "++X" or entry == "X++" :
                x += 1
            else :
                x -= 1
        return x