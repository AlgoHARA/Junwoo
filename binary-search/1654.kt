import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 1654 랜선 자르기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (k, n) = readLine().split(" ").map { it.toInt() }
    val cables = mutableListOf<Long>()
    repeat(k) {
        cables.add(readLine().toLong())
    }
    var left = 1L
    var right = cables.maxOrNull() ?: 0L
    while (left <= right) {
        val mid = (left + right) / 2
        var count = 0L
        for (cable in cables) {
            count += cable / mid
        }
        if (count >= n) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(right)
}
