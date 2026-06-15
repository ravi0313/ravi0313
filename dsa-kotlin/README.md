# DSA with Kotlin - Index

Welcome to the Data Structures & Algorithms collection implemented in Kotlin!

📌 **Note:** Every file in this repository includes detailed **Time Complexity** and **Space Complexity** comments. Each solution comes with comprehensive test cases in the `main()` function.

---

## 🗺️ Learning Path (Recommended Study Order)

1. **Arrays** — Foundation: prefix sums, sliding window, two pointers
2. **Hashing** — HashMap patterns for O(1) lookups and grouping
3. **Linked List** — Pointer manipulation, fast/slow pointers
4. **Stack & Queue** — LIFO/FIFO applications and monotonic stack
5. **Sorting** — Comparison sorts, divide & conquer
6. **Searching** — Binary search and its variants
7. **Trees** — Recursive thinking, BST, DFS, BFS
8. **Graphs** — BFS, DFS, shortest path, topological sort
9. **Dynamic Programming** — Memoization, tabulation, recurrences
10. **Backtracking** — Constraint satisfaction and pruning
11. **Interview Patterns** — Pattern recognition across problem types
12. **Kotlin Patterns** — Idiomatic Kotlin for DSA

---

## 📊 Arrays

Master fundamental array operations and optimization techniques.

1. 🔗 [Two Sum](./arrays/TwoSum.kt) - Find two numbers that add up to target
2. 📈 [Max Subarray](./arrays/MaxSubarray.kt) - Find maximum sum of contiguous subarray
3. 🪟 [Sliding Window](./arrays/SlidingWindow.kt) - Find max sum of subarray of size K
4. 📊 [Prefix Sum](./arrays/PrefixSum.kt) - Build prefix sum array for range queries
5. 🚩 [Dutch National Flag](./arrays/DutchNationalFlag.kt) - Sort 0s, 1s, 2s in single pass
6. 💧 [Trapping Rain Water](./arrays/TrappingRainWater.kt) - Calculate water trapped between heights
7. 🔢 [Product Except Self](./arrays/ProductExceptSelf.kt) - Product of all other elements without division
8. 🔄 [Rotate Array](./arrays/RotateArray.kt) - Rotate array by K steps

---

## #️⃣ Hashing

Use HashMaps and HashSets to reduce time complexity from O(n²) to O(n).

1. 📦 [Group Anagrams](./hashing/GroupAnagrams.kt) - Group strings that are anagrams
2. 🔢 [Longest Consecutive Sequence](./hashing/LongestConsecutiveSequence.kt) - O(n) consecutive sequence
3. ➕ [Subarray Sum Equals K](./hashing/SubarraySumEqualsK.kt) - Count subarrays with sum K
4. 🏆 [Top K Frequent Elements](./hashing/TopKFrequentElements.kt) - K most frequent using bucket sort

---

## 🔗 Linked List

Work with linked data structures and pointer manipulation.

1. 🔄 [Reverse Linked List](./linked-list/ReverseLinkedList.kt) - Reverse a singly linked list
2. 🔍 [Detect Cycle](./linked-list/DetectCycle.kt) - Detect cycle using Floyd's algorithm
3. 🔀 [Merge Sorted Lists](./linked-list/MergeSortedLists.kt) - Merge two sorted lists

---

## 🌳 Trees

Explore binary trees, binary search trees, and traversals.

1. 🔍 [Binary Search Tree](./trees/BinarySearchTree.kt) - Insert, search, delete operations
2. 📍 [Level Order Traversal](./trees/LevelOrderTraversal.kt) - BFS traversal by levels
3. 🔀 [DFS Traversals](./trees/InorderPreorderPostorder.kt) - Inorder, Preorder, Postorder
4. 👥 [Lowest Common Ancestor](./trees/LowestCommonAncestor.kt) - Find LCA of two BST nodes
5. ✅ [Validate BST](./trees/ValidateBST.kt) - Check if binary tree is a valid BST
6. 📏 [Max Depth](./trees/MaxDepthBinaryTree.kt) - Maximum depth of binary tree
7. 📐 [Diameter of Tree](./trees/DiameterOfTree.kt) - Longest path in a binary tree
8. 💾 [Serialize / Deserialize](./trees/SerializeDeserializeTree.kt) - Convert tree to string and back
9. 🪞 [Symmetric Tree](./trees/SymmetricTree.kt) - Check if tree is a mirror of itself

---

## 📈 Sorting

Learn classic and efficient sorting algorithms.

1. 🫧 [Bubble Sort](./sorting/BubbleSort.kt) - Simple comparison-based sort
2. 🔀 [Merge Sort](./sorting/MergeSort.kt) - Divide and conquer sorting
3. ⚡ [Quick Sort](./sorting/QuickSort.kt) - Partition-based sorting

---

## 🔍 Searching

Find elements efficiently in arrays and lists.

1. 🎯 [Binary Search](./searching/BinarySearch.kt) - Iterative binary search
2. 🔎 [Linear Search](./searching/LinearSearch.kt) - Sequential search
3. 🔄 [Binary Search Recursive](./searching/BinarySearchRecursive.kt) - Recursive approach

---

## 📚 Stack & Queue

Implement and work with LIFO and FIFO data structures.

1. 📚 [Stack Using Array](./stack-queue/StackUsingArray.kt) - Stack implementation with IntArray
2. 🚪 [Queue Using Linked List](./stack-queue/QueueUsingLinkedList.kt) - Queue implementation

---

## 🕸️ Graphs

Traverse, detect cycles, find shortest paths in graphs.

1. 🌐 [Graph BFS](./graphs/GraphBFS.kt) - Breadth First Search with adjacency list
2. 🔍 [Graph DFS](./graphs/GraphDFS.kt) - Depth First Search recursively
3. 🔄 [Detect Cycle Undirected](./graphs/DetectCycleUndirected.kt) - Cycle in undirected graph (BFS)
4. 🔄 [Detect Cycle Directed](./graphs/DetectCycleDirected.kt) - Cycle in directed graph (DFS + recursion stack)
5. 📊 [Topological Sort](./graphs/TopologicalSort.kt) - Kahn's algorithm for DAG ordering
6. 📍 [Shortest Path Dijkstra](./graphs/ShortestPathDijkstra.kt) - Dijkstra with PriorityQueue
7. 🏝️ [Number of Islands](./graphs/NumberOfIslands.kt) - Count islands in 2D grid

---

## 💡 Dynamic Programming

Optimize solutions using memoization and tabulation.

1. 🔢 [Fibonacci](./dynamic-programming/Fibonacci.kt) - Memoization approach
2. 🎒 [Knapsack Problem](./dynamic-programming/Knapsack.kt) - 0/1 Knapsack with DP
3. 📝 [Longest Common Subsequence](./dynamic-programming/LongestCommonSubsequence.kt) - LCS using DP
4. 🪙 [Coin Change](./dynamic-programming/CoinChange.kt) - Minimum coins for target amount
5. 📈 [Longest Increasing Subsequence](./dynamic-programming/LongestIncreasingSubsequence.kt) - LIS with binary search
6. ✏️ [Edit Distance](./dynamic-programming/EditDistance.kt) - Levenshtein distance
7. 🔢 [Matrix Chain Multiplication](./dynamic-programming/MatrixChainMultiplication.kt) - Minimum cost
8. ✅ [Subset Sum](./dynamic-programming/SubsetSum.kt) - Does a subset with given sum exist?
9. 📖 [Word Break](./dynamic-programming/WordBreak.kt) - Segment string into dictionary words
10. 🏠 [House Robber](./dynamic-programming/HouseRobber.kt) - Max profit without adjacent houses

---

## 🔙 Backtracking

Explore all possible solutions with constraint pruning.

1. 👑 [N-Queens](./backtracking/NQueens.kt) - Place N queens with no conflicts
2. 🔢 [Sudoku Solver](./backtracking/SudokuSolver.kt) - Solve a 9×9 Sudoku board
3. 🔀 [Permutations](./backtracking/Permutations.kt) - All permutations of a list
4. 🗂️ [Subsets](./backtracking/Subsets.kt) - All possible subsets (power set)
5. 🔤 [Word Search](./backtracking/WordSearch.kt) - Find word in 2D character grid
6. 🐭 [Rat in a Maze](./backtracking/RatInAMaze.kt) - All paths through a binary maze

---

## 🦋 Kotlin Patterns

Idiomatic Kotlin techniques that make DSA cleaner than Java.

1. 🔧 [Functional DSA](./kotlin-patterns/FunctionalDSA.kt) - TwoSum, GroupAnagrams with map/filter/fold
2. 🧩 [Extension Functions](./kotlin-patterns/ExtensionFunctions.kt) - DSA helpers on IntArray and List
3. 🌳 [Sealed Class Tree](./kotlin-patterns/SealedClassTree.kt) - Binary tree with sealed classes + `when`
4. ⚡ [Coroutine BFS](./kotlin-patterns/CoroutineBFS.kt) - BFS with Kotlin Coroutines + Channels
5. 🔗 [Data Class LinkedList](./kotlin-patterns/DataClassLinkedList.kt) - Generic linked list with generics

---

## 🎯 Interview Patterns

Pattern-based grouping of the most common interview problems.

1. ↔️ [Two Pointers](./interview-patterns/TwoPointers.kt) - Palindrome, Most Water, 3Sum
2. 🐢 [Fast & Slow Pointers](./interview-patterns/FastSlowPointers.kt) - Middle of List, Happy Number, Duplicate
3. 📅 [Merge Intervals](./interview-patterns/MergeIntervals.kt) - Merge, Insert, Non-overlapping Intervals
4. 🔄 [Cyclic Sort](./interview-patterns/CyclicSort.kt) - Missing Number, Duplicate, All Missing
5. 📚 [Monotonic Stack](./interview-patterns/MonotonicStack.kt) - Next Greater, Daily Temps, Histogram
6. 🔍 [Binary Search Variants](./interview-patterns/BinarySearchVariants.kt) - Rotated Array, Peak, Kth Smallest
7. 🏆 [Top K Pattern](./interview-patterns/TopKPattern.kt) - Kth Largest, K Closest, K-Sorted Array

---

## 📊 LeetCode Tracker

Track your problem-solving progress: [LEETCODE_TRACKER.md](./LEETCODE_TRACKER.md)

---

## 💡 Key Concepts

- **Time Complexity:** Measure of how fast an algorithm runs
- **Space Complexity:** Measure of memory used by an algorithm
- **Memoization:** Caching results to avoid redundant calculations
- **Tabulation:** Building solutions bottom-up
- **In-place Algorithms:** Solving without extra space

---

## 📚 How to Use

1. Navigate to any `.kt` file
2. Read the problem description in comments
3. Check Time & Space Complexity
4. Run the `main()` function to see test cases
5. Modify and experiment with the code

---

**Happy coding! 🚀**
