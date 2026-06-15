/**
 * Problem: Queue Implementation Using Linked List
 * Implement a queue with enqueue(), dequeue(), peek(), and isEmpty() operations.
 *
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 */

data class Node(
    var value: Int,
    var next: Node? = null
)

class Queue {
    private var front: Node? = null
    private var rear: Node? = null
    private var size = 0
    
    fun enqueue(value: Int) {
        val newNode = Node(value)
        if (rear == null) {
            front = newNode
        } else {
            rear?.next = newNode
        }
        rear = newNode
        size++
    }
    
    fun dequeue(): Int? {
        if (front == null) {
            println("Queue underflow!")
            return null
        }
        val value = front?.value
        front = front?.next
        size--
        
        if (front == null) {
            rear = null
        }
        
        return value
    }
    
    fun peek(): Int? {
        return front?.value
    }
    
    fun isEmpty(): Boolean {
        return front == null
    }
    
    fun getSize(): Int {
        return size
    }
    
    fun printQueue() {
        if (isEmpty()) {
            println("[]")
            return
        }
        val sb = StringBuilder("[")
        var current = front
        while (current != null) {
            sb.append(current.value)
            if (current.next != null) sb.append(", ")
            current = current.next
        }
        sb.append("]")
        println(sb.toString())
    }
}

fun main() {
    val queue = Queue()
    
    println("Test 1: Basic Queue Operations (FIFO)")
    println("Enqueuing: 10, 20, 30, 40, 50")
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue(40)
    queue.enqueue(50)
    
    print("Queue contents: ")
    queue.printQueue()
    println("Size: ${queue.getSize()}")
    println("Front (Peek): ${queue.peek()}\n")
    
    println("Dequeuing elements (FIFO):")
    while (!queue.isEmpty()) {
        println("Dequeued: ${queue.dequeue()}")
    }
    println()
    
    println("Test 2: Empty Check")
    println("Is empty: ${queue.isEmpty()}")
    println("Peek on empty: ${queue.peek()}")
    
    println("\nTest 3: Enqueue after dequeue all")
    queue.enqueue(100)
    queue.enqueue(200)
    println("After enqueueing 100, 200:")
    print("Queue contents: ")
    queue.printQueue()
    println("Size: ${queue.getSize()}")
    println("Front (Peek): ${queue.peek()}")
}
