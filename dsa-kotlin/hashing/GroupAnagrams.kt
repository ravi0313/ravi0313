/**
 * Problem: Group Anagrams
 * Given an array of strings, group the strings that are anagrams of each other.
 * Two strings are anagrams if sorting them produces identical characters.
 *
 * Approach: Use a HashMap where the key is the sorted version of the string.
 *
 * Time Complexity: O(n * k log k) where n = number of strings, k = max string length
 * Space Complexity: O(n * k)
 */

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val key = str.toCharArray().sorted().joinToString("")
        map.getOrPut(key) { mutableListOf() }.add(str)
    }

    return map.values.toList()
}

fun main() {
    // Test Case 1: Classic anagram groups
    val strs1 = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println("Test 1: ${strs1.contentToString()}")
    val result1 = groupAnagrams(strs1)
    println("Grouped: $result1")
    println("Expected: [[eat, tea, ate], [tan, nat], [bat]]\n")

    // Test Case 2: All different
    val strs2 = arrayOf("abc", "def", "ghi")
    println("Test 2: ${strs2.contentToString()}")
    val result2 = groupAnagrams(strs2)
    println("Grouped: $result2")
    println("Expected: [[abc], [def], [ghi]]\n")

    // Test Case 3: All same anagram
    val strs3 = arrayOf("abc", "bca", "cab")
    println("Test 3: ${strs3.contentToString()}")
    val result3 = groupAnagrams(strs3)
    println("Grouped: $result3")
    println("Expected: [[abc, bca, cab]]")
}
