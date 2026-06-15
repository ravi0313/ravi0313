/**
 * PATTERN: Cyclic Sort
 * For arrays containing numbers in range [1, n] (or [0, n-1]), each element can be
 * placed at its correct index in O(n) with no extra space by swapping elements to
 * their correct position while iterating once.
 *
 * Key insight: nums[i] should be at index nums[i] - 1. If not, swap.
 *
 * Problems solved:
 *   1. Find Missing Number
 *   2. Find the Duplicate Number
 *   3. Find All Missing Numbers
 */

// ─── Problem 1: Find Missing Number ──────────────────────────────────────────
// Array has n distinct numbers in range [0, n]. Find the missing one.
// Pattern: Place each num at index num. The index without matching num is the answer.
// Time: O(n), Space: O(1)

fun missingNumber(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        val correct = nums[i]
        if (correct < nums.size && correct != nums[correct]) {
            nums[i] = nums[correct].also { nums[correct] = nums[i] } // swap
        } else {
            i++
        }
    }
    for (j in nums.indices) {
        if (nums[j] != j) return j
    }
    return nums.size
}

// ─── Problem 2: Find Duplicate (Cyclic Sort approach) ─────────────────────────
// Array has n+1 numbers in [1, n], one duplicate. Find it.
// Pattern: Place each num at index num-1. When expected spot is taken, that's the duplicate.
// Time: O(n), Space: O(1)

fun findDuplicateCyclic(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        val correct = nums[i] - 1
        if (nums[i] != nums[correct]) {
            nums[i] = nums[correct].also { nums[correct] = nums[i] }
        } else {
            i++
        }
    }
    for (j in nums.indices) {
        if (nums[j] != j + 1) return nums[j]
    }
    return -1
}

// ─── Problem 3: Find All Missing Numbers ──────────────────────────────────────
// Array of n integers, each in [1, n], some appear twice, some missing. Find all missing.
// Pattern: Cyclic sort, then collect indices where nums[i] != i+1.
// Time: O(n), Space: O(1) excluding output

fun findAllMissing(nums: IntArray): List<Int> {
    var i = 0
    while (i < nums.size) {
        val correct = nums[i] - 1
        if (nums[i] != nums[correct]) {
            nums[i] = nums[correct].also { nums[correct] = nums[i] }
        } else {
            i++
        }
    }
    return nums.indices.filter { nums[it] != it + 1 }.map { it + 1 }
}

fun main() {
    println("=== Cyclic Sort Pattern ===\n")

    println("1. Find Missing Number")
    println("   [3,0,1] → ${missingNumber(intArrayOf(3,0,1))}  Expected: 2")
    println("   [9,6,4,2,3,5,7,0,1] → ${missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1))}  Expected: 8\n")

    println("2. Find Duplicate (Cyclic Sort)")
    println("   [1,3,4,2,2] → ${findDuplicateCyclic(intArrayOf(1,3,4,2,2))}  Expected: 2")
    println("   [3,1,3,4,2] → ${findDuplicateCyclic(intArrayOf(3,1,3,4,2))}  Expected: 3\n")

    println("3. Find All Missing Numbers")
    println("   [4,3,2,7,8,2,3,1] → ${findAllMissing(intArrayOf(4,3,2,7,8,2,3,1))}")
    println("   Expected: [5, 6]")
    println("   [1,1] → ${findAllMissing(intArrayOf(1,1))}")
    println("   Expected: [2]")
}
