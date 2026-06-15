/**
 * Problem: Maximum Subarray (Kadane's Algorithm)
 * Given an integer array, find the contiguous subarray which has the largest sum
 * and return its sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

fun maxSubarray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currentSum = nums[0]
    
    for (i in 1 until nums.size) {
        currentSum = maxOf(nums[i], currentSum + nums[i])
        maxSum = maxOf(maxSum, currentSum)
    }
    
    return maxSum
}

fun main() {
    // Test Case 1
    val nums1 = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val result1 = maxSubarray(nums1)
    println("Test 1: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]")
    println("Output: $result1")
    println("Expected: 6 (subarray [4, -1, 2, 1])\n")
    
    // Test Case 2
    val nums2 = intArrayOf(5, 4, -1, 7, 8)
    val result2 = maxSubarray(nums2)
    println("Test 2: nums = [5, 4, -1, 7, 8]")
    println("Output: $result2")
    println("Expected: 23 (entire array)\n")
    
    // Test Case 3
    val nums3 = intArrayOf(-2, -1, -3)
    val result3 = maxSubarray(nums3)
    println("Test 3: nums = [-2, -1, -3]")
    println("Output: $result3")
    println("Expected: -1 (single element)")
}
