/**
 * Problem: Longest Increasing Subsequence (LIS)
 * Find the length of the longest strictly increasing subsequence in an array.
 *
 * Approach: Use DP + binary search (patience sorting).
 *   dp[i] = LIS length ending at index i
 *   Use a tails array where tails[i] is the smallest tail of all increasing subsequences of length i+1.
 *
 * Recurrence Relation:
 *   For each num, binary search for its position in tails and replace or extend.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

fun lengthOfLIS(nums: IntArray): Int {
    val tails = mutableListOf<Int>()

    for (num in nums) {
        var lo = 0
        var hi = tails.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (tails[mid] < num) lo = mid + 1 else hi = mid
        }
        if (lo == tails.size) {
            tails.add(num) // Extend LIS
        } else {
            tails[lo] = num // Replace with smaller tail
        }
    }

    return tails.size
}

fun main() {
    // Test Case 1: Standard LIS
    val nums1 = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    println("Test 1: ${nums1.contentToString()}")
    println("LIS Length: ${lengthOfLIS(nums1)}")
    println("Expected: 4  ([2, 3, 7, 101] or [2, 5, 7, 101])\n")

    // Test Case 2: Already sorted
    val nums2 = intArrayOf(0, 1, 2, 3, 4, 5)
    println("Test 2: ${nums2.contentToString()}")
    println("LIS Length: ${lengthOfLIS(nums2)}")
    println("Expected: 6\n")

    // Test Case 3: Descending
    val nums3 = intArrayOf(5, 4, 3, 2, 1)
    println("Test 3: ${nums3.contentToString()}")
    println("LIS Length: ${lengthOfLIS(nums3)}")
    println("Expected: 1 (no increasing subsequence longer than 1)")
}
