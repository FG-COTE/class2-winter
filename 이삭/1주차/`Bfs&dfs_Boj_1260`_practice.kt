package graph

import java.io.InputStreamReader
import java.util.*

private var graph = Array(0) { Array(0) { it -> 0 } }
private val visit = mutableListOf<Int>()

fun main() = with(InputStreamReader(System.`in`)) {

    val (vertex, lineCount, start) = readLine()!!.split(" ").map { it.toInt() }

    connectionLine(vertex,lineCount)

    dfs(start)
    println()
    visit.clear()
    bfs(start)
    /**
    for (i in 0 until lineCount) {
    for ( j in 0 until lineCount) {
    print(graph[i][j])
    }
    println()
    }
     **/
}

private fun connectionLine(vertex: Int, lineCount: Int) {
    graph = Array(vertex + 1) { Array(vertex + 1) { it -> 0 } }
    repeat(lineCount){
        val (line1, line2) = readLine()!!.split(" ").map { it.toInt() }
        graph[line1][line2] = 1
        graph[line2][line1] = 1
    }
}

private fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visit.add(start)
    while (true) {
        val startNode = queue.poll()
        print("$startNode ")
        for (i in graph.indices) {
            if (!visit.contains(i) && graph[i][startNode] == 1 && graph[startNode][i] == 1) {
                queue.add(i)
                visit.add(i)
            }
        }
        if (queue.isEmpty()) break
    }
}
/**
 * 인접노드깊이별로먼저 방문 선입선출
 * start 0
 * 0 -> que 0 visit 0
 * 1 -> que 1 visit 0 1
 * 2 -> que 1,2 visit 012
 * 3 -> que 1,2 visit 012
 * 4 -> que 124 visit 0124
 * start 1
 * 0 ,2 연결 끝 그대로 que 24 visit 0124
 * start2
 * 3-> que 43 visit 01243
 * **/

private fun dfs(start: Int) {
    visit.add(start)
    print("$start ")
    for (i in graph.indices) {
        if (!visit.contains(i) && graph[i][start] == 1 && graph[start][i] == 1) {
            dfs(i)
        }
    }
}

/**
 * 들어간노드와 연결된노드 쭉탐색
 * start 0
 * visit 0
 * 1-> visit 0,1**/
