/**
 * Extension Functions for DSA in Kotlin
 * Kotlin allows adding methods to existing types without inheritance.
 * Why cleaner than Java: No static utility classes, reads as natural language,
 * callable directly on the object — `arr.swap(0, 1)` instead of `ArrayUtils.swap(arr, 0, 1)`.
 */

// ─── IntArray Extensions ──────────────────────────────────────────────────────

fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]; this[i] = this[j]; this[j] = temp
}

fun IntArray.rotateLeft(k: Int): IntArray {
    val n = size
    val steps = k % n
    return sliceArray(steps until n) + sliceArray(0 until steps)
}

fun IntArray.rotateRight(k: Int): IntArray {
    val n = size
    val steps = k % n
    return sliceArray(n - steps until n) + sliceArray(0 until n - steps)
}

fun IntArray.isPalindrome(): Boolean {
    var l = 0; var r = size - 1
    while (l < r) { if (this[l++] != this[r--]) return false }
    return true
}

fun IntArray.binarySearch(target: Int): Int {
    var l = 0; var r = size - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        when {
            this[mid] == target -> return mid
            this[mid] < target -> l = mid + 1
            else -> r = mid - 1
        }
    }
    return -1
}

// ─── List<Int> Extensions ─────────────────────────────────────────────────────

fun List<Int>.isPalindrome(): Boolean = this == this.reversed()

fun List<Int>.prefixSums(): List<Int> = runningFold(0) { acc, n -> acc + n }.drop(1)

fun List<Int>.rangeSum(from: Int, to: Int): Int = subList(from, to + 1).sum()

// ─── String Extensions ────────────────────────────────────────────────────────

fun String.isPalindromeStr(): Boolean = this == this.reversed()

fun String.isAnagramOf(other: String): Boolean =
    this.length == other.length && this.toCharArray().sorted() == other.toCharArray().sorted()

fun main() {
    // IntArray swap
    println("=== IntArray.swap() ===")
    val arr = intArrayOf(1, 2, 3, 4, 5)
    println("Before swap(0,4): ${arr.contentToString()}")
    arr.swap(0, 4)
    println("After  swap(0,4): ${arr.contentToString()}")
    println("Expected: [5, 2, 3, 4, 1]\n")

    // Rotate
    println("=== IntArray.rotateLeft() / rotateRight() ===")
    val arr2 = intArrayOf(1, 2, 3, 4, 5)
    println("Original:     ${arr2.contentToString()}")
    println("rotateLeft(2):  ${arr2.rotateLeft(2).contentToString()}  Expected: [3,4,5,1,2]")
    println("rotateRight(2): ${arr2.rotateRight(2).contentToString()} Expected: [4,5,1,2,3]\n")

    // Palindrome
    println("=== isPalindrome() ===")
    println("[1,2,1].isPalindrome() = ${intArrayOf(1,2,1).isPalindrome()}  Expected: true")
    println("[1,2,3].isPalindrome() = ${intArrayOf(1,2,3).isPalindrome()} Expected: false")
    println("\"racecar\".isPalindromeStr() = ${"racecar".isPalindromeStr()} Expected: true\n")

    // Binary search
    println("=== IntArray.binarySearch() ===")
    val sorted = intArrayOf(1, 3, 5, 7, 9, 11)
    println("Array: ${sorted.contentToString()}")
    println("binarySearch(7) = ${sorted.binarySearch(7)}  Expected: 3")
    println("binarySearch(6) = ${sorted.binarySearch(6)}  Expected: -1\n")

    // Prefix sums
    println("=== List<Int>.prefixSums() ===")
    val list = listOf(1, 2, 3, 4, 5)
    println("prefixSums($list) = ${list.prefixSums()}")
    println("Expected: [1, 3, 6, 10, 15]\n")

    // Anagram check
    println("=== String.isAnagramOf() ===")
    println("\"listen\".isAnagramOf(\"silent\") = ${"listen".isAnagramOf("silent")} Expected: true")
    println("\"hello\".isAnagramOf(\"world\") = ${"hello".isAnagramOf("world")} Expected: false")
}
