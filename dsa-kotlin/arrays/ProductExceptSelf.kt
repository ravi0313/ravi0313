/**
 * Problem: Product of Array Except Self
 * Given an array nums, return an array output where output[i] is the product of all
 * elements except nums[i]. Solve without using division.
 * Use prefix and suffix product approach.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for output array
 */

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)
    
    // Fill result with prefix products (product of all elements to the left)
    result[0] = 1
    for (i in 1 until n) {
        result[i] = result[i - 1] * nums[i - 1]
    }
    
    // Multiply with suffix products (product of all elements to the right)
    var rightProduct = 1
    for (i in n - 1 downTo 0) {
        result[i] *= rightProduct
        rightProduct *= nums[i]
    }
    
    return result
}

fun main() {
    // Test Case 1: General array
    val nums1 = intArrayOf(1, 2, 3, 4)
    println("Test 1: nums = [1, 2, 3, 4]")
    val result1 = productExceptSelf(nums1)
    println("Output: ${result1.contentToString()}")
    println("Expected: [24, 12, 8, 6]")
    println("Explanation:")
    println("  index 0: 2*3*4 = 24")
    println("  index 1: 1*3*4 = 12")
    println("  index 2: 1*2*4 = 8")
    println("  index 3: 1*2*3 = 6\n")
    
    // Test Case 2: Array with 1s
    val nums2 = intArrayOf(1, 1, 1, 1)
    println("Test 2: nums = [1, 1, 1, 1]")
    val result2 = productExceptSelf(nums2)
    println("Output: ${result2.contentToString()}")
    println("Expected: [1, 1, 1, 1]\n")
    
    // Test Case 3: Array with different values
    val nums3 = intArrayOf(2, 3, 4, 5)
    println("Test 3: nums = [2, 3, 4, 5]")
    val result3 = productExceptSelf(nums3)
    println("Output: ${result3.contentToString()}")
    println("Expected: [60, 40, 30, 24]")
    println("Explanation:")
    println("  index 0: 3*4*5 = 60")
    println("  index 1: 2*4*5 = 40")
    println("  index 2: 2*3*5 = 30")
    println("  index 3: 2*3*4 = 24")
}
