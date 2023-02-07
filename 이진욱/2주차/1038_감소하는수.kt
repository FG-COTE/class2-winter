import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess


private val br = BufferedReader(InputStreamReader(System.`in`))
var count = 0
var n = 0
val numbers = mutableListOf<Long>()

fun main(args: Array<String>) {
    n = br.readLine().toInt()


    for(digit in 2 .. 10) {
        dfs(10, digit, mutableListOf())
    }

    if(n >= numbers.size + 10)
        println(-1)
    else if(n < 10)
        println(n)
    else
        println(numbers[n - 10])
}

// 맨 앞자리 숫자가 start로 시작하는 digit 자리수 만큼의 감소하는 수를 모두 구한다.
fun dfs(start: Int, digit: Int, stk: MutableList<Int>) {

    if(digit == 0) {
        numbers.add(stk.joinToString("").toLong())
    }

    for(next in 0 until start) {
        stk.add(next)
        dfs(next, digit - 1, stk)
        stk.removeLast()
    }
}

/**
* dp를 사용하면 더 효율이 좋아졌을 듯 ...
* 감소하는 수가 최대 몇 개인지 판단하지 못해서 해당 알고리즘을 사용함.
* https://best-human-developer.tistory.com/86
* 위 블로그를 보면 감소하는 수의 최대 개수가 1023개임을 이용하여 문제를 품
* 감소하는 수의 최대 개수를 알았다면 좀 더 쉽게 접근하여 문제를 풀 수 있었을 듯
* 시간 복잡도의 중요성을 다시 한번 깨달은 문제
*/
