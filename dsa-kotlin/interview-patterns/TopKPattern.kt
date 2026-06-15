/**
 * PATTERN: Top K Pattern (Heap / Priority Queue)
 * Use a Min-Heap of size K to track the K largest elements in O(n log k).
 * Use a Max-Heap to efficiently retrieve largest/smallest elements.
 *
 * Key insight: A Min-Heap of size K always holds the K largest seen so far.
 * The root is the Kth largest — pop it when the heap exceeds size K.
 *
 * Problems solved:
 *   1. Kth Largest Element in an Array
 *   2. K Closest Points to Origin
 *   3. Sort K-Sorted (Almost Sorted) Array
 */

import java.util.PriorityQueue

// ─── Problem 1: Kth Largest Element ──────────────────────────────────────────
// Find the kth largest element without fully sorting.
// Pattern: Min-Heap of size k. Root is always the kth largest.
// Time: O(n log k), Space: O(k)

fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>() // Min-heap (default)
    for (num in nums) {
        minHeap.add(num)
        if (minHeap.size > k) minHeap.poll() // Remove smallest
    }
    return minHeap.peek()!! // Root = kth largest
}

// ─── Problem 2: K Closest Points to Origin ────────────────────────────────────
// Return k closest points to origin (0,0) by Euclidean distance.
// Pattern: Max-Heap of size k (by distance). When full, pop farthest if current is closer.
// Time: O(n log k), Space: O(k)

fun kClosestPoints(points: Array<IntArray>, k: Int): Array<IntArray> {
    // Max-heap by squared distance
    val maxHeap = PriorityQueue<IntArray>(compareByDescending { it[0] * it[0] + it[1] * it[1] })
    for (point in points) {
        maxHeap.add(point)
        if (maxHeap.size > k) maxHeap.poll() // Remove farthest
    }
    return maxHeap.toTypedArray()
}

// ─── Problem 3: Sort K-Sorted Array ──────────────────────────────────────────
// Each element is at most k positions away from its sorted position.
// Pattern: Min-Heap of size k+1. Always extract min as next sorted element.
// Time: O(n log k), Space: O(k)

fun sortKSortedArray(arr: IntArray, k: Int): IntArray {
    val minHeap = PriorityQueue<Int>()
    val result = IntArray(arr.size)
    var idx = 0

    for (i in arr.indices) {
        minHeap.add(arr[i])
        if (minHeap.size > k) result[idx++] = minHeap.poll()
    }

    while (minHeap.isNotEmpty()) result[idx++] = minHeap.poll()
    return result
}

fun main() {
    println("=== Top K Pattern (Heap / Priority Queue) ===\n")

    println("1. Kth Largest Element")
    val nums1 = intArrayOf(3, 2, 1, 5, 6, 4)
    println("   ${nums1.contentToString()}, k=2 → ${findKthLargest(nums1, 2)}  Expected: 5")
    val nums2 = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    println("   ${nums2.contentToString()}, k=4 → ${findKthLargest(nums2, 4)}  Expected: 4\n")

    println("2. K Closest Points to Origin")
    val points1 = arrayOf(intArrayOf(1,3), intArrayOf(-2,2))
    println("   Points: ${points1.map { it.toList() }}, k=1")
    val closest1 = kClosestPoints(points1, 1)
    println("   Closest: ${closest1.map { it.toList() }}  Expected: [[-2, 2]]")

    val points2 = arrayOf(intArrayOf(3,3), intArrayOf(5,-1), intArrayOf(-2,4))
    println("   Points: ${points2.map { it.toList() }}, k=2")
    val closest2 = kClosestPoints(points2, 2)
    println("   Closest: ${closest2.map { it.toList() }}  Expected: [[3,3], [-2,4]] (any order)\n")

    println("3. Sort K-Sorted Array")
    val arr = intArrayOf(6, 5, 3, 2, 8, 10, 9)
    val k = 3
    println("   Input (k=$k): ${arr.contentToString()}")
    println("   Sorted:       ${sortKSortedArray(arr, k).contentToString()}")
    println("   Expected:     [2, 3, 5, 6, 8, 9, 10]")
}
