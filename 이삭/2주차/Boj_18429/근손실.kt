package graph.Boj_18429



private val visit = mutableListOf<Int>()
private var answer=0
private var a= mutableListOf<Int>()
fun main(){
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
     a = readLine()!!.split(" ").map { it.toInt() } as MutableList<Int>
    dfs(500,0,N,M)
    print(answer)
}

fun dfs(maxWeight: Int, cnt: Int, N:Int, M:Int) {
    if (cnt == N) {
        answer++
        return
    }
    for (j in 0 until a.size){
        val resultWeight =maxWeight + a[j] - M
        if (!visit.contains(a[j]) && resultWeight >=500){
            visit.add(a[j])
            dfs(resultWeight,cnt+1,N,M)
            visit.removeLast()
        }
    }
}