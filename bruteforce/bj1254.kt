import java.io.BufferedReader
import java.io.InputStreamReader
/*
* 1254 팰린드롬 만들기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine()
    val reversed = str.reversed()
    var len = str.length * 2

    for (i in str.indices) {
        if (str.substring(i) == reversed.substring(0, str.length - i)) {
            len = str.length + i
            break
        }
    }

    print(len)
}
