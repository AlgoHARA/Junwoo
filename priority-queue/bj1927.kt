import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
* 1927 최소힙
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()
    val heap = PriorityQueue<Int>()
    repeat(readLine().toInt()) {
        val num = readLine().toInt()
        if (num == 0) {
            if (heap.isNotEmpty()) sb.append("${heap.poll()}\n")
            else sb.append("0\n")
        } else {
            heap.add(num)
        }
    }
    print(sb)
}
