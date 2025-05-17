// https://leetcode.com/problems/find-eventual-safe-states/

class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val outDegrees = IntArray(n) { 0 }
        val reverseGraph = Array(n) { mutableListOf<Int>() }

        // create reverse graph and count out degrees
        for (i in graph.indices) {
            for (neighbor in graph[i]) {
                reverseGraph[neighbor].add(i)
            }
            outDegrees[i] = graph[i].size
        }

        //  find all the nodes with degree 0
        val queue = ArrayDeque<Int>()
        for (i in outDegrees.indices) {
            if (outDegrees[i] == 0) {
                queue.add(i)
            }
        }

        // use BFS to find all safe nodes
        val result = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            result.add(node)
            for (neighbor in reverseGraph[node]) {
                outDegrees[neighbor]--
                if (outDegrees[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }

        // sort because the result should be in ascending order
        result.sort()
        return result
    }
}

fun main() {
    val obj = Solution()
    val graph = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(5), intArrayOf(0), intArrayOf(5), intArrayOf(), intArrayOf())
    val result = obj.eventualSafeNodes(graph)
    require(result == listOf(2,4,5,6)) { "Expected [2, 4, 5, 6], got $result" }
    println("Test passed")

    val graph2 = arrayOf(intArrayOf(1,2,3,4), intArrayOf(1,2), intArrayOf(3,4), intArrayOf(0, 4), intArrayOf())
    val result2 = obj.eventualSafeNodes(graph2)
    require(result2 == listOf(4)) { "Expected [4], got $result2" }
    println("Test passed")

    val graph3 = arrayOf(intArrayOf(), intArrayOf(0,2,3,4), intArrayOf(3), intArrayOf(4), intArrayOf())
    val result3 = obj.eventualSafeNodes(graph3)
    require(result3 == listOf(0,1,2,3,4)) { "Expected [0, 1, 2, 3, 4], got $result3" }
    println("Test passed")
}