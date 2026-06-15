/**
 * PATTERN: Merge Intervals
 * Sort intervals by start time. Merge overlapping intervals greedily.
 * Two intervals [a, b] and [c, d] overlap when c <= b.
 *
 * Problems solved:
 *   1. Merge Intervals
 *   2. Insert Interval
 *   3. Non-Overlapping Intervals (minimum removals to make non-overlapping)
 */

// ─── Problem 1: Merge Intervals ───────────────────────────────────────────────
// Merge all overlapping intervals.
// Pattern: Sort by start, merge when current start ≤ previous end.
// Time: O(n log n), Space: O(n)

fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    val merged = mutableListOf(intervals[0])
    for (i in 1 until intervals.size) {
        val last = merged.last()
        if (intervals[i][0] <= last[1]) {
            last[1] = maxOf(last[1], intervals[i][1]) // Extend end
        } else {
            merged.add(intervals[i])
        }
    }
    return merged.toTypedArray()
}

// ─── Problem 2: Insert Interval ───────────────────────────────────────────────
// Insert a new interval and merge if necessary.
// Pattern: Add all before new, merge overlapping, add all after.
// Time: O(n), Space: O(n)

fun insertInterval(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var i = 0
    val n = intervals.size

    // Add all non-overlapping before new interval
    while (i < n && intervals[i][1] < newInterval[0]) result.add(intervals[i++])

    // Merge all overlapping with new interval
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = minOf(newInterval[0], intervals[i][0])
        newInterval[1] = maxOf(newInterval[1], intervals[i][1])
        i++
    }
    result.add(newInterval)

    // Add remaining
    while (i < n) result.add(intervals[i++])

    return result.toTypedArray()
}

// ─── Problem 3: Non-Overlapping Intervals ────────────────────────────────────
// Find minimum number of intervals to remove to make rest non-overlapping.
// Pattern: Sort by end time, greedily keep interval that ends earliest.
// Time: O(n log n), Space: O(1)

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[1] }
    var removals = 0
    var prevEnd = Int.MIN_VALUE
    for ((start, end) in intervals) {
        if (start >= prevEnd) {
            prevEnd = end // Keep this interval
        } else {
            removals++ // Remove the one that overlaps (we keep the earlier-ending one)
        }
    }
    return removals
}

fun main() {
    println("=== Merge Intervals Pattern ===\n")

    println("1. Merge Intervals")
    val intervals1 = arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18))
    println("   Input:    ${intervals1.map { it.toList() }}")
    val merged = mergeIntervals(intervals1)
    println("   Merged:   ${merged.map { it.toList() }}")
    println("   Expected: [[1, 6], [8, 10], [15, 18]]\n")

    println("2. Insert Interval")
    val intervals2 = arrayOf(intArrayOf(1,3), intArrayOf(6,9))
    val newInterval = intArrayOf(2, 5)
    println("   Intervals: ${intervals2.map { it.toList() }}, new = [2, 5]")
    val inserted = insertInterval(intervals2, newInterval)
    println("   Result:    ${inserted.map { it.toList() }}")
    println("   Expected:  [[1, 5], [6, 9]]\n")

    println("3. Non-Overlapping Intervals")
    val intervals3 = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3))
    println("   Input:    ${intervals3.map { it.toList() }}")
    println("   Removals: ${eraseOverlapIntervals(intervals3)}")
    println("   Expected: 1  (remove [1,3])")
}
