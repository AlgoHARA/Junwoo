import java.io.BufferedReader
import java.io.InputStreamReader

/*
1065 한수
*/
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    if (num < 100) { // 1~99는 구할 필요 없으므로 제외
        print(num)
    } else {
        var temp = 99
        repeat(num - 99) {
            temp += solution(it + 100)
        }
        print(temp)
    }
}

fun solution(n: Int): Int {
    val list = n.toString().map {
        it.code - '0'.toInt()
    }
    return if (list[0] - list[1] == list[1] - list[2]) // 각 자리수의 차가 등차수열인지
        1
    else
        0
}

