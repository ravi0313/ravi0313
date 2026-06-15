/**
 * Problem: Dijkstra's Shortest Path Algorithm
 * Find the shortest path from a source node to all other nodes in a weighted graph.
 *
 * Approach: Use a min-heap (PriorityQueue) to always process the closest unvisited node.
 * Track distances in an array, update if a shorter path is found.
 *
 * Time Complexity: O((V + E) log V)
 * Space Complexity: O(V + E)
 */

import java.util.PriorityQueue

fun dijkstra(graph: Map<Int, List<Pair<Int, Int>>>, source: Int, numNodes: Int): IntArray {
    val dist = IntArray(numNodes) { Int.MAX_VALUE }
    dist[source] = 0

    // PriorityQueue of (distance, node)
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    pq.add(0 to source)

    while (pq.isNotEmpty()) {
        val (currDist, node) = pq.poll()

        if (currDist > dist[node]) continue // Outdated entry

        for ((neighbor, weight) in graph.getOrDefault(node, emptyList())) {
            val newDist = dist[node] + weight
            if (newDist < dist[neighbor]) {
                dist[neighbor] = newDist
                pq.add(newDist to neighbor)
            }
        }
    }

    return dist
}

fun main() {
    // Test Case 1: Standard weighted graph
    //   0 --4-- 1
    //   |       |
    //   8       2
    //   |       |
    //   2 --7-- 3
    val graph1 = mapOf(
        0 to listOf(1 to 4, 2 to 8),
        1 to listOf(0 to 4, 3 to 2),
        2 to listOf(0 to 8, 3 to 7),
        3 to listOf(1 to 2, 2 to 7)
    )
    println("Test 1: 4-node weighted graph")
    val dist1 = dijkstra(graph1, 0, 4)
    println("Shortest distances from node 0:")
    dist1.forEachIndexed { i, d -> println("  Node $i: $d") }
    println("Expected: [0, 4, 8, 6]\n")

    // Test Case 2: Linear path with weights
    // 0 -1- 1 -2- 2 -3- 3
    val graph2 = mapOf(
        0 to listOf(1 to 1),
        1 to listOf(0 to 1, 2 to 2),
        2 to listOf(1 to 2, 3 to 3),
        3 to listOf(2 to 3)
    )
    println("Test 2: Linear chain with weights")
    val dist2 = dijkstra(graph2, 0, 4)
    println("Shortest distances from node 0:")
    dist2.forEachIndexed { i, d -> println("  Node $i: $d") }
    println("Expected: [0, 1, 3, 6]")
}
