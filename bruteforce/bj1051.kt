import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

/*
1051 숫자 정사각형
*/


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val nums = mutableListOf<MutableList<Int>>()
    repeat(n) {
        val temp = mutableListOf<Int>()
        readLine().forEachIndexed { index, char ->
            temp.add(char.code - 48)
        }
        nums.add(temp)
    }

    var result = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            val size = min(m - j, n - i)
            for (k in size downTo 1) {
                if (nums[i][j] == nums[i + k - 1][j + k - 1] &&
                    nums[i][j] == nums[i][j + k - 1] &&
                    nums[i][j] == nums[i + k - 1][j]
                ) {
                    result = max(k * k, result) //max 메소드를 이용하여 if 제거
                }
            }
        }
    }
    println(result)
}


