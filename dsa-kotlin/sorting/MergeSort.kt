/**
 * Problem: Merge Sort
 * Sort an array using merge sort algorithm (divide and conquer).
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) return arr
    
    val mid = arr.size / 2
    val left = arr.sliceArray(0 until mid)
    val right = arr.sliceArray(mid until arr.size)
    
    val sortedLeft = mergeSort(left)
    val sortedRight = mergeSort(right)
    
    return merge(sortedLeft, sortedRight)
}

fun merge(left: IntArray, right: IntArray): IntArray {
    val result = IntArray(left.size + right.size)
    var i = 0
    var j = 0
    var k = 0
    
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result[k++] = left[i++]
        } else {
            result[k++] = right[j++]
        }
    }
    
    while (i < left.size) {
        result[k++] = left[i++]
    }
    
    while (j < right.size) {
        result[k++] = right[j++]
    }
    
    return result
}

fun main() {
    // Test Case 1
    val arr1 = intArrayOf(38, 27, 43, 3, 9, 82, 10)
    println("Test 1:")
    println("Before: ${arr1.contentToString()}")
    val sorted1 = mergeSort(arr1)
    println("After:  ${sorted1.contentToString()}")
    println("Expected: [3, 9, 10, 27, 38, 43, 82]\n")
    
    // Test Case 2
    val arr2 = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    println("Test 2:")
    println("Before: ${arr2.contentToString()}")
    val sorted2 = mergeSort(arr2)
    println("After:  ${sorted2.contentToString()}")
    println("Expected: [11, 12, 22, 25, 34, 64, 90]\n")
    
    // Test Case 3
    val arr3 = intArrayOf(5, 1, 3)
    println("Test 3:")
    println("Before: ${arr3.contentToString()}")
    val sorted3 = mergeSort(arr3)
    println("After:  ${sorted3.contentToString()}")
    println("Expected: [1, 3, 5]")
}
