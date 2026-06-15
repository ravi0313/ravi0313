/**
 * Problem: Detect Cycle in Directed Graph
 * Determine if a directed graph contains a cycle using DFS + recursion stack.
 *
 * Approach: Use two sets — visited and recursionStack.
 * A cycle exists if we reach a node that is already in the current recursion stack.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

fun hasCycleDirected(graph: Map<Int, List<Int>>): Boolean {
    val visited = mutableSetOf<Int>()
    val recursionStack = mutableSetOf<Int>()

    fun dfs(node: Int): Boolean {
        visited.add(node)
        recursionStack.add(node)

        for (neighbor in graph.getOrDefault(node, emptyList())) {
            if (neighbor !in visited) {
                if (dfs(neighbor)) return true
            } else if (neighbor in recursionStack) {
                return true // Back edge = cycle
            }
        }

        recursionStack.remove(node)
        return false
    }

    for (node in graph.keys) {
        if (node !in visited) {
            if (dfs(node)) return true
        }
    }
    return false
}

fun main() {
    // Test Case 1: Directed graph WITH cycle (0→1→2→0)
    val graph1 = mapOf(
        0 to listOf(1),
        1 to listOf(2),
        2 to listOf(0)
    )
    println("Test 1: Directed cycle 0→1→2→0")
    println("Has Cycle: ${hasCycleDirected(graph1)}")
    println("Expected: true\n")

    // Test Case 2: DAG — no cycle
    // 0 → 1 → 3
    // 0 → 2 → 3
    val graph2 = mapOf(
        0 to listOf(1, 2),
        1 to listOf(3),
        2 to listOf(3),
        3 to emptyList()
    )
    println("Test 2: DAG (0→1→3, 0→2→3)")
    println("Has Cycle: ${hasCycleDirected(graph2)}")
    println("Expected: false\n")

    // Test Case 3: Self-loop
    val graph3 = mapOf(
        0 to listOf(0) // Self-loop
    )
    println("Test 3: Self-loop (0→0)")
    println("Has Cycle: ${hasCycleDirected(graph3)}")
    println("Expected: true")
}
