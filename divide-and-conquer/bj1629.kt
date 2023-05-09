import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 1629 곱셈
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (a, b, c) = readLine().split(" ").map { it.toLong() }
    fun pow(a: Long, b: Long, c: Long): Long {
        if (b == 0L) return 1L % c
        val x = pow(a, b / 2, c)
        return if (b % 2 == 0L) x * x % c else x * x % c * a % c
    }

    println(pow(a, b, c))
}
