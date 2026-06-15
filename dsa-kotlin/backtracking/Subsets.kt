/**
 * Problem: Generate All Subsets (Power Set)
 * Given a set of distinct integers, return all possible subsets (including empty set).
 *
 * Backtracking Approach:
 *   - At each index, decide to include or exclude the element.
 *   - Recurse with the next index. Add current path to results at every call.
 *   - Backtrack by removing the last added element.
 *
 * Recursion Tree: Binary tree of depth N → 2^N leaf nodes (all subsets).
 *
 * Time Complexity: O(N * 2^N)
 * Space Complexity: O(N) recursion depth + O(N * 2^N) for results
 */

fun subsets(nums: IntArray): List<List<Int>> {
    val results = mutableListOf<List<Int>>()
    val current = mutableListOf<Int>()

    fun backtrack(start: Int) {
        results.add(current.toList()) // Every path is a valid subset
        for (i in start until nums.size) {
            current.add(nums[i])
            backtrack(i + 1)
            current.removeLast() // Backtrack
        }
    }

    backtrack(0)
    return results
}

fun main() {
    // Test Case 1: [1, 2, 3]
    val nums1 = intArrayOf(1, 2, 3)
    println("Test 1: ${nums1.contentToString()}")
    val result1 = subsets(nums1)
    println("Count: ${result1.size}")
    println("Expected: 8 (2^3 = 8)")
    result1.sortedBy { it.size }.forEach { println("  $it") }
    println()

    // Test Case 2: [0]
    val nums2 = intArrayOf(0)
    println("Test 2: ${nums2.contentToString()}")
    val result2 = subsets(nums2)
    result2.forEach { println("  $it") }
    println("Expected: [[], [0]]\n")

    // Test Case 3: [1, 2]
    val nums3 = intArrayOf(1, 2)
    println("Test 3: ${nums3.contentToString()}")
    val result3 = subsets(nums3)
    result3.sortedBy { it.size }.forEach { println("  $it") }
    println("Expected: [[], [1], [2], [1, 2]]")
}
