/**
 * Problem: Generate All Permutations
 * Given a list of distinct numbers, return all possible permutations.
 *
 * Backtracking Approach:
 *   - Maintain a current list and a used-set.
 *   - At each step, add an unused number to current. Recurse.
 *   - When current size equals input size, record the permutation.
 *   - Backtrack by removing last added element.
 *
 * Recursion Tree: N choices at level 1, N-1 at level 2, ... → N! leaf nodes.
 *
 * Time Complexity: O(N! * N)
 * Space Complexity: O(N) for current path + O(N!) for result storage
 */

fun permute(nums: IntArray): List<List<Int>> {
    val results = mutableListOf<List<Int>>()
    val current = mutableListOf<Int>()
    val used = BooleanArray(nums.size)

    fun backtrack() {
        if (current.size == nums.size) {
            results.add(current.toList())
            return
        }
        for (i in nums.indices) {
            if (!used[i]) {
                used[i] = true
                current.add(nums[i])
                backtrack()
                current.removeLast() // Backtrack
                used[i] = false
            }
        }
    }

    backtrack()
    return results
}

fun main() {
    // Test Case 1: [1, 2, 3]
    val nums1 = intArrayOf(1, 2, 3)
    println("Test 1: ${nums1.contentToString()}")
    val result1 = permute(nums1)
    println("Count: ${result1.size}")
    println("Expected: 6 (3! = 6)")
    result1.forEach { println("  $it") }
    println()

    // Test Case 2: [0, 1]
    val nums2 = intArrayOf(0, 1)
    println("Test 2: ${nums2.contentToString()}")
    val result2 = permute(nums2)
    println("Count: ${result2.size}")
    result2.forEach { println("  $it") }
    println("Expected: [[0, 1], [1, 0]]\n")

    // Test Case 3: Single element
    val nums3 = intArrayOf(5)
    println("Test 3: ${nums3.contentToString()}")
    val result3 = permute(nums3)
    println("Permutations: $result3")
    println("Expected: [[5]]")
}
