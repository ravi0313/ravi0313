/**
 * BFS Graph Traversal using Kotlin Coroutines and Channels
 * Traditional BFS uses a Queue imperatively. Kotlin Coroutines allow expressing this
 * as a producer/consumer flow using Channels — making the "queue" a typed communication channel.
 *
 * Why cleaner than Java: No external thread management, structured concurrency,
 * Channel<T> replaces LinkedList<T> with type-safe, suspendable sends/receives.
 *
 * Note: Requires kotlinx-coroutines-core dependency.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

suspend fun bfsWithChannel(graph: Map<Int, List<Int>>, start: Int): List<Int> = coroutineScope {
    val visited = mutableSetOf(start)
    val order = mutableListOf<Int>()

    // Channel acts as the BFS queue
    val channel = Channel<Int>(capacity = Channel.UNLIMITED)
    channel.send(start)

    while (!channel.isEmpty) {
        val node = channel.receive()
        order.add(node)

        for (neighbor in graph.getOrDefault(node, emptyList())) {
            if (visited.add(neighbor)) { // add returns true if not already present
                channel.send(neighbor)
            }
        }
    }

    channel.close()
    order
}

// Bonus: Producer coroutine that emits BFS order as a Flow-like sequence
fun bfsSequence(graph: Map<Int, List<Int>>, start: Int): Sequence<Int> = sequence {
    val visited = mutableSetOf(start)
    val queue = ArrayDeque<Int>()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        yield(node) // Emit lazily

        for (neighbor in graph.getOrDefault(node, emptyList())) {
            if (visited.add(neighbor)) {
                queue.add(neighbor)
            }
        }
    }
}

fun main() = runBlocking {
    val graph = mapOf(
        0 to listOf(1, 2),
        1 to listOf(0, 3, 4),
        2 to listOf(0, 5),
        3 to listOf(1),
        4 to listOf(1),
        5 to listOf(2)
    )

    println("=== BFS with Coroutines + Channel ===")
    println("Graph: $graph")
    val channelResult = bfsWithChannel(graph, 0)
    println("BFS order (Channel):   $channelResult")
    println("Expected: [0, 1, 2, 3, 4, 5]\n")

    println("=== BFS as lazy Sequence ===")
    val seqResult = bfsSequence(graph, 0).toList()
    println("BFS order (Sequence): $seqResult")
    println("Expected: [0, 1, 2, 3, 4, 5]\n")

    println("=== BFS Sequence — take first 3 nodes lazily ===")
    val first3 = bfsSequence(graph, 0).take(3).toList()
    println("First 3 nodes: $first3")
    println("Expected: [0, 1, 2]")
}
