import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj4344 평균은 넘겠지
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n){
        val list = readLine().split(" ").map { it.toInt() }
        val scores = list.subList(1,list.size)
        val avg = scores.average()
        var prime = 0
        scores.forEach {
            if (it > avg) prime++
        }
        val result = String.format("%.3f", prime.toDouble()/list[0] * 100)
        println("${result}%")
    }
}
