/**
 * Generic Linked List using Kotlin Data Classes and Generics
 * A type-safe, immutable-friendly linked list using Kotlin generics and data classes.
 *
 * Why cleaner than Java:
 *   - `data class` gives equals(), hashCode(), copy(), toString() for free
 *   - Generic type parameter <T> is concise, no raw types
 *   - Null safety via T? eliminates NullPointerException
 *   - Extension functions let you add operations without modifying the class
 */

// ─── Generic Node and LinkedList ─────────────────────────────────────────────

data class ListNode<T>(
    val value: T,
    var next: ListNode<T>? = null
)

class GenericLinkedList<T> {
    private var head: ListNode<T>? = null
    private var size = 0

    fun addFront(value: T) {
        head = ListNode(value, head)
        size++
    }

    fun addBack(value: T) {
        val newNode = ListNode(value)
        if (head == null) { head = newNode; size++; return }
        var current = head
        while (current?.next != null) current = current.next
        current?.next = newNode
        size++
    }

    fun removeFront(): T? {
        val value = head?.value
        head = head?.next
        if (value != null) size--
        return value
    }

    fun contains(value: T): Boolean {
        var current = head
        while (current != null) {
            if (current.value == value) return true
            current = current.next
        }
        return false
    }

    fun toList(): List<T> {
        val result = mutableListOf<T>()
        var current = head
        while (current != null) {
            result.add(current.value)
            current = current.next
        }
        return result
    }

    fun size() = size
    fun isEmpty() = head == null
}

// ─── Extension Functions on GenericLinkedList ─────────────────────────────────

fun <T> GenericLinkedList<T>.reversed(): List<T> = toList().reversed()

fun <T : Comparable<T>> GenericLinkedList<T>.min(): T? = toList().minOrNull()

fun <T : Comparable<T>> GenericLinkedList<T>.max(): T? = toList().maxOrNull()

fun main() {
    // Int LinkedList
    println("=== Generic LinkedList<Int> ===")
    val intList = GenericLinkedList<Int>()
    intList.addBack(1)
    intList.addBack(2)
    intList.addBack(3)
    intList.addFront(0)
    println("List: ${intList.toList()}  Expected: [0, 1, 2, 3]")
    println("Size: ${intList.size()}")
    println("Contains 2: ${intList.contains(2)}  Expected: true")
    println("Contains 9: ${intList.contains(9)}  Expected: false")
    println("Reversed: ${intList.reversed()}  Expected: [3, 2, 1, 0]")
    println("Min: ${intList.min()}  Expected: 0")
    println("Max: ${intList.max()}  Expected: 3")
    println("RemoveFront: ${intList.removeFront()}  Expected: 0")
    println("After remove: ${intList.toList()}  Expected: [1, 2, 3]\n")

    // String LinkedList
    println("=== Generic LinkedList<String> ===")
    val strList = GenericLinkedList<String>()
    strList.addBack("hello")
    strList.addBack("world")
    strList.addFront("kotlin")
    println("List: ${strList.toList()}  Expected: [kotlin, hello, world]")
    println("Contains \"world\": ${strList.contains("world")}  Expected: true\n")

    // Empty list
    println("=== Empty LinkedList ===")
    val emptyList = GenericLinkedList<Double>()
    println("isEmpty: ${emptyList.isEmpty()}  Expected: true")
    println("Min: ${emptyList.min()}  Expected: null")
    println("toList: ${emptyList.toList()}  Expected: []")
}
