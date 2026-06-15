/**
 * Problem: Reverse a Singly Linked List (Iterative)
 * Reverse a singly linked list iteratively.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

data class Node(
    var value: Int,
    var next: Node? = null
)

fun reverseLinkedList(head: Node?): Node? {
    var current = head
    var prev: Node? = null
    
    while (current != null) {
        val nextNode = current.next
        current.next = prev
        prev = current
        current = nextNode
    }
    
    return prev
}

fun printList(head: Node?) {
    val sb = StringBuilder()
    var current = head
    while (current != null) {
        sb.append(current.value)
        if (current.next != null) {
            sb.append(" -> ")
        }
        current = current.next
    }
    println(sb.toString())
}

fun main() {
    // Test Case 1: Reverse [1 -> 2 -> 3 -> 4 -> 5]
    val node5 = Node(5)
    val node4 = Node(4, node5)
    val node3 = Node(3, node4)
    val node2 = Node(2, node3)
    val head1 = Node(1, node2)
    
    println("Test 1:")
    print("Original: ")
    printList(head1)
    
    val reversed1 = reverseLinkedList(head1)
    print("Reversed: ")
    printList(reversed1)
    println()
    
    // Test Case 2: Reverse [10 -> 20 -> 30]
    val head2 = Node(10, Node(20, Node(30)))
    
    println("Test 2:")
    print("Original: ")
    printList(head2)
    
    val reversed2 = reverseLinkedList(head2)
    print("Reversed: ")
    printList(reversed2)
    println()
    
    // Test Case 3: Single element [42]
    val head3 = Node(42)
    
    println("Test 3:")
    print("Original: ")
    printList(head3)
    
    val reversed3 = reverseLinkedList(head3)
    print("Reversed: ")
    printList(reversed3)
}
