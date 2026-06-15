# LeetCode Problem Tracker — Kotlin Solutions

Track every LeetCode problem solved in Kotlin, organized by pattern.

---

## 📋 Problem Log

| # | Problem Name | Difficulty | Pattern | Kotlin File | Time | Space | Notes |
|---|-------------|-----------|---------|------------|------|-------|-------|
| 1 | Two Sum | 🟢 Easy | Hashing | [TwoSum.kt](./arrays/TwoSum.kt) | O(n) | O(n) | HashMap complement lookup |
| 2 | Valid Palindrome | 🟢 Easy | Two Pointers | [TwoPointers.kt](./interview-patterns/TwoPointers.kt) | O(n) | O(1) | Skip non-alphanumeric chars |
| 3 | Maximum Subarray | 🟢 Easy | Kadane's | [MaxSubarray.kt](./arrays/MaxSubarray.kt) | O(n) | O(1) | Track currentSum and maxSum |
| 4 | Binary Search | 🟢 Easy | Binary Search | [BinarySearch.kt](./searching/BinarySearch.kt) | O(log n) | O(1) | Classic iterative approach |
| 5 | Reverse Linked List | 🟢 Easy | Linked List | [ReverseLinkedList.kt](./linked-list/ReverseLinkedList.kt) | O(n) | O(1) | Three-pointer iterative |
| 6 | Merge Two Sorted Lists | 🟢 Easy | Linked List | [MergeSortedLists.kt](./linked-list/MergeSortedLists.kt) | O(n+m) | O(1) | Dummy head technique |
| 7 | Climbing Stairs | 🟢 Easy | DP | [Fibonacci.kt](./dynamic-programming/Fibonacci.kt) | O(n) | O(n) | Same recurrence as Fibonacci |
| 8 | Best Time to Buy and Sell Stock | 🟢 Easy | Sliding Window | [SlidingWindow.kt](./arrays/SlidingWindow.kt) | O(n) | O(1) | Track min price, max profit |
| 9 | Number of Islands | 🟡 Medium | Graph DFS | [NumberOfIslands.kt](./graphs/NumberOfIslands.kt) | O(m×n) | O(m×n) | DFS floods each island |
| 10 | 3Sum | 🟡 Medium | Two Pointers | [TwoPointers.kt](./interview-patterns/TwoPointers.kt) | O(n²) | O(1) | Sort + fix one, two-pointer rest |
| 11 | Container With Most Water | 🟡 Medium | Two Pointers | [TwoPointers.kt](./interview-patterns/TwoPointers.kt) | O(n) | O(1) | Move shorter height inward |
| 12 | Longest Substring Without Repeating | 🟡 Medium | Sliding Window | — | O(n) | O(k) | HashMap of last seen index |
| 13 | Group Anagrams | 🟡 Medium | Hashing | [GroupAnagrams.kt](./hashing/GroupAnagrams.kt) | O(nk log k) | O(nk) | Sort each string as key |
| 14 | Word Search | 🟡 Medium | Backtracking | [WordSearch.kt](./backtracking/WordSearch.kt) | O(m×n×4^L) | O(L) | DFS with backtracking |
| 15 | Coin Change | 🟡 Medium | DP | [CoinChange.kt](./dynamic-programming/CoinChange.kt) | O(n×W) | O(W) | Bottom-up DP table |
| 16 | House Robber | 🟡 Medium | DP | [HouseRobber.kt](./dynamic-programming/HouseRobber.kt) | O(n) | O(1) | dp[i] = max(dp[i-1], dp[i-2]+nums[i]) |
| 17 | Merge Intervals | 🟡 Medium | Intervals | [MergeIntervals.kt](./interview-patterns/MergeIntervals.kt) | O(n log n) | O(n) | Sort by start, merge overlaps |
| 18 | Top K Frequent Elements | 🟡 Medium | Heap | [TopKFrequentElements.kt](./hashing/TopKFrequentElements.kt) | O(n) | O(n) | Bucket sort by frequency |
| 19 | Trapping Rain Water | 🔴 Hard | Two Pointers | [TrappingRainWater.kt](./arrays/TrappingRainWater.kt) | O(n) | O(n) | Precompute left/right max arrays |
| 20 | N-Queens | 🔴 Hard | Backtracking | [NQueens.kt](./backtracking/NQueens.kt) | O(N!) | O(N²) | Place queen, check diagonals |

---

## 📊 Progress Summary

| Difficulty | Solved | Total |
|-----------|--------|-------|
| 🟢 Easy | 8 | — |
| 🟡 Medium | 10 | — |
| 🔴 Hard | 2 | — |
| **Total** | **20** | — |

---

## 🗂️ By Pattern

| Pattern | Count | Problems |
|---------|-------|----------|
| Two Pointers | 4 | Valid Palindrome, 3Sum, Container With Most Water, Trapping Rain Water |
| DP | 4 | Climbing Stairs, Coin Change, House Robber, Group Anagrams |
| Backtracking | 2 | Word Search, N-Queens |
| Hashing | 3 | Two Sum, Group Anagrams, Top K Frequent |
| Linked List | 2 | Reverse Linked List, Merge Two Sorted Lists |
| Graph DFS | 1 | Number of Islands |
| Binary Search | 1 | Binary Search |
| Sliding Window | 2 | Best Time to Buy Sell Stock, Longest Substring |
| Intervals | 1 | Merge Intervals |
| Kadane's | 1 | Maximum Subarray |

---

## 🔖 Templates

### Binary Search Template
```kotlin
fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0; var right = arr.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when { arr[mid] == target -> return mid; arr[mid] < target -> left = mid + 1; else -> right = mid - 1 }
    }
    return -1
}
```

### Two Pointers Template
```kotlin
var left = 0; var right = arr.size - 1
while (left < right) {
    // process arr[left] and arr[right]
    if (condition) left++ else right--
}
```

### Sliding Window Template
```kotlin
var left = 0; var maxLen = 0
for (right in arr.indices) {
    // expand window with arr[right]
    while (windowIsInvalid) { /* shrink */ left++ }
    maxLen = maxOf(maxLen, right - left + 1)
}
```

### Backtracking Template
```kotlin
fun backtrack(state) {
    if (isGoal(state)) { results.add(state.copy()); return }
    for (choice in choices) {
        if (isValid(choice)) {
            makeChoice(choice)
            backtrack(state)
            undoChoice(choice) // backtrack
        }
    }
}
```

---

*Last updated: 2026-06-15 | Problems solved in Kotlin*
