/**
 * Problem: Linear Search
 * Search for a target value in an array by checking each element sequentially.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

fun linearSearch(arr: IntArray, target: Int): Int {
    for (i in arr.indices) {
        if (arr[i] == target) {
            return i
        }
    }
    return -1 // Not found
}

fun main() {
    // Test Case 1: Element found
    val arr1 = intArrayOf(10, 20, 80, 30, 60, 50, 110, 100, 130, 170)
    val target1 = 50
    val result1 = linearSearch(arr1, target1)
    println("Test 1: arr = [10, 20, 80, 30, 60, 50, 110, 100, 130, 170], target = 50")
    println("Result: $result1 (index)")
    println("Expected: 5\n")
    
    // Test Case 2: Element not found
    val arr2 = intArrayOf(5, 10, 15, 20, 25)
    val target2 = 99
    val result2 = linearSearch(arr2, target2)
    println("Test 2: arr = [5, 10, 15, 20, 25], target = 99")
    println("Result: $result2")
    println("Expected: -1\n")
    
    // Test Case 3: First element
    val arr3 = intArrayOf(100, 200, 300, 400, 500)
    val target3 = 100
    val result3 = linearSearch(arr3, target3)
    println("Test 3: arr = [100, 200, 300, 400, 500], target = 100")
    println("Result: $result3 (index)")
    println("Expected: 0")
}
