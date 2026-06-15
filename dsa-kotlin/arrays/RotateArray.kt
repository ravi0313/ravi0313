/**
 * Problem: Rotate Array
 * Given an array, rotate it to the right by k steps.
 * Example: [1, 2, 3, 4, 5] rotated by 2 becomes [4, 5, 1, 2, 3]
 * Use array reversal technique for O(1) space.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (not counting output)
 */

fun reverse(arr: IntArray, start: Int, end: Int) {
    var left = start
    var right = end
    
    while (left < right) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left++
        right--
    }
}

fun rotateArray(arr: IntArray, k: Int) {
    val n = arr.size
    val steps = k % n // Handle k > n
    
    if (steps == 0) return
    
    // Step 1: Reverse entire array
    reverse(arr, 0, n - 1)
    
    // Step 2: Reverse first k elements
    reverse(arr, 0, steps - 1)
    
    // Step 3: Reverse remaining elements
    reverse(arr, steps, n - 1)
}

fun main() {
    // Test Case 1: Basic rotation
    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    println("Test 1: arr = [1, 2, 3, 4, 5], k = 2")
    println("Before: ${arr1.contentToString()}")
    rotateArray(arr1, 2)
    println("After:  ${arr1.contentToString()}")
    println("Expected: [4, 5, 1, 2, 3]\n")
    
    // Test Case 2: Rotation larger than array size
    val arr2 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    println("Test 2: arr = [1, 2, 3, 4, 5, 6, 7], k = 10 (10 % 7 = 3)")
    println("Before: ${arr2.contentToString()}")
    rotateArray(arr2, 10)
    println("After:  ${arr2.contentToString()}")
    println("Expected: [5, 6, 7, 1, 2, 3, 4]\n")
    
    // Test Case 3: Rotation by 1
    val arr3 = intArrayOf(99, -1)
    println("Test 3: arr = [99, -1], k = 1")
    println("Before: ${arr3.contentToString()}")
    rotateArray(arr3, 1)
    println("After:  ${arr3.contentToString()}")
    println("Expected: [-1, 99]")
}
