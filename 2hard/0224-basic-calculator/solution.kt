class Solution {
    fun calculate(s: String): Int {
        val stack = mutableListOf<Int>()
        var result = 0
        var number = 0
        var sign = 1

        for (i in 0 until s.length) {
            val c = s[i]
            when {
                c.isDigit() -> {
                    number = number * 10 + (c - '0')
                }
                c == '+' -> {
                    result += sign * number
                    number = 0
                    sign = 1
                }
                c == '-' -> {
                    result += sign * number
                    number = 0
                    sign = -1
                }
                c == '(' -> {
                    stack.add(result)
                    stack.add(sign)
                    result = 0
                    sign = 1
                }
                c == ')' -> {
                    result += sign * number
                    number = 0
                    result *= stack.removeAt(stack.size - 1)
                    result += stack.removeAt(stack.size - 1)
                }
            }
        }

        if (number != 0) {
            result += sign * number
        }

        return result
    }
}

fun main () {
    val solution = Solution()

    val s1 = "1 + 1"
    val result1 = solution.calculate(s1)

    val s2 = "(1+(4+5+2)-3)+(6+8)"
    val result2 = solution.calculate(s2)

    require(result1 == 2 && result2 == 23) {"Expected 2 and 23, but got ${solution.calculate(s1)} and ${solution.calculate(s2)}"}
    println("Test passed")
}