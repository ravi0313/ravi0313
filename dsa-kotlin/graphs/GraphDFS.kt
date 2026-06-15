/**
 * Problem: Graph DFS (Depth First Search)
 * Traverse a graph as deep as possible before backtracking.
 * Uses an adjacency list represented as HashMap<Int, List<Int>>.
 *
 * Time Complexity: O(V + E) where V = vertices, E = edges
 * Space Complexity: O(V) for visited set + O(h) recursion stack
 */

fun dfs(graph: Map<Int, List<Int>>, start: Int, visited: MutableSet<Int> = mutableSetOf()): List<Int> {
    val order = mutableListOf<Int>()

    fun explore(node: Int) {
        visited.add(node)
        order.add(node)
        for (neighbor in graph.getOrDefault(node, emptyList())) {
            if (neighbor !in visited) {
                explore(neighbor)
            }
        }
    }

    explore(start)
    return order
}

fun main() {
    // Graph:
    //  0 -- 1
    //  |  \ |
    //  3    2
    val graph1 = mapOf(
        0 to listOf(1, 2, 3),
        1 to listOf(0, 2),
        2 to listOf(0, 1),
        3 to listOf(0)
    )
    println("Test 1: Graph with 4 nodes")
    println("Adjacency list: $graph1")
    println("DFS from 0: ${dfs(graph1, 0)}")
    println("Expected: [0, 1, 2, 3] (order may vary by adjacency list order)\n")

    // Tree-like graph
    val graph2 = mapOf(
        1 to listOf(2, 3),
        2 to listOf(1, 4, 5),
        3 to listOf(1),
        4 to listOf(2),
        5 to listOf(2)
    )
    println("Test 2: Tree-like graph, DFS from 1")
    println("DFS from 1: ${dfs(graph2, 1)}")
    println("Expected: [1, 2, 4, 5, 3]\n")

    // Single node
    val graph3 = mapOf(7 to emptyList<Int>())
    println("Test 3: Single node graph")
    println("DFS from 7: ${dfs(graph3, 7)}")
    println("Expected: [7]")
}
