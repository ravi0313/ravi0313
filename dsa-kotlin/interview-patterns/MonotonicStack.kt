/**
 * PATTERN: Monotonic Stack
 * Maintain a stack that is always increasing or decreasing. When a new element
 * violates the order, pop and process. Solves "next greater/smaller" problems in O(n).
 *
 * Key insight: Instead of nested loops O(n²), we use a stack to track candidates
 * and resolve them the moment we see the answer.
 *
 * Problems solved:
 *   1. Next Greater Element
 *   2. Daily Temperatures
 *   3. Largest Rectangle in Histogram
 */

// ─── Problem 1: Next Greater Element ─────────────────────────────────────────
// For each element, find the next greater element to its right. -1 if none.
// Pattern: Monotonic decreasing stack. Pop when a greater element is found.
// Time: O(n), Space: O(n)

fun nextGreaterElement(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { -1 }
    val stack = ArrayDeque<Int>() // Stores indices

    for (i in nums.indices) {
        while (stack.isNotEmpty() && nums[i] > nums[stack.last()]) {
            result[stack.removeLast()] = nums[i]
        }
        stack.addLast(i)
    }
    return result
}

// ─── Problem 2: Daily Temperatures ────────────────────────────────────────────
// For each day, how many days until a warmer temperature? 0 if none.
// Pattern: Same as Next Greater Element, but store days count instead of value.
// Time: O(n), Space: O(n)

fun dailyTemperatures(temps: IntArray): IntArray {
    val result = IntArray(temps.size)
    val stack = ArrayDeque<Int>() // Stores indices

    for (i in temps.indices) {
        while (stack.isNotEmpty() && temps[i] > temps[stack.last()]) {
            val idx = stack.removeLast()
            result[idx] = i - idx
        }
        stack.addLast(i)
    }
    return result
}

// ─── Problem 3: Largest Rectangle in Histogram ────────────────────────────────
// Find the area of the largest rectangle that fits in a histogram.
// Pattern: Monotonic increasing stack. When a shorter bar is seen, compute area.
// Time: O(n), Space: O(n)

fun largestRectangleArea(heights: IntArray): Int {
    val stack = ArrayDeque<Int>() // Stores indices
    var maxArea = 0
    val n = heights.size

    for (i in 0..n) {
        val currentH = if (i == n) 0 else heights[i]
        while (stack.isNotEmpty() && currentH < heights[stack.last()]) {
            val height = heights[stack.removeLast()]
            val width = if (stack.isEmpty()) i else i - stack.last() - 1
            maxArea = maxOf(maxArea, height * width)
        }
        stack.addLast(i)
    }
    return maxArea
}

fun main() {
    println("=== Monotonic Stack Pattern ===\n")

    println("1. Next Greater Element")
    val nums1 = intArrayOf(2, 1, 2, 4, 3)
    println("   ${nums1.contentToString()}")
    println("   Next Greater: ${nextGreaterElement(nums1).contentToString()}")
    println("   Expected:     [4, 2, 4, -1, -1]\n")

    println("2. Daily Temperatures")
    val temps = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    println("   ${temps.contentToString()}")
    println("   Days until warmer: ${dailyTemperatures(temps).contentToString()}")
    println("   Expected:          [1, 1, 4, 2, 1, 1, 0, 0]\n")

    println("3. Largest Rectangle in Histogram")
    val heights1 = intArrayOf(2, 1, 5, 6, 2, 3)
    println("   heights = ${heights1.contentToString()}")
    println("   Max area = ${largestRectangleArea(heights1)}  Expected: 10")
    val heights2 = intArrayOf(2, 4)
    println("   heights = ${heights2.contentToString()}")
    println("   Max area = ${largestRectangleArea(heights2)}  Expected: 4")
}
