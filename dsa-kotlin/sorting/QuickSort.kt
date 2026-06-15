/**
 * Problem: Quick Sort
 * Sort an array using quick sort algorithm (pivot-based partitioning).
 *
 * Best/Average: O(n log n), Worst Case: O(n²)
 * Space Complexity: O(log n)
 */

fun quickSort(arr: IntArray, low: Int = 0, high: Int = arr.size - 1) {
    if (low < high) {
        val pi = partition(arr, low, high)
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    
    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
    
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp
    
    return i + 1
}

fun main() {
    // Test Case 1
    val arr1 = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    println("Test 1:")
    println("Before: ${arr1.contentToString()}")
    quickSort(arr1)
    println("After:  ${arr1.contentToString()}")
    println("Expected: [11, 12, 22, 25, 34, 64, 90]\n")
    
    // Test Case 2
    val arr2 = intArrayOf(10, 7, 8, 9, 1, 5)
    println("Test 2:")
    println("Before: ${arr2.contentToString()}")
    quickSort(arr2)
    println("After:  ${arr2.contentToString()}")
    println("Expected: [1, 5, 7, 8, 9, 10]\n")
    
    // Test Case 3
    val arr3 = intArrayOf(3, 2, 1)
    println("Test 3:")
    println("Before: ${arr3.contentToString()}")
    quickSort(arr3)
    println("After:  ${arr3.contentToString()}")
    println("Expected: [1, 2, 3]")
}
