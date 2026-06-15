/**
 * Problem: Trapping Rain Water
 * Given an elevation map represented as an array of heights, compute how much water
 * can be trapped between the elevations after it rains.
 * Use left and right max arrays to find trapped water at each position.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

fun trap(height: IntArray): Int {
    if (height.isEmpty()) return 0
    
    val n = height.size
    val leftMax = IntArray(n)
    val rightMax = IntArray(n)
    
    // Build leftMax array: maximum height to the left
    leftMax[0] = height[0]
    for (i in 1 until n) {
        leftMax[i] = maxOf(leftMax[i - 1], height[i])
    }
    
    // Build rightMax array: maximum height to the right
    rightMax[n - 1] = height[n - 1]
    for (i in n - 2 downTo 0) {
        rightMax[i] = maxOf(rightMax[i + 1], height[i])
    }
    
    // Calculate trapped water
    var water = 0
    for (i in height.indices) {
        val minHeight = minOf(leftMax[i], rightMax[i])
        water += minHeight - height[i]
    }
    
    return water
}

fun main() {
    // Test Case 1: Classic trapping case
    val height1 = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println("Test 1: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]")
    val result1 = trap(height1)
    println("Trapped Water: $result1 units")
    println("Expected: 6\n")
    
    // Test Case 2: Simple V-shape
    val height2 = intArrayOf(4, 2, 0, 3, 2, 5)
    println("Test 2: height = [4, 2, 0, 3, 2, 5]")
    val result2 = trap(height2)
    println("Trapped Water: $result2 units")
    println("Expected: 9 (0 is lowest, can trap 4+3+2=9 units)\n")
    
    // Test Case 3: No trapping possible
    val height3 = intArrayOf(1, 2, 3, 4, 5)
    println("Test 3: height = [1, 2, 3, 4, 5] (ascending)")
    val result3 = trap(height3)
    println("Trapped Water: $result3 units")
    println("Expected: 0")
}
