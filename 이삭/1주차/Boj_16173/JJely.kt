package graph.Boj_16173

import java.util.*

private var graph = Array(0) { Array(0) { it -> 0 } }
private var visit = Array(0) { Array(0) { it -> 0 } }

fun main() {
    val map = readLine()!!.toInt()
    visit = Array(map) { Array(map) { it -> 0 } }
    graph = Array(map) { Array(map) { it -> 0 } }
    makeMap(map, graph)
//    dfs(0, 0, map)
    bfs(0, 0, map)
//    for (i in 0 until map) {
//        for (j in 0 until map) {
//            print(visit[i][j])
//        }
//        println()
//    }
    if (visit[map - 1][map - 1] == 1) print("HaruHaru")
    else print("Hing")
}


private fun dfs(x: Int, y: Int, map: Int) {
    visit[0][0] = 1
    for (i in 0 until 2) {
        val nx = x + (dx[i] * graph[x][y])
        val ny = y + (dy[i] * graph[x][y])
        if (nx >= 0 && ny >= 0 && nx < map && ny < map) {
            if (visit[nx][ny] == 0) {
                visit[nx][ny] = 1
                dfs(nx, ny, map)
            }
        }
    }
}

private fun makeMap(map: Int, graph: Array<Array<Int>>) {
    for (i in 0 until map) {
        graph[i] = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    }
}

private val dx = arrayOf(1, 0)
private val dy = arrayOf(0, 1)

private fun bfs(x: Int, y: Int, map: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))
    visit[0][0] = 1
    while (true) {
        var (x, y) = queue.poll()

        for (i in 0 until 2) {

            val nx = x + (dx[i] * graph[x][y])
            val ny = y + (dy[i] * graph[x][y])
            if (nx >= 0 && ny >= 0 && nx < map && ny < map) {
                if (visit[nx][ny] != 1) {
                    visit[nx][ny] = 1
                    queue.add(Pair(nx, ny))
                }
            }
        }
        if (queue.isEmpty()) break
    }
}
