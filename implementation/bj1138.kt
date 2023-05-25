import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 1138 한줄로 서기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val order = readLine().split(" ").map { it.toInt() }

    val line = IntArray(n)

    for (i in 0 until n) {
        var count = order[i]
        for (j in 0 until n) {
            if (line[j] == 0) {
                if (count == 0) {
                    line[j] = i + 1
                    break
                }
                count--
            }
        }
    }
    println(line.joinToString(" "))
}
