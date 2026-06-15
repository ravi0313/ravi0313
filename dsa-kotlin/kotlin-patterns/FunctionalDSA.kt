/**
 * Functional DSA with Kotlin
 * Demonstrates how Kotlin's functional APIs produce cleaner, more expressive DSA solutions.
 * Why this is cleaner than Java: No boilerplate, functional pipelines replace nested loops,
 * built-in groupBy/fold/reduce eliminate manual aggregation code.
 */

// ─── Problem 1: Two Sum ────────────────────────────────────────────────────────
// Find indices of two numbers that add up to target using fold
// Time: O(n), Space: O(n)

fun twoSumFunctional(nums: List<Int>, target: Int): Pair<Int, Int>? {
    val seen = mutableMapOf<Int, Int>()
    return nums.withIndex()
        .firstOrNull { (i, num) ->
            val complement = target - num
            seen[complement]?.let { return it to i }
            seen[num] = i
            false
        }
        ?.let { null } // If no result returned inside loop
}

// ─── Problem 2: Group Anagrams ────────────────────────────────────────────────
// Group strings by their sorted character signature using groupBy
// Time: O(n * k log k), Space: O(n * k)

fun groupAnagramsFunctional(words: List<String>): Map<String, List<String>> =
    words.groupBy { it.toCharArray().sorted().joinToString("") }

// ─── Problem 3: Flatten Nested List ──────────────────────────────────────────
// Flatten a list of lists using flatMap and fold
// Time: O(n), Space: O(n)

fun flattenList(nested: List<List<Int>>): List<Int> =
    nested.flatMap { it }

fun flattenListWithFold(nested: List<List<Int>>): List<Int> =
    nested.fold(emptyList()) { acc, inner -> acc + inner }

// ─── Problem 4: Running Sum ───────────────────────────────────────────────────
// Build prefix sums using runningFold (Kotlin 1.4+)
// Time: O(n), Space: O(n)

fun runningSumFunctional(nums: List<Int>): List<Int> =
    nums.runningFold(0) { acc, num -> acc + num }.drop(1)

// ─── Problem 5: Max Frequency Element ────────────────────────────────────────
// Find the element with maximum frequency using groupingBy + eachCount + maxByOrNull
// Time: O(n), Space: O(n)

fun maxFrequencyElement(nums: List<Int>): Int =
    nums.groupingBy { it }.eachCount().maxByOrNull { it.value }!!.key

fun main() {
    // Test Two Sum
    println("=== Two Sum (Functional) ===")
    val nums = listOf(2, 7, 11, 15)
    println("nums=$nums, target=9")
    val result = twoSumFunctional(nums, 9)
    println("Indices: $result | Expected: (0, 1)\n")

    // Test Group Anagrams
    println("=== Group Anagrams (groupBy) ===")
    val words = listOf("eat", "tea", "tan", "ate", "nat", "bat")
    val grouped = groupAnagramsFunctional(words)
    println("Input: $words")
    grouped.forEach { (key, group) -> println("  Key '$key': $group") }
    println()

    // Test Flatten
    println("=== Flatten List (flatMap vs fold) ===")
    val nested = listOf(listOf(1, 2), listOf(3, 4), listOf(5))
    println("Input: $nested")
    println("flatMap:   ${flattenList(nested)}")
    println("fold:      ${flattenListWithFold(nested)}")
    println("Expected: [1, 2, 3, 4, 5]\n")

    // Test Running Sum
    println("=== Running Sum (runningFold) ===")
    val nums2 = listOf(1, 2, 3, 4, 5)
    println("Input: $nums2")
    println("Running Sum: ${runningSumFunctional(nums2)}")
    println("Expected: [1, 3, 6, 10, 15]\n")

    // Test Max Frequency
    println("=== Max Frequency Element ===")
    val nums3 = listOf(1, 2, 2, 3, 3, 3, 4)
    println("Input: $nums3")
    println("Max Freq Element: ${maxFrequencyElement(nums3)}")
    println("Expected: 3")
}
