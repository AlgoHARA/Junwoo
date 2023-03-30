import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

/*
* 10819 차이를 최대로
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val nums = IntArray(n) { 0 }
    val visited = BooleanArray(n)
    val pick = ArrayList<Int>(n + 1)
    val result = ArrayList<Int>()
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        nums[index] = i
    }

    fun backtracking(depth: Int) {

        if (depth == n) {
            var temp = 0
            repeat(n - 1) {
                temp += abs(pick[it] - pick[it + 1])
            }
            result.add(temp)
        }

        for (i in 0..n - 1) {
            if (!visited[i]) {
                visited[i] = true
                pick.add(nums[i])
                backtracking(depth + 1)
                pick.removeLast()
                visited[i] = false
            }
        }

    }
    backtracking(0)
    print(result.max())
}
