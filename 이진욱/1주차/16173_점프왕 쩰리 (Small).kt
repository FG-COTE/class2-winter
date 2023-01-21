import java.io.BufferedReader
import java.io.InputStreamReader


private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<List<Int>>
private lateinit var visited: Array<Array<Boolean>>
private var n = 0
private val dirs = listOf(listOf(0, 1), listOf(1, 0), listOf(-1, 0), listOf(1, 0))

var answer = "Hing"

fun main(args: Array<String>) {
    n = br.readLine().toInt()

    graph = Array(n) { listOf() }
    visited = Array(n) { Array(n) { false } }
    repeat(n) { idx ->
        graph[idx] = br.readLine().split(" ").map { it.toInt() }
    }

    visited[0][0] = true
    dfs(0, 0)
    println(answer)
}

fun dfs(i: Int, j: Int) {

    if(i == n -1 && j == n - 1) {
        answer = "HaruHaru"
        return
    }

    for((di, dj) in dirs) {
        val (ni, nj) = listOf(i + di * graph[i][j], j + dj * graph[i][j])
        if((ni !in 0 until n || nj !in 0 until n || visited[ni][nj])) continue

        visited[ni][nj] = true
        dfs(ni, nj)
    }
}

//fun bfs(i: Int, j: Int) {
//    visited[i][j] = true
//    val queue = ArrayDeque<Pair<Int, Int>>()
//    queue.add(Pair(0, 0))
//
//    while (queue.isNotEmpty()) {
//        val (i, j) = queue.removeLast()
//
//        if(i == n -1 && j == n - 1) {
//            answer = "HaruHaru"
//            break
//        }
//
//        for((di, dj) in dirs) {
//            val (ni, nj) = listOf(i + di * graph[i][j], j + dj * graph[i][j])
//            if((ni !in 0 until n || nj !in 0 until n || visited[ni][nj])) continue
//
//            visited[ni][nj] = true
//            queue.add(Pair(ni, nj))
//        }
//    }
//
//    println(answer)
//}
