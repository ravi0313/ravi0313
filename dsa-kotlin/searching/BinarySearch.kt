/**
 * Problem: Binary Search (Iterative)
 * Search for a target value in a sorted array using binary search.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1
    
    while (left <= right) {
        val mid = left + (right - left) / 2
        
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    
    return -1 // Not found
}

fun main() {
    // Test Case 1: Element found
    val arr1 = intArrayOf(2, 3, 4, 10, 40, 50, 60, 70, 80)
    val target1 = 50
    val result1 = binarySearch(arr1, target1)
    println("Test 1: arr = [2, 3, 4, 10, 40, 50, 60, 70, 80], target = 50")
    println("Result: $result1 (index)")
    println("Expected: 5\n")
    
    // Test Case 2: Element not found
    val arr2 = intArrayOf(1, 5, 10, 15, 20, 25, 30)
    val target2 = 12
    val result2 = binarySearch(arr2, target2)
    println("Test 2: arr = [1, 5, 10, 15, 20, 25, 30], target = 12")
    println("Result: $result2")
    println("Expected: -1\n")
    
    // Test Case 3: First element
    val arr3 = intArrayOf(5, 10, 15, 20)
    val target3 = 5
    val result3 = binarySearch(arr3, target3)
    println("Test 3: arr = [5, 10, 15, 20], target = 5")
    println("Result: $result3 (index)")
    println("Expected: 0")
}
