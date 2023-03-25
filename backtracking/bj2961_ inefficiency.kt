import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StrictMath.min
import kotlin.math.abs

/*
* 2961 도영이가 만든 맛있는 음식 비효율코드
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var result = Long.MAX_VALUE
    val ingredients = ArrayList<Pair<Int, Int>>(n)
    val visited = BooleanArray(n)

    repeat(n) {
        val (s, b) = readLine().split(" ").map { it.toInt() }
        ingredients.add(Pair(s, b))
    }

    fun backtrack(depth: Int) {
        if (depth != 0) {
            var s: Long = 1
            var b: Long = 0
            visited.forEachIndexed { index, boolean ->
                if (boolean) {
                    s *= ingredients[index].first
                    b += ingredients[index].second
                }
            }
            result = min(result, abs(s - b))
        }
        repeat(n) {
            if (!visited[it]) {
                visited[it] = true
                backtrack(depth + 1)
                visited[it] = false
            }
        }
    }
    backtrack(0)
    print(result)
}
