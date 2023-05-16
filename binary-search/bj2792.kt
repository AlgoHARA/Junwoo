import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 2792 보석 상자
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val people = mutableListOf<Int>()
    var result = 0
    repeat(m) {
        people.add(readLine().toInt())
    }

    var left = 1
    var right = people.maxOrNull() ?: 0

    // 이분 탐색
    while (left <= right) {
        val mid = (left + right) / 2
        var count = 0

        people.forEach {
            count += it / mid
            if(it % mid != 0) count++
        }
        if (count > n) {
            left = mid + 1
        } else {
            right = mid - 1
            result = mid
        }
    }

    println(result)

}
