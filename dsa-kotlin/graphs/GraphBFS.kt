/**
 * Problem: Graph BFS (Breadth First Search)
 * Traverse a graph level-by-level using BFS starting from a source node.
 * Uses an adjacency list represented as HashMap<Int, List<Int>>.
 *
 * Time Complexity: O(V + E) where V = vertices, E = edges
 * Space Complexity: O(V)
 */

import java.util.LinkedList

fun bfs(graph: Map<Int, List<Int>>, start: Int): List<Int> {
    val visited = mutableSetOf<Int>()
    val queue: LinkedList<Int> = LinkedList()
    val order = mutableListOf<Int>()

    visited.add(start)
    queue.add(start)

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        order.add(node)

        for (neighbor in graph.getOrDefault(node, emptyList())) {
            if (neighbor !in visited) {
                visited.add(neighbor)
                queue.add(neighbor)
            }
        }
    }

    return order
}

fun main() {
    // Graph:
    //  0 -- 1 -- 2
    //  |         |
    //  3 --------4
    val graph1 = mapOf(
        0 to listOf(1, 3),
        1 to listOf(0, 2),
        2 to listOf(1, 4),
        3 to listOf(0, 4),
        4 to listOf(2, 3)
    )
    println("Test 1: Graph with 5 nodes")
    println("Adjacency list: $graph1")
    println("BFS from 0: ${bfs(graph1, 0)}")
    println("Expected: [0, 1, 3, 2, 4]\n")

    // Graph: Disconnected (BFS won't reach node 5)
    val graph2 = mapOf(
        0 to listOf(1, 2),
        1 to listOf(0),
        2 to listOf(0),
        5 to listOf(6),
        6 to listOf(5)
    )
    println("Test 2: BFS from 0 (component with 0, 1, 2 — node 5, 6 unreachable)")
    println("BFS from 0: ${bfs(graph2, 0)}")
    println("Expected: [0, 1, 2]\n")

    // Graph: Linear chain
    val graph3 = mapOf(
        1 to listOf(2),
        2 to listOf(1, 3),
        3 to listOf(2, 4),
        4 to listOf(3)
    )
    println("Test 3: Linear chain [1-2-3-4], BFS from 1")
    println("BFS from 1: ${bfs(graph3, 1)}")
    println("Expected: [1, 2, 3, 4]")
}
