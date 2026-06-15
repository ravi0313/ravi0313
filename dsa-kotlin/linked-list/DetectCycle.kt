/**
 * Problem: Detect Cycle in Linked List (Floyd's Tortoise and Hare Algorithm)
 * Detect if a linked list contains a cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

data class Node(
    var value: Int,
    var next: Node? = null
)

fun hasCycle(head: Node?): Boolean {
    if (head == null || head.next == null) {
        return false
    }
    
    var slow = head
    var fast = head.next
    
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false
        }
        slow = slow?.next
        fast = fast.next?.next
    }
    
    return true
}

fun main() {
    // Test Case 1: List with cycle [1 -> 2 -> 3 -> 4 -> 2]
    val head1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    
    head1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2  // Creates cycle
    
    println("Test 1: [1 -> 2 -> 3 -> 4 -> 2] (cycle)")
    println("Cycle Detected: ${hasCycle(head1)}")
    println("Expected: true\n")
    
    // Test Case 2: List without cycle [1 -> 2 -> 3 -> 4]
    val head2 = Node(1)
    head2.next = Node(2)
    head2.next?.next = Node(3)
    head2.next?.next?.next = Node(4)
    
    println("Test 2: [1 -> 2 -> 3 -> 4] (no cycle)")
    println("Cycle Detected: ${hasCycle(head2)}")
    println("Expected: false\n")
    
    // Test Case 3: Single node [5] with no cycle
    val head3 = Node(5)
    
    println("Test 3: [5] (single node, no cycle)")
    println("Cycle Detected: ${hasCycle(head3)}")
    println("Expected: false")
}
