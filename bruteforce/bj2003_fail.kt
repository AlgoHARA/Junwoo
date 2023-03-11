import java.io.BufferedReader
import java.io.InputStreamReader

/**
* 2003 수들의 합2 메모리 초과 버전
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.toMutableList()
    list.removeIf { it > m }
    var result = 0
    var count = 1
    var start = 0
    var end = count
    while (true) {
        if (end == list.size + 1) {
            count++
            start = 0
            end = count
        }
        if (count == list.size + 1) break
        if (list.subList(start, end).sum() == m) result++
        start++
        end++
    }
    print(result)
}
