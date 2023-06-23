import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj2953 나는 요리사다
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val chief = IntArray(5)

    repeat(5) {
        chief[it] = readLine().split(" ").sumOf { it.toInt() }
    }
    print("${chief.indexOf(chief.max()) + 1} ${chief.max()}")
}
