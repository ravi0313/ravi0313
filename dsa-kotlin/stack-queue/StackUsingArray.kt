/**
 * Problem: Stack Implementation Using Array
 * Implement a stack with push(), pop(), peek(), and isEmpty() operations.
 *
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 */

class Stack {
    private val items = IntArray(100)
    private var top = -1
    
    fun push(value: Int) {
        if (top < items.size - 1) {
            items[++top] = value
        } else {
            println("Stack overflow!")
        }
    }
    
    fun pop(): Int? {
        return if (top >= 0) {
            items[top--]
        } else {
            println("Stack underflow!")
            null
        }
    }
    
    fun peek(): Int? {
        return if (top >= 0) {
            items[top]
        } else {
            null
        }
    }
    
    fun isEmpty(): Boolean {
        return top < 0
    }
    
    fun size(): Int {
        return top + 1
    }
    
    fun printStack() {
        if (isEmpty()) {
            println("[]")
            return
        }
        val sb = StringBuilder("[")
        for (i in 0..top) {
            sb.append(items[i])
            if (i < top) sb.append(", ")
        }
        sb.append("]")
        println(sb.toString())
    }
}

fun main() {
    val stack = Stack()
    
    println("Test 1: Basic Stack Operations")
    println("Pushing: 10, 20, 30, 40, 50")
    stack.push(10)
    stack.push(20)
    stack.push(30)
    stack.push(40)
    stack.push(50)
    
    print("Stack contents: ")
    stack.printStack()
    println("Size: ${stack.size()}")
    println("Peek: ${stack.peek()}\n")
    
    println("Popping elements:")
    while (!stack.isEmpty()) {
        println("Popped: ${stack.pop()}")
    }
    println()
    
    println("Test 2: Empty Check")
    println("Is empty: ${stack.isEmpty()}")
    println("Peek on empty: ${stack.peek()}")
    
    println("\nTest 3: Push after empty")
    stack.push(100)
    println("After pushing 100:")
    print("Stack contents: ")
    stack.printStack()
    println("Peek: ${stack.peek()}")
}
