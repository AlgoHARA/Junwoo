import java.io.BufferedReader
import java.io.InputStreamReader

/*
11478 서로 다른 부분 문자열의 개수
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine()
    var count = 0
    var partition = 1
    val part = mutableSetOf<String>()

    repeat(s.length) {
        count = 0
        while (true) {
            if(count+partition > s.length) break
            part.add(s.substring(count, (count + partition)))
            count++
        }
        partition++
    }
    print(part.size)
}
