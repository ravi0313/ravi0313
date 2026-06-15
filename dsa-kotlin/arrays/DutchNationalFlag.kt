/**
 * Problem: Dutch National Flag (Sort 0s, 1s, 2s)
 * Given an array containing only 0s, 1s, and 2s, sort it in-place in a single pass.
 * Use 3 pointers: low (for 0s), mid (for traversal), high (for 2s).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

fun sortColors(arr: IntArray) {
    var low = 0
    var mid = 0
    var high = arr.size - 1
    
    while (mid <= high) {
        when (arr[mid]) {
            0 -> {
                // Swap with low pointer
                val temp = arr[low]
                arr[low] = arr[mid]
                arr[mid] = temp
                low++
                mid++
            }
            1 -> {
                // Already in correct partition
                mid++
            }
            2 -> {
                // Swap with high pointer
                val temp = arr[high]
                arr[high] = arr[mid]
                arr[mid] = temp
                high--
            }
        }
    }
}

fun main() {
    // Test Case 1: Mixed array
    val arr1 = intArrayOf(2, 0, 2, 1, 1, 0)
    println("Test 1: arr = [2, 0, 2, 1, 1, 0]")
    println("Before: ${arr1.contentToString()}")
    sortColors(arr1)
    println("After:  ${arr1.contentToString()}")
    println("Expected: [0, 0, 1, 1, 2, 2]\n")
    
    // Test Case 2: Already sorted
    val arr2 = intArrayOf(0, 0, 1, 1, 2, 2)
    println("Test 2: arr = [0, 0, 1, 1, 2, 2]")
    println("Before: ${arr2.contentToString()}")
    sortColors(arr2)
    println("After:  ${arr2.contentToString()}")
    println("Expected: [0, 0, 1, 1, 2, 2]\n")
    
    // Test Case 3: Reverse sorted
    val arr3 = intArrayOf(2, 2, 1, 1, 0, 0)
    println("Test 3: arr = [2, 2, 1, 1, 0, 0]")
    println("Before: ${arr3.contentToString()}")
    sortColors(arr3)
    println("After:  ${arr3.contentToString()}")
    println("Expected: [0, 0, 1, 1, 2, 2]")
}
