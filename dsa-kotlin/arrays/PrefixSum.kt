/**
 * Problem: Prefix Sum & Range Sum Query
 * Given an array, compute the prefix sum array to efficiently answer range sum queries.
 * A prefix sum at index i is the sum of all elements from index 0 to i.
 *
 * Time Complexity: O(n) for building prefix sum, O(1) for each query
 * Space Complexity: O(n)
 */

fun buildPrefixSum(arr: IntArray): IntArray {
    val prefix = IntArray(arr.size + 1)
    for (i in arr.indices) {
        prefix[i + 1] = prefix[i] + arr[i]
    }
    return prefix
}

fun rangeSum(prefix: IntArray, left: Int, right: Int): Int {
    // Sum of elements from left to right (inclusive)
    return prefix[right + 1] - prefix[left]
}

fun main() {
    // Test Case 1: Basic prefix sum
    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    println("Test 1: arr = [1, 2, 3, 4, 5]")
    val prefix1 = buildPrefixSum(arr1)
    println("Prefix Sum: ${prefix1.contentToString()}")
    println("Expected: [0, 1, 3, 6, 10, 15]")
    
    println("Range Queries:")
    println("Sum[0..2] = ${rangeSum(prefix1, 0, 2)} (Expected: 6)")
    println("Sum[1..3] = ${rangeSum(prefix1, 1, 3)} (Expected: 9)")
    println("Sum[0..4] = ${rangeSum(prefix1, 0, 4)} (Expected: 15)\n")
    
    // Test Case 2: Negative numbers
    val arr2 = intArrayOf(-2, 4, -1, 5, 3)
    println("Test 2: arr = [-2, 4, -1, 5, 3]")
    val prefix2 = buildPrefixSum(arr2)
    println("Prefix Sum: ${prefix2.contentToString()}")
    println("Expected: [0, -2, 2, 1, 6, 9]")
    
    println("Range Queries:")
    println("Sum[0..1] = ${rangeSum(prefix2, 0, 1)} (Expected: 2)")
    println("Sum[2..4] = ${rangeSum(prefix2, 2, 4)} (Expected: 7)\n")
    
    // Test Case 3: Single element
    val arr3 = intArrayOf(10)
    println("Test 3: arr = [10]")
    val prefix3 = buildPrefixSum(arr3)
    println("Prefix Sum: ${prefix3.contentToString()}")
    println("Expected: [0, 10]")
    println("Sum[0..0] = ${rangeSum(prefix3, 0, 0)} (Expected: 10)")
}
