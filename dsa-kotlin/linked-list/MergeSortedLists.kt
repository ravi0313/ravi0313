/**
 * Problem: Merge Two Sorted Linked Lists
 * Merge two sorted linked lists into one sorted linked list.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

data class Node(
    var value: Int,
    var next: Node? = null
)

fun mergeSortedLists(l1: Node?, l2: Node?): Node? {
    val dummy = Node(0)
    var current = dummy
    var p1 = l1
    var p2 = l2
    
    while (p1 != null && p2 != null) {
        if (p1.value <= p2.value) {
            current.next = p1
            p1 = p1.next
        } else {
            current.next = p2
            p2 = p2.next
        }
        current = current.next!!
    }
    
    // Attach remaining nodes
    current.next = if (p1 != null) p1 else p2
    
    return dummy.next
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
    // Test Case 1: [1 -> 2 -> 4] and [1 -> 3 -> 4]
    val l1_1 = Node(1, Node(2, Node(4)))
    val l2_1 = Node(1, Node(3, Node(4)))
    
    println("Test 1:")
    print("List 1: ")
    printList(l1_1)
    print("List 2: ")
    printList(l2_1)
    
    val merged1 = mergeSortedLists(l1_1, l2_1)
    print("Merged: ")
    printList(merged1)
    println()
    
    // Test Case 2: [2] and [1]
    val l1_2 = Node(2)
    val l2_2 = Node(1)
    
    println("Test 2:")
    print("List 1: ")
    printList(l1_2)
    print("List 2: ")
    printList(l2_2)
    
    val merged2 = mergeSortedLists(l1_2, l2_2)
    print("Merged: ")
    printList(merged2)
    println()
    
    // Test Case 3: [] and [0]
    val l1_3: Node? = null
    val l2_3 = Node(0)
    
    println("Test 3:")
    print("List 1: ")
    printList(l1_3)
    print("List 2: ")
    printList(l2_3)
    
    val merged3 = mergeSortedLists(l1_3, l2_3)
    print("Merged: ")
    printList(merged3)
}
