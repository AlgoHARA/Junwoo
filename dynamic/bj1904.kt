import java.io.BufferedReader
import java.io.InputStreamReader

/*
1904 01타일
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = mutableListOf<Int>()
    list.add(0)
    list.add(1)
    list.add(2)
    for (i in 3 until n + 1) {
        list.add((list[i - 1] + list[i - 2]) % 15746)
    }
    print(list[n])
}
