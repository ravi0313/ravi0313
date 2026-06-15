/**
 * Problem: Topological Sort (Kahn's Algorithm — BFS based)
 * Given a Directed Acyclic Graph (DAG), return nodes in topological order.
 * A node must appear before all nodes it points to.
 *
 * Approach: Compute in-degrees. Start with 0 in-degree nodes (no dependencies).
 * Process each node, reducing neighbor in-degrees. Add newly 0 in-degree nodes.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

import java.util.LinkedList

fun topologicalSort(graph: Map<Int, List<Int>>, numNodes: Int): List<Int> {
    val inDegree = IntArray(numNodes)

    // Compute in-degrees
    for ((_, neighbors) in graph) {
        for (neighbor in neighbors) {
            inDegree[neighbor]++
        }
    }

    // Enqueue all nodes with 0 in-degree
    val queue: LinkedList<Int> = LinkedList()
    for (i in 0 until numNodes) {
        if (inDegree[i] == 0) queue.add(i)
    }

    val order = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        order.add(node)
        for (neighbor in graph.getOrDefault(node, emptyList())) {
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) queue.add(neighbor)
        }
    }

    return if (order.size == numNodes) order else emptyList() // Empty if cycle detected
}

fun main() {
    // Test Case 1: Standard DAG
    // 5 → 2, 5 → 0, 4 → 0, 4 → 1, 2 → 3, 3 → 1
    val graph1 = mapOf(
        5 to listOf(2, 0),
        4 to listOf(0, 1),
        2 to listOf(3),
        3 to listOf(1),
        0 to emptyList(),
        1 to emptyList()
    )
    println("Test 1: DAG with 6 nodes")
    val result1 = topologicalSort(graph1, 6)
    println("Topological Order: $result1")
    println("Expected: [4, 5, 0, 2, 3, 1] or any valid topological order\n")

    // Test Case 2: Simple dependency chain
    // 0 → 1 → 2 → 3
    val graph2 = mapOf(
        0 to listOf(1),
        1 to listOf(2),
        2 to listOf(3),
        3 to emptyList()
    )
    println("Test 2: Chain 0→1→2→3")
    val result2 = topologicalSort(graph2, 4)
    println("Topological Order: $result2")
    println("Expected: [0, 1, 2, 3]\n")

    // Test Case 3: Graph with cycle (should return empty)
    val graph3 = mapOf(
        0 to listOf(1),
        1 to listOf(2),
        2 to listOf(0) // cycle
    )
    println("Test 3: Graph with cycle")
    val result3 = topologicalSort(graph3, 3)
    println("Topological Order: $result3")
    println("Expected: [] (cycle detected)")
}
