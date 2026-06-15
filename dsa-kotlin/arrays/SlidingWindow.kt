/**
 * Problem: Sliding Window Maximum Sum
 * Given an array and an integer k, find the maximum sum of a subarray of size k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

fun maxSumSubarray(arr: IntArray, k: Int): Int {
    var windowSum = 0
    
    // Calculate sum of first window
    for (i in 0 until k) {
        windowSum += arr[i]
    }
    
    var maxSum = windowSum
    
    // Slide the window
    for (i in k until arr.size) {
        windowSum = windowSum - arr[i - k] + arr[i]
        maxSum = maxOf(maxSum, windowSum)
    }
    
    return maxSum
}

fun main() {
    // Test Case 1
    val arr1 = intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20)
    val k1 = 4
    val result1 = maxSumSubarray(arr1, k1)
    println("Test 1: arr = [1, 4, 2, 10, 2, 3, 1, 0, 20], k = 4")
    println("Output: $result1")
    println("Expected: 24 (subarray [2, 10, 2, 3] or [2, 3, 1, 0, 20])\n")
    
    // Test Case 2
    val arr2 = intArrayOf(100, 200, 300, 400)
    val k2 = 2
    val result2 = maxSumSubarray(arr2, k2)
    println("Test 2: arr = [100, 200, 300, 400], k = 2")
    println("Output: $result2")
    println("Expected: 700 (subarray [300, 400])\n")
    
    // Test Case 3
    val arr3 = intArrayOf(1, 2, 3, 4, 5)
    val k3 = 3
    val result3 = maxSumSubarray(arr3, k3)
    println("Test 3: arr = [1, 2, 3, 4, 5], k = 3")
    println("Output: $result3")
    println("Expected: 12 (subarray [3, 4, 5])")
}
