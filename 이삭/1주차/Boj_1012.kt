package graph

import java.util.*


private var graph = Array(0) { Array(0) { it -> 0 } }

fun main() {
    val count = readLine()!!.toInt()
    repeat(count) {
        val (M, N, K) = readLine()!!.split(" ").map { it.toInt() }
        graph = Array(M) { Array(N) { it -> 0 } }
        repeat(K) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            graph[x][y] = 1
        }
        var result = 0

        for (i in 0 until M) {
            for (j in 0 until N) {
                if (graph[i][j] == 1) {
//                dfs(i,j,M,N)
                    bfs(i, j, M, N)
                    result++
                }
            }
        }
        println(result)
    }
}

private val dx = arrayOf(-1, 0, 1, 0)
private val dy = arrayOf(0, -1, 0, 1)

// 구글링 검색하여 방문한 곳을 0으로 바꿈으로 방문횟수를 체크
fun dfs(x: Int, y: Int, M: Int, N: Int) {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
            if (graph[nx][ny] == 1) {
                graph[nx][ny] = 0
                dfs(nx, ny, M, N)
            }
        }
    }
}

private fun bfs(x: Int, y: Int, M: Int, N: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(x, y))
    while (true) {
        var (a, b) = queue.poll()
        for (i in 0 until 4) {
            val nx = a + dx[i]
            val ny = b + dy[i]
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = 0
                    queue.add(Pair(nx, ny))
                }
            }
        }
        if (queue.isEmpty()) break
    }
}
