/**
 * Problem: Detect Cycle in Undirected Graph
 * Determine if an undirected graph contains a cycle using BFS.
 *
 * Approach: For each unvisited node, do BFS. Track the parent to avoid false positives.
 * If a visited neighbor is not the parent, a cycle exists.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

import java.util.LinkedList

fun hasCycleUndirected(graph: Map<Int, List<Int>>): Boolean {
    val visited = mutableSetOf<Int>()

    fun bfsFromNode(start: Int): Boolean {
        val queue: LinkedList<Pair<Int, Int>> = LinkedList() // (node, parent)
        queue.add(start to -1)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val (node, parent) = queue.poll()
            for (neighbor in graph.getOrDefault(node, emptyList())) {
                if (neighbor !in visited) {
                    visited.add(neighbor)
                    queue.add(neighbor to node)
                } else if (neighbor != parent) {
                    return true // Cycle detected
                }
            }
        }
        return false
    }

    for (node in graph.keys) {
        if (node !in visited) {
            if (bfsFromNode(node)) return true
        }
    }
    return false
}

fun main() {
    // Test Case 1: Graph WITH cycle
    // 0 -- 1
    // |    |
    // 3 -- 2
    val graph1 = mapOf(
        0 to listOf(1, 3),
        1 to listOf(0, 2),
        2 to listOf(1, 3),
        3 to listOf(0, 2)
    )
    println("Test 1: Square graph (0-1-2-3-0)")
    println("Has Cycle: ${hasCycleUndirected(graph1)}")
    println("Expected: true\n")

    // Test Case 2: Graph WITHOUT cycle (tree)
    // 0 -- 1 -- 2
    //           |
    //           3
    val graph2 = mapOf(
        0 to listOf(1),
        1 to listOf(0, 2),
        2 to listOf(1, 3),
        3 to listOf(2)
    )
    println("Test 2: Linear tree (no cycle)")
    println("Has Cycle: ${hasCycleUndirected(graph2)}")
    println("Expected: false\n")

    // Test Case 3: Disconnected — one component has cycle
    val graph3 = mapOf(
        0 to listOf(1),
        1 to listOf(0),
        2 to listOf(3),
        3 to listOf(2, 4),
        4 to listOf(3, 2)
    )
    println("Test 3: Disconnected graph, second component has cycle")
    println("Has Cycle: ${hasCycleUndirected(graph3)}")
    println("Expected: true")
}
