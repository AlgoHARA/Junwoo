import java.io.BufferedReader
import java.io.InputStreamReader

/*
1158 요세푸스 문제
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (size, count) = readLine().split(" ").map { it.toInt() }
    val queue = ArrayDeque<Int>(size)

    repeat(size) {
        queue.add(it + 1)
    }

    if(count == 1){
        print(queue.toString().replace("[", "<").replace("]", ">"))
    }else{
        val result = mutableListOf<Int>()
        var temp = 1

        while (queue.size != 1) {
            if (temp == count) {
                temp = 1
                result.add(queue.removeFirst())
            }
            queue.addLast(queue.removeFirst())
            temp++
        }
        result.add(queue.removeFirst())
        print(result.toString().replace("[", "<").replace("]", ">"))
    }
}
