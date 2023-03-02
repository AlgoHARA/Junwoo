import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/**
* 1966 프린터 큐
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (documents, m) = readLine().split(" ").map { it.toInt() }
        val queue = ArrayDeque<Pair<Int, Int>>()
        var count = 1
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, it ->
            queue.add(Pair(it, index)) // it은 중요도, index는 문서의 순서
        }
        while (true) {
            val temp = queue.first()
            if (queue.maxOf { it.first } > temp.first) {
                queue.add(temp)
                queue.removeFirst()
            } else {
                if (m == temp.second) {
                    sb.append("$count\n")
                    break
                } else {
                    queue.removeFirst()
                    count++
                }
            }
        }
    }
    print(sb)
}
