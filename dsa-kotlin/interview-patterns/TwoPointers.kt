/**
 * PATTERN: Two Pointers
 * Use two indices that move toward or away from each other to solve array/string problems in O(n).
 * Replaces O(n²) brute force by eliminating search space based on sorted order or symmetry.
 *
 * Problems solved:
 *   1. Valid Palindrome
 *   2. Container With Most Water
 *   3. 3Sum
 */

// ─── Problem 1: Valid Palindrome ─────────────────────────────────────────────
// Check if a string is a palindrome (alphanumeric only, case-insensitive).
// Pattern: Left pointer at start, right at end — move inward and compare.
// Time: O(n), Space: O(1)

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    while (left < right) {
        while (left < right && !s[left].isLetterOrDigit()) left++
        while (left < right && !s[right].isLetterOrDigit()) right--
        if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false
        left++; right--
    }
    return true
}

// ─── Problem 2: Container With Most Water ────────────────────────────────────
// Given heights, find two lines that together with x-axis forms a container holding most water.
// Pattern: Start from both ends, always move the shorter height inward.
// Time: O(n), Space: O(1)

fun maxWater(heights: IntArray): Int {
    var left = 0
    var right = heights.size - 1
    var maxArea = 0
    while (left < right) {
        val area = minOf(heights[left], heights[right]) * (right - left)
        maxArea = maxOf(maxArea, area)
        if (heights[left] < heights[right]) left++ else right--
    }
    return maxArea
}

// ─── Problem 3: 3Sum ──────────────────────────────────────────────────────────
// Find all unique triplets that sum to zero.
// Pattern: Sort, fix one element, use two pointers for the rest.
// Time: O(n²), Space: O(1) excluding output

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = mutableListOf<List<Int>>()
    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) continue // Skip duplicates
        var left = i + 1
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--
                    left++; right--
                }
                sum < 0 -> left++
                else    -> right--
            }
        }
    }
    return result
}

fun main() {
    println("=== Two Pointers Pattern ===\n")

    println("1. Valid Palindrome")
    println("   \"A man, a plan, a canal: Panama\" → ${isPalindrome("A man, a plan, a canal: Panama")}  Expected: true")
    println("   \"race a car\" → ${isPalindrome("race a car")}  Expected: false\n")

    println("2. Container With Most Water")
    val heights = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println("   heights = ${heights.contentToString()}")
    println("   Max water = ${maxWater(heights)}  Expected: 49\n")

    println("3. 3Sum")
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    println("   nums = ${nums.contentToString()}")
    println("   Triplets = ${threeSum(nums)}")
    println("   Expected: [[-1, -1, 2], [-1, 0, 1]]")
}
