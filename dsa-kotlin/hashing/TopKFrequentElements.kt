/**
 * Problem: Top K Frequent Elements
 * Given an integer array, return the k most frequent elements.
 *
 * Approach: Count frequencies with a HashMap, then use bucket sort where
 * bucket index = frequency. Traverse buckets from high to low frequency.
 *
 * Time Complexity: O(n) using bucket sort
 * Space Complexity: O(n)
 */

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    // Count frequencies
    val freqMap = mutableMapOf<Int, Int>()
    for (num in nums) {
        freqMap[num] = freqMap.getOrDefault(num, 0) + 1
    }

    // Bucket sort: index = frequency
    val buckets = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
    for ((num, freq) in freqMap) {
        buckets[freq].add(num)
    }

    // Collect top k elements from highest frequency down
    val result = mutableListOf<Int>()
    for (i in buckets.size - 1 downTo 0) {
        for (num in buckets[i]) {
            result.add(num)
            if (result.size == k) return result.toIntArray()
        }
    }

    return result.toIntArray()
}

fun main() {
    // Test Case 1: Classic frequency
    val nums1 = intArrayOf(1, 1, 1, 2, 2, 3)
    val k1 = 2
    println("Test 1: nums = ${nums1.contentToString()}, k = $k1")
    println("Top $k1 Frequent: ${topKFrequent(nums1, k1).contentToString()}")
    println("Expected: [1, 2]\n")

    // Test Case 2: All same frequency
    val nums2 = intArrayOf(1, 2, 3, 4)
    val k2 = 2
    println("Test 2: nums = ${nums2.contentToString()}, k = $k2")
    println("Top $k2 Frequent: ${topKFrequent(nums2, k2).contentToString()}")
    println("Expected: any 2 elements\n")

    // Test Case 3: Single element
    val nums3 = intArrayOf(5, 5, 5, 5)
    val k3 = 1
    println("Test 3: nums = ${nums3.contentToString()}, k = $k3")
    println("Top $k3 Frequent: ${topKFrequent(nums3, k3).contentToString()}")
    println("Expected: [5]")
}
