/**
 * Problem: Fibonacci Sequence (Top-Down DP with Memoization)
 * Calculate the nth Fibonacci number using memoization to avoid redundant calculations.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

fun fibonacci(n: Int, memo: MutableMap<Int, Long> = mutableMapOf()): Long {
    // Base cases
    if (n <= 1) return n.toLong()
    
    // Check if already computed
    if (memo.containsKey(n)) {
        return memo[n]!!
    }
    
    // Compute and store in memo
    val result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo)
    memo[n] = result
    
    return result
}

fun main() {
    println("Test 1: First 15 Fibonacci Numbers")
    print("Sequence: ")
    val fibs = mutableListOf<Long>()
    for (i in 0..14) {
        fibs.add(fibonacci(i))
    }
    println(fibs.joinToString(", "))
    println("Expected: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377\n")
    
    println("Test 2: Specific Fibonacci Numbers")
    println("Fibonacci(5) = ${fibonacci(5)}")
    println("Expected: 5")
    println("Fibonacci(10) = ${fibonacci(10)}")
    println("Expected: 55")
    println("Fibonacci(20) = ${fibonacci(20)}")
    println("Expected: 6765\n")
    
    println("Test 3: Edge Cases")
    println("Fibonacci(0) = ${fibonacci(0)}")
    println("Expected: 0")
    println("Fibonacci(1) = ${fibonacci(1)}")
    println("Expected: 1")
}
