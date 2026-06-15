/**
 * Problem: 0/1 Knapsack Problem (Bottom-Up DP)
 * Given weights, values, and capacity, find the maximum value that can be obtained
 * by selecting items without exceeding the capacity.
 *
 * Time Complexity: O(n * W) where W is capacity
 * Space Complexity: O(n * W)
 */

fun knapsack(weights: IntArray, values: IntArray, capacity: Int): Int {
    val n = weights.size
    val dp = Array(n + 1) { IntArray(capacity + 1) }
    
    // Build the DP table
    for (i in 1..n) {
        for (w in 0..capacity) {
            if (weights[i - 1] <= w) {
                // Item can fit, choose max of including or excluding
                dp[i][w] = maxOf(
                    values[i - 1] + dp[i - 1][w - weights[i - 1]],
                    dp[i - 1][w]
                )
            } else {
                // Item cannot fit
                dp[i][w] = dp[i - 1][w]
            }
        }
    }
    
    return dp[n][capacity]
}

fun main() {
    // Test Case 1: Classic knapsack
    val weights1 = intArrayOf(2, 3, 4, 5)
    val values1 = intArrayOf(3, 4, 5, 6)
    val capacity1 = 5
    
    println("Test 1: Classic Knapsack")
    println("Weights: ${weights1.contentToString()}")
    println("Values:  ${values1.contentToString()}")
    println("Capacity: $capacity1")
    
    val result1 = knapsack(weights1, values1, capacity1)
    println("Maximum Value: $result1")
    println("Expected: 10 (items with weights 2 and 3, values 3 and 4, or items with weight 5 and value 6)\n")
    
    // Test Case 2: Another knapsack
    val weights2 = intArrayOf(1, 2, 5, 6)
    val values2 = intArrayOf(5, 11, 13, 7)
    val capacity2 = 11
    
    println("Test 2: Different Knapsack")
    println("Weights: ${weights2.contentToString()}")
    println("Values:  ${values2.contentToString()}")
    println("Capacity: $capacity2")
    
    val result2 = knapsack(weights2, values2, capacity2)
    println("Maximum Value: $result2")
    println("Expected: 28 (items with weights 1, 2, 5, values 5, 11, 13)\n")
    
    // Test Case 3: Capacity larger than total weight
    val weights3 = intArrayOf(2, 3, 4)
    val values3 = intArrayOf(3, 4, 5)
    val capacity3 = 100
    
    println("Test 3: Large Capacity")
    println("Weights: ${weights3.contentToString()}")
    println("Values:  ${values3.contentToString()}")
    println("Capacity: $capacity3")
    
    val result3 = knapsack(weights3, values3, capacity3)
    println("Maximum Value: $result3")
    println("Expected: 12 (all items fit)")
}
