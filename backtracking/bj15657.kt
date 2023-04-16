import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj15657 N과 M(8)
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.sorted()
    val result = mutableSetOf<String>()
    fun backtrack(nums: String,start:Int, depth: Int) {
        if (depth == m) {
            result.add(nums.trim())
            return
        }
        for (i in start..n - 1) {
            backtrack("$nums${list[i]} ", i,depth + 1)
        }
    }
    backtrack("", 0,0)
    print(result.joinToString("\n"))
}
