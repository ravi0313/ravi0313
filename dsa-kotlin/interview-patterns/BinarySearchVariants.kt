/**
 * PATTERN: Binary Search Variants
 * Binary search is not just for sorted arrays. It works whenever the search space
 * has a monotonic property — one side always violates the condition, other doesn't.
 *
 * General template: Find the boundary where condition changes from false → true.
 *
 * Problems solved:
 *   1. Search in Rotated Sorted Array
 *   2. Find Peak Element
 *   3. Kth Smallest Element in a Sorted Matrix
 */

// ─── Problem 1: Search in Rotated Sorted Array ───────────────────────────────
// Array was sorted, then rotated. Find target index.
// Pattern: Determine which half is sorted, narrow search based on target range.
// Time: O(log n), Space: O(1)

fun searchRotated(nums: IntArray, target: Int): Int {
    var left = 0; var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        if (nums[left] <= nums[mid]) { // Left half is sorted
            if (target in nums[left] until nums[mid]) right = mid - 1 else left = mid + 1
        } else { // Right half is sorted
            if (target in (nums[mid] + 1)..nums[right]) left = mid + 1 else right = mid - 1
        }
    }
    return -1
}

// ─── Problem 2: Find Peak Element ─────────────────────────────────────────────
// A peak element is greater than its neighbors. Find any peak (may be multiple).
// Pattern: Move toward the higher neighbor — the peak is always in that direction.
// Time: O(log n), Space: O(1)

fun findPeakElement(nums: IntArray): Int {
    var left = 0; var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] > nums[mid + 1]) right = mid else left = mid + 1
    }
    return left
}

// ─── Problem 3: Kth Smallest in Sorted Matrix ────────────────────────────────
// Matrix has each row and column sorted. Find kth smallest element.
// Pattern: Binary search on VALUE range [min, max]. Count how many elements ≤ mid.
// Time: O(n log(max-min)), Space: O(1)

fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val n = matrix.size
    var left = matrix[0][0]
    var right = matrix[n - 1][n - 1]

    fun countLessEqual(mid: Int): Int {
        var count = 0; var row = n - 1; var col = 0
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) { count += row + 1; col++ }
            else row--
        }
        return count
    }

    while (left < right) {
        val mid = left + (right - left) / 2
        if (countLessEqual(mid) < k) left = mid + 1 else right = mid
    }
    return left
}

fun main() {
    println("=== Binary Search Variants ===\n")

    println("1. Search in Rotated Sorted Array")
    val nums1 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    println("   ${nums1.contentToString()}, target = 0 → index ${searchRotated(nums1, 0)}  Expected: 4")
    println("   ${nums1.contentToString()}, target = 3 → index ${searchRotated(nums1, 3)}  Expected: -1\n")

    println("2. Find Peak Element")
    val nums2 = intArrayOf(1, 2, 3, 1)
    println("   ${nums2.contentToString()} → peak index ${findPeakElement(nums2)}  Expected: 2")
    val nums3 = intArrayOf(1, 2, 1, 3, 5, 6, 4)
    println("   ${nums3.contentToString()} → peak index ${findPeakElement(nums3)}  Expected: 1 or 5\n")

    println("3. Kth Smallest in Sorted Matrix")
    val matrix = arrayOf(
        intArrayOf(1, 5, 9),
        intArrayOf(10, 11, 13),
        intArrayOf(12, 13, 15)
    )
    println("   Matrix:")
    matrix.forEach { println("     ${it.contentToString()}") }
    println("   k=8 → ${kthSmallest(matrix, 8)}  Expected: 13")
    println("   k=1 → ${kthSmallest(matrix, 1)}  Expected: 1")
}
