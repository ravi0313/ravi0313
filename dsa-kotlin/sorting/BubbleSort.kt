/**
 * Problem: Bubble Sort
 * Sort an array using bubble sort algorithm.
 *
 * Best Case: O(n), Average: O(n²), Worst Case: O(n²)
 * Space Complexity: O(1)
 */

fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n) {
        var swapped = false
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                // Swap
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }
        // If no swaps occurred, array is sorted
        if (!swapped) break
    }
}

fun main() {
    // Test Case 1
    val arr1 = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    println("Test 1:")
    println("Before: ${arr1.contentToString()}")
    bubbleSort(arr1)
    println("After:  ${arr1.contentToString()}")
    println("Expected: [11, 12, 22, 25, 34, 64, 90]\n")
    
    // Test Case 2
    val arr2 = intArrayOf(5, 2, 8, 1, 9)
    println("Test 2:")
    println("Before: ${arr2.contentToString()}")
    bubbleSort(arr2)
    println("After:  ${arr2.contentToString()}")
    println("Expected: [1, 2, 5, 8, 9]\n")
    
    // Test Case 3
    val arr3 = intArrayOf(3)
    println("Test 3:")
    println("Before: ${arr3.contentToString()}")
    bubbleSort(arr3)
    println("After:  ${arr3.contentToString()}")
    println("Expected: [3]")
}
