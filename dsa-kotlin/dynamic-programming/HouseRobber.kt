/**
 * Problem: House Robber
 * You are a robber planning to rob houses along a street. Adjacent houses have security
 * systems that alert each other. Maximize the amount robbed without robbing adjacent houses.
 *
 * Recurrence Relation:
 *   dp[0] = nums[0]
 *   dp[1] = max(nums[0], nums[1])
 *   dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) — optimized to use two variables
 */

fun rob(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]

    var prev2 = nums[0]
    var prev1 = maxOf(nums[0], nums[1])

    for (i in 2 until nums.size) {
        val current = maxOf(prev1, prev2 + nums[i])
        prev2 = prev1
        prev1 = current
    }

    return prev1
}

fun main() {
    // Test Case 1: Classic case
    val nums1 = intArrayOf(1, 2, 3, 1)
    println("Test 1: ${nums1.contentToString()}")
    println("Max Robbed: ${rob(nums1)}")
    println("Expected: 4  (rob house 1 and 3: 1 + 3 = 4)\n")

    // Test Case 2: Higher values not adjacent
    val nums2 = intArrayOf(2, 7, 9, 3, 1)
    println("Test 2: ${nums2.contentToString()}")
    println("Max Robbed: ${rob(nums2)}")
    println("Expected: 12  (rob house 1, 3, 5: 2 + 9 + 1 = 12)\n")

    // Test Case 3: Single house
    val nums3 = intArrayOf(5)
    println("Test 3: ${nums3.contentToString()}")
    println("Max Robbed: ${rob(nums3)}")
    println("Expected: 5")
}
