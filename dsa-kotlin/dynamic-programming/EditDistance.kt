/**
 * Problem: Edit Distance (Levenshtein Distance)
 * Find the minimum number of operations (insert, delete, replace) to convert word1 to word2.
 *
 * Recurrence Relation:
 *   dp[i][j] = 0                         if i == 0 or j == 0
 *   dp[i][j] = dp[i-1][j-1]              if word1[i] == word2[j]
 *   dp[i][j] = 1 + min(dp[i-1][j],       // delete
 *                       dp[i][j-1],       // insert
 *                       dp[i-1][j-1])     // replace
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

fun editDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    // Base cases: converting to/from empty string
    for (i in 0..m) dp[i][0] = i
    for (j in 0..n) dp[0][j] = j

    for (i in 1..m) {
        for (j in 1..n) {
            dp[i][j] = if (word1[i - 1] == word2[j - 1]) {
                dp[i - 1][j - 1]
            } else {
                1 + minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
            }
        }
    }

    return dp[m][n]
}

fun main() {
    // Test Case 1: Classic horse → ros
    println("Test 1: \"horse\" → \"ros\"")
    println("Edit Distance: ${editDistance("horse", "ros")}")
    println("Expected: 3  (horse→rorse→rose→ros)\n")

    // Test Case 2: Same strings
    println("Test 2: \"kotlin\" → \"kotlin\"")
    println("Edit Distance: ${editDistance("kotlin", "kotlin")}")
    println("Expected: 0\n")

    // Test Case 3: One is empty
    println("Test 3: \"\" → \"abc\"")
    println("Edit Distance: ${editDistance("", "abc")}")
    println("Expected: 3 (insert a, b, c)")
}
