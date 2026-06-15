/**
 * Problem: Word Break
 * Given a string and a dictionary, determine if the string can be segmented into
 * a sequence of one or more dictionary words.
 *
 * Recurrence Relation:
 *   dp[i] = true if any dp[j] is true AND s[j..i] is in dictionary, for j < i
 *
 * Time Complexity: O(n² * m) where n = string length, m = avg word length
 * Space Complexity: O(n)
 */

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordSet = wordDict.toHashSet()
    val n = s.length
    val dp = BooleanArray(n + 1)
    dp[0] = true // Empty string is always valid

    for (i in 1..n) {
        for (j in 0 until i) {
            if (dp[j] && s.substring(j, i) in wordSet) {
                dp[i] = true
                break
            }
        }
    }

    return dp[n]
}

fun main() {
    // Test Case 1: Can be segmented
    val s1 = "leetcode"
    val dict1 = listOf("leet", "code")
    println("Test 1: s = \"$s1\", dict = $dict1")
    println("Can Break: ${wordBreak(s1, dict1)}")
    println("Expected: true  (\"leet\" + \"code\")\n")

    // Test Case 2: Can be segmented (multiple ways)
    val s2 = "applepenapple"
    val dict2 = listOf("apple", "pen")
    println("Test 2: s = \"$s2\", dict = $dict2")
    println("Can Break: ${wordBreak(s2, dict2)}")
    println("Expected: true  (\"apple\" + \"pen\" + \"apple\")\n")

    // Test Case 3: Cannot be segmented
    val s3 = "catsandog"
    val dict3 = listOf("cats", "dog", "sand", "and", "cat")
    println("Test 3: s = \"$s3\", dict = $dict3")
    println("Can Break: ${wordBreak(s3, dict3)}")
    println("Expected: false")
}
