import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 2003 수들의 합2 성공버전
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.toMutableList()
    list.removeIf { it > m }

    var result = 0
    var count = 0
    var start = 0
    var end = 0

    while (true) {
        if (result >= m) result -= list[start++]
        else if (end == list.size) break
        else result += list[end++]

        if (result == m) count++
    }
    print(count)
}
