/**
 * Problem: Subset Sum
 * Determine if there is a subset of the given array with sum equal to the target.
 *
 * Recurrence Relation:
 *   dp[i][j] = dp[i-1][j]                            if arr[i] > j  (can't include)
 *   dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i]]    otherwise
 *
 * Time Complexity: O(n * sum)
 * Space Complexity: O(n * sum)
 */

fun subsetSum(arr: IntArray, target: Int): Boolean {
    val n = arr.size
    val dp = Array(n + 1) { BooleanArray(target + 1) }

    // Empty subset sums to 0
    for (i in 0..n) dp[i][0] = true

    for (i in 1..n) {
        for (j in 1..target) {
            dp[i][j] = if (arr[i - 1] > j) {
                dp[i - 1][j] // Can't include current element
            } else {
                dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]
            }
        }
    }

    return dp[n][target]
}

fun main() {
    // Test Case 1: Subset exists
    val arr1 = intArrayOf(3, 34, 4, 12, 5, 2)
    val target1 = 9
    println("Test 1: arr = ${arr1.contentToString()}, target = $target1")
    println("Subset Exists: ${subsetSum(arr1, target1)}")
    println("Expected: true  ({4, 3, 2} or {4, 5})\n")

    // Test Case 2: Subset does not exist
    val arr2 = intArrayOf(3, 34, 4, 12, 5, 2)
    val target2 = 30
    println("Test 2: arr = ${arr2.contentToString()}, target = $target2")
    println("Subset Exists: ${subsetSum(arr2, target2)}")
    println("Expected: false\n")

    // Test Case 3: Single element equals target
    val arr3 = intArrayOf(7)
    val target3 = 7
    println("Test 3: arr = ${arr3.contentToString()}, target = $target3")
    println("Subset Exists: ${subsetSum(arr3, target3)}")
    println("Expected: true")
}
