/**
 * Problem: Two Sum
 * Given an array of integers and a target value, find the indices of two numbers
 * that add up to the target. You may assume that each input has exactly one solution.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    
    for (i in nums.indices) {
        val complement = target - nums[i]
        
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        
        map[nums[i]] = i
    }
    
    return intArrayOf()
}

fun main() {
    // Test Case 1
    val nums1 = intArrayOf(2, 7, 11, 15)
    val target1 = 9
    val result1 = twoSum(nums1, target1)
    println("Test 1: nums = [2, 7, 11, 15], target = 9")
    println("Output: [${result1[0]}, ${result1[1]}]")
    println("Expected: [0, 1]\n")
    
    // Test Case 2
    val nums2 = intArrayOf(3, 2, 4)
    val target2 = 6
    val result2 = twoSum(nums2, target2)
    println("Test 2: nums = [3, 2, 4], target = 6")
    println("Output: [${result2[0]}, ${result2[1]}]")
    println("Expected: [1, 2]\n")
    
    // Test Case 3
    val nums3 = intArrayOf(3, 3)
    val target3 = 6
    val result3 = twoSum(nums3, target3)
    println("Test 3: nums = [3, 3], target = 6")
    println("Output: [${result3[0]}, ${result3[1]}]")
    println("Expected: [0, 1]")
}
