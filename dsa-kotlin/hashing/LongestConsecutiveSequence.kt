/**
 * Problem: Longest Consecutive Sequence
 * Given an unsorted array, find the length of the longest sequence of consecutive integers.
 * Must run in O(n) time.
 *
 * Approach: Insert all numbers in a HashSet. For each number that is the START of a
 * sequence (num - 1 not in set), count how far the sequence extends.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toHashSet()
    var longest = 0

    for (num in numSet) {
        // Only start counting from the beginning of a sequence
        if (num - 1 !in numSet) {
            var currentNum = num
            var streak = 1

            while (currentNum + 1 in numSet) {
                currentNum++
                streak++
            }

            longest = maxOf(longest, streak)
        }
    }

    return longest
}

fun main() {
    // Test Case 1: Multiple sequences
    val nums1 = intArrayOf(100, 4, 200, 1, 3, 2)
    println("Test 1: ${nums1.contentToString()}")
    println("Longest Consecutive: ${longestConsecutive(nums1)}")
    println("Expected: 4  ([1, 2, 3, 4])\n")

    // Test Case 2: Sequence already sorted
    val nums2 = intArrayOf(0, 1, 2, 3, 4, 5)
    println("Test 2: ${nums2.contentToString()}")
    println("Longest Consecutive: ${longestConsecutive(nums2)}")
    println("Expected: 6\n")

    // Test Case 3: No consecutive
    val nums3 = intArrayOf(10, 20, 30, 40)
    println("Test 3: ${nums3.contentToString()}")
    println("Longest Consecutive: ${longestConsecutive(nums3)}")
    println("Expected: 1")
}
