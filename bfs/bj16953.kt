import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/*
* 16593 A → B 
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (s, e) = readLine().split(" ").map { it.toLong() }
    var count = 0
    val queue = LinkedList<Long>()

    fun bfs(start: Long): Int {
        queue.add(start)
        while (queue.isNotEmpty()) {
            count++ // 이시점이 한 너비를 전체 탐색하는 시점 따라서 이떄 count를 하게된다면 도달하는데 최소수도
            // 배열을 사용하지 않고 구할 수 있다.
            repeat(queue.size) {
                val head = queue.poll()
                if (head > e) {
                    return -1
                }
                if (head == e) {
                    return count
                }
                if (head * 2 <= e) {
                    queue.add(head * 2)
                }
                if (head * 10 + 1 <= e) {
                    queue.add(head * 10 + 1)
                }
            }

        }
        return -1
    }

    println(bfs(s))
}
