/**
 * Problem: Longest Common Subsequence (Bottom-Up DP)
 * Find the length of the longest common subsequence between two strings.
 *
 * Time Complexity: O(m * n) where m and n are string lengths
 * Space Complexity: O(m * n)
 */

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val m = text1.length
    val n = text2.length
    
    val dp = Array(m + 1) { IntArray(n + 1) }
    
    // Build the DP table
    for (i in 1..m) {
        for (j in 1..n) {
            if (text1[i - 1] == text2[j - 1]) {
                // Characters match, increment count
                dp[i][j] = 1 + dp[i - 1][j - 1]
            } else {
                // Characters don't match, take max
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    
    return dp[m][n]
}

fun getLCS(text1: String, text2: String): String {
    val m = text1.length
    val n = text2.length
    
    val dp = Array(m + 1) { IntArray(n + 1) }
    
    // Build the DP table
    for (i in 1..m) {
        for (j in 1..n) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1]
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    
    // Reconstruct LCS
    val lcs = StringBuilder()
    var i = m
    var j = n
    
    while (i > 0 && j > 0) {
        when {
            text1[i - 1] == text2[j - 1] -> {
                lcs.insert(0, text1[i - 1])
                i--
                j--
            }
            dp[i - 1][j] > dp[i][j - 1] -> i--
            else -> j--
        }
    }
    
    return lcs.toString()
}

fun main() {
    // Test Case 1: Simple strings
    val text1_1 = "abcde"
    val text2_1 = "ace"
    
    println("Test 1: LCS of \"$text1_1\" and \"$text2_1\"")
    val length1 = longestCommonSubsequence(text1_1, text2_1)
    val lcs1 = getLCS(text1_1, text2_1)
    println("LCS Length: $length1")
    println("LCS String: \"$lcs1\"")
    println("Expected Length: 3")
    println("Expected String: \"ace\"\n")
    
    // Test Case 2: Different strings with common subsequence
    val text1_2 = "oxcpqrsvwf"
    val text2_2 = "sxyspmqyhbt"
    
    println("Test 2: LCS of \"$text1_2\" and \"$text2_2\"")
    val length2 = longestCommonSubsequence(text1_2, text2_2)
    val lcs2 = getLCS(text1_2, text2_2)
    println("LCS Length: $length2")
    println("LCS String: \"$lcs2\"")
    println("Expected Length: 5\n")
    
    // Test Case 3: Identical strings
    val text1_3 = "hello"
    val text2_3 = "hello"
    
    println("Test 3: LCS of \"$text1_3\" and \"$text2_3\" (identical)")
    val length3 = longestCommonSubsequence(text1_3, text2_3)
    val lcs3 = getLCS(text1_3, text2_3)
    println("LCS Length: $length3")
    println("LCS String: \"$lcs3\"")
    println("Expected Length: 5")
    println("Expected String: \"hello\"")
}
