import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
* bj2075 N번째 큰 수
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val queue = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEach { i ->
            queue.add(i)
        }
    }

    repeat(n - 1) {
        queue.poll()
    }
    println(queue.poll())
}
