import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

/**
 * 2217 로프
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val ropes = ArrayList<Int>()
    var result = 0
    repeat(n) {
        ropes.add(readLine().toInt())
    }
    ropes.sortByDescending { it } // 내림차순
    ropes.forEachIndexed { index, i ->
        val temp = i * (index + 1) // i는 내림차순 기준으로 로프의 길이 , index를 이용하여 길이 대신 사용
        result = max(temp, result) // 어떤게 더 무게를 더 지탱 할 수 있는지 max를 통해서 비교
    }
    print(result)
}
