import java.io.BufferedReader
import java.io.InputStreamReader

private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: Array<Boolean>
private var answerDfs = ""
private var answerBfs = ""

fun main(args: Array<String>) {
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { mutableListOf() }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a) //양방향
    } // graph 입력

    repeat(n + 1) { idx ->
        graph[idx].sort() // 정점 번호가 가장 작은 것을 먼저 방문하기 위해 정렬
    }

    visited = Array(n + 1) { false }
    dfs(v)
    println(answerDfs)

    visited = Array(n + 1) { false }
    bfs(v)
    println(answerBfs)
}

fun dfs(start: Int) {
    if(visited[start]) return

    visited[start] = true
    answerDfs += "$start "

    for(next in graph[start]) {
        dfs(next)
    }
}

fun bfs(start: Int) {
    val queue = ArrayDeque<Int>()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val next = queue.removeFirst()

        answerBfs += "$next "

        for(node in graph[next]) {
            if(visited[node]) continue
            visited[node] = true
            queue.add(node)
        }
    }
}
