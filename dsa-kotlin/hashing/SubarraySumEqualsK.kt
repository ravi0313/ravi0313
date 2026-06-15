/**
 * Problem: Subarray Sum Equals K
 * Count the total number of subarrays whose sum equals K.
 *
 * Approach: Use prefix sums with a HashMap.
 * Key insight: If prefixSum[j] - prefixSum[i] = k, then subarray (i, j] sums to k.
 * So for each prefix sum, check if (prefixSum - k) exists in the map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

fun subarraySum(nums: IntArray, k: Int): Int {
    val prefixCount = mutableMapOf(0 to 1) // prefixSum 0 seen once (empty subarray)
    var prefixSum = 0
    var count = 0

    for (num in nums) {
        prefixSum += num
        // If (prefixSum - k) exists, subarrays ending here sum to k
        count += prefixCount.getOrDefault(prefixSum - k, 0)
        prefixCount[prefixSum] = prefixCount.getOrDefault(prefixSum, 0) + 1
    }

    return count
}

fun main() {
    // Test Case 1: Multiple subarrays with k=2
    val nums1 = intArrayOf(1, 1, 1)
    val k1 = 2
    println("Test 1: nums = ${nums1.contentToString()}, k = $k1")
    println("Count: ${subarraySum(nums1, k1)}")
    println("Expected: 2  ([1,1] starting at index 0 and index 1)\n")

    // Test Case 2: Negative numbers
    val nums2 = intArrayOf(1, 2, 3, -3, 3)
    val k2 = 3
    println("Test 2: nums = ${nums2.contentToString()}, k = $k2")
    println("Count: ${subarraySum(nums2, k2)}")
    println("Expected: 4\n")

    // Test Case 3: Single element equals k
    val nums3 = intArrayOf(5)
    val k3 = 5
    println("Test 3: nums = ${nums3.contentToString()}, k = $k3")
    println("Count: ${subarraySum(nums3, k3)}")
    println("Expected: 1")
}
