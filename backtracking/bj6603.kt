import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/*
* 6603 로또
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    while (true) {
        val input = readLine().split(" ").map { it.toInt() }
        if (input[0] == 0) break

        val list = input.subList(1, input.size)
        val visited = BooleanArray(input.size - 1)

        fun backtrack(nums: String, depth: Int, start: Int) {
            if (depth == 6) {
                sb.append("${nums.trim()}\n")
                return
            }

            for (i in start until list.size) {
                if (!visited[i]) {
                    visited[i] = true
                    backtrack("$nums ${list[i]}", depth + 1, i)
                    visited[i] = false
                }
            }
        }
        backtrack("", 0, 0)
        print(sb)
        println()
        sb.clear()
    }
}
