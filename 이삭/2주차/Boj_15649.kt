package graph


private val visit = mutableListOf<Int>()
private val result = mutableListOf<Int>()

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    dfs(N,M)
}


private fun dfs(N: Int, M: Int) {

    if (result.size == M) {
        result.forEach {
            print("$it ")
        }
        println()
        return
    }
    for (i in 1..N) {
        if (!visit.contains(i)) {
            visit.add(i)
            result.add(i)
            dfs(N, M)
            result.removeLast()
            visit.removeLast()
        }
    }
    /**
     * visit  1 2 - 3 1  // 1,3
     * result 1 2 - 3 1
     * **/
}
