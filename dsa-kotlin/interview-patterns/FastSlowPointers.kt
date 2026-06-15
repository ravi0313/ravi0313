/**
 * PATTERN: Fast & Slow Pointers (Floyd's Cycle Detection)
 * Use two pointers moving at different speeds. The slow pointer moves 1 step,
 * fast moves 2 steps. If they meet, a cycle exists. If fast reaches null, no cycle.
 * Also useful for finding middle of a list or detecting repeated elements.
 *
 * Problems solved:
 *   1. Middle of Linked List
 *   2. Happy Number
 *   3. Find the Duplicate Number
 */

data class FastSlowNode(val value: Int, var next: FastSlowNode? = null)

// ─── Problem 1: Middle of Linked List ────────────────────────────────────────
// Find the middle node. If even, return second middle.
// Pattern: When fast reaches end, slow is at middle.
// Time: O(n), Space: O(1)

fun middleOfList(head: FastSlowNode?): FastSlowNode? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}

// ─── Problem 2: Happy Number ──────────────────────────────────────────────────
// A happy number eventually reaches 1. Detect infinite cycle otherwise.
// Pattern: Apply fast/slow pointers to the digit-square-sum sequence.
// Time: O(log n), Space: O(1)

fun isHappy(n: Int): Boolean {
    fun digitSquareSum(x: Int): Int =
        generateSequence(x) { it / 10 }
            .takeWhile { it > 0 }
            .sumOf { (it % 10) * (it % 10) }

    var slow = n
    var fast = digitSquareSum(n)
    while (fast != 1 && fast != slow) {
        slow = digitSquareSum(slow)
        fast = digitSquareSum(digitSquareSum(fast))
    }
    return fast == 1
}

// ─── Problem 3: Find the Duplicate Number ────────────────────────────────────
// Array contains n+1 values in range [1, n]. Find the one duplicate.
// Pattern: Treat array as a linked list (arr[i] → arr[arr[i]]). Cycle = duplicate.
// Time: O(n), Space: O(1)

fun findDuplicate(nums: IntArray): Int {
    var slow = nums[0]
    var fast = nums[0]

    // Phase 1: Find intersection inside cycle
    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)

    // Phase 2: Find cycle entry (= duplicate)
    slow = nums[0]
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }
    return slow
}

fun main() {
    println("=== Fast & Slow Pointers Pattern ===\n")

    println("1. Middle of Linked List")
    // Build: 1 → 2 → 3 → 4 → 5
    val n5 = FastSlowNode(5); val n4 = FastSlowNode(4, n5); val n3 = FastSlowNode(3, n4)
    val n2 = FastSlowNode(2, n3); val head = FastSlowNode(1, n2)
    println("   [1, 2, 3, 4, 5] → middle = ${middleOfList(head)?.value}  Expected: 3")

    val m4 = FastSlowNode(4); val m3 = FastSlowNode(3, m4); val m2 = FastSlowNode(2, m3)
    val head2 = FastSlowNode(1, m2)
    println("   [1, 2, 3, 4]   → middle = ${middleOfList(head2)?.value}  Expected: 3 (2nd middle)\n")

    println("2. Happy Number")
    println("   isHappy(19) = ${isHappy(19)}  Expected: true  (19→82→68→100→1)")
    println("   isHappy(2)  = ${isHappy(2)}   Expected: false\n")

    println("3. Find the Duplicate Number")
    val nums1 = intArrayOf(1, 3, 4, 2, 2)
    println("   ${nums1.contentToString()} → duplicate = ${findDuplicate(nums1)}  Expected: 2")
    val nums2 = intArrayOf(3, 1, 3, 4, 2)
    println("   ${nums2.contentToString()} → duplicate = ${findDuplicate(nums2)}  Expected: 3")
}
