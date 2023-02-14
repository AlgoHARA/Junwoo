import java.io.BufferedReader
import java.io.InputStreamReader

/*
2501 약수 구하기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (num, condition) = readLine().split(" ").map { it.toInt() }
    var count = 0
    var temp = 1

    while (temp <= num) {
        if (num % temp == 0) {
            count++
            if (count == condition) break
        }
        temp++
    }
    if (temp > num)
        print(0)
    else
        print(temp)
}
