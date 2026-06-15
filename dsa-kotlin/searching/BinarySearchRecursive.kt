/**
 * Problem: Binary Search (Recursive)
 * Search for a target value in a sorted array using recursive binary search.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n) due to recursion stack
 */

fun binarySearchRecursive(arr: IntArray, target: Int, left: Int = 0, right: Int = arr.size - 1): Int {
    return when {
        left > right -> -1 // Not found
        else -> {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == target -> mid
                arr[mid] < target -> binarySearchRecursive(arr, target, mid + 1, right)
                else -> binarySearchRecursive(arr, target, left, mid - 1)
            }
        }
    }
}

fun main() {
    // Test Case 1: Element found in middle
    val arr1 = intArrayOf(2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78)
    val target1 = 23
    val result1 = binarySearchRecursive(arr1, target1)
    println("Test 1: arr = [2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78], target = 23")
    println("Result: $result1 (index)")
    println("Expected: 5\n")
    
    // Test Case 2: Element not found
    val arr2 = intArrayOf(1, 3, 5, 7, 9, 11)
    val target2 = 6
    val result2 = binarySearchRecursive(arr2, target2)
    println("Test 2: arr = [1, 3, 5, 7, 9, 11], target = 6")
    println("Result: $result2")
    println("Expected: -1\n")
    
    // Test Case 3: Last element
    val arr3 = intArrayOf(10, 20, 30, 40, 50, 60, 70)
    val target3 = 70
    val result3 = binarySearchRecursive(arr3, target3)
    println("Test 3: arr = [10, 20, 30, 40, 50, 60, 70], target = 70")
    println("Result: $result3 (index)")
    println("Expected: 6")
}
