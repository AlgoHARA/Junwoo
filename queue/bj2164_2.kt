import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


/*
백준 2146 카드2 LinkedList사용
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val queue: Queue<Int> = LinkedList<Int>()
    var count = 1
    repeat(readLine().toInt()) {
        queue.add(it + 1)
    }
    while (queue.size != 1) {
        if (count % 2 == 1) {
            queue.remove(queue.first())
        } else {
            queue.add(queue.first())
            queue.remove(queue.first())
        }
        count++
    }
    print(queue.first())
}
