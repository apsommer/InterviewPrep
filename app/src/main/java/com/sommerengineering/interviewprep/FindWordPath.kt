package com.sommerengineering.interviewprep

fun findWordPath(
    words: List<String>,
    start: String,
    end: String
): List<String> {

    // catch malformed input
    if (!words.contains(start) || !words.contains(end)) return emptyList()

    // breadth first search (BFS) graph problem
    val queue: ArrayDeque<List<String>> = ArrayDeque() // FIFO queue
    val visited = mutableSetOf<String>() // avoid cycles

    // initialize with start word
    queue.add(listOf(start))
    visited.add(start)

    while (queue.isNotEmpty()) {

        // get first path in queue (FIFO)
        val path = queue.removeFirst() // BFS -> removeFirst(), DFS -> removeLast()
        val current = path.last()

        // check for solution
        if (current == end) return path

        // take last char of current word and find all words that start with it
        val lastChar = current.last()

        for (word in words) {

            // catch word we have already visited
            if (visited.contains(word)) continue

            if (word.first() == lastChar) {

                // add word to path and add to queue/visited
                val newPath = path + word
                queue.add(newPath)
                visited.add(word)
            }
        }
    }

    return emptyList()
}