/**
 * Problem: Matrix Chain Multiplication
 * Find the minimum number of scalar multiplications needed to multiply a chain of matrices.
 * Matrices are given by a dimensions array where matrix i has dimensions p[i] x p[i+1].
 *
 * Recurrence Relation:
 *   dp[i][j] = 0                                         if i == j
 *   dp[i][j] = min over k in [i, j-1] of:
 *              dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j]
 *
 * Time Complexity: O(n³)
 * Space Complexity: O(n²)
 */

fun matrixChainOrder(p: IntArray): Int {
    val n = p.size - 1 // Number of matrices
    val dp = Array(n) { IntArray(n) }

    // l = chain length
    for (l in 2..n) {
        for (i in 0..n - l) {
            val j = i + l - 1
            dp[i][j] = Int.MAX_VALUE
            for (k in i until j) {
                val cost = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1]
                if (cost < dp[i][j]) dp[i][j] = cost
            }
        }
    }

    return dp[0][n - 1]
}

fun main() {
    // Test Case 1: 3 matrices — A(10x30), B(30x5), C(5x60)
    val p1 = intArrayOf(10, 30, 5, 60)
    println("Test 1: Matrices A(10×30), B(30×5), C(5×60)")
    println("Dimensions array: ${p1.contentToString()}")
    println("Min Operations: ${matrixChainOrder(p1)}")
    println("Expected: 27000\n")

    // Test Case 2: 4 matrices
    val p2 = intArrayOf(40, 20, 30, 10, 30)
    println("Test 2: 4 matrices, dimensions: ${p2.contentToString()}")
    println("Min Operations: ${matrixChainOrder(p2)}")
    println("Expected: 26000\n")

    // Test Case 3: 2 matrices — trivial
    val p3 = intArrayOf(10, 20, 30)
    println("Test 3: 2 matrices A(10×20), B(20×30)")
    println("Min Operations: ${matrixChainOrder(p3)}")
    println("Expected: 6000")
}
