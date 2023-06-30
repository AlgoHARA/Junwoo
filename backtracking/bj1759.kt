import java.io.BufferedReader
import java.io.InputStreamReader

/* 
* bj1759 암호 만들기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val gat = listOf('a', 'e', 'i', 'o', 'u')
    val temp = mutableListOf<String>()
    val result = mutableSetOf<String>()
    val words = readLine().split(" ")
    val visited = BooleanArray(m)

    fun backtrack(start: Int, depth: Int) {
        if (depth == n) {
            var str = ""
            temp.sorted().forEach {
                str += it
            }
            result.add(str)
            return
        }

        for (i in start until m) {
            if (!visited[i]) {
                visited[i] = true
                temp.add(words[i])
                backtrack(i, depth + 1)
                temp.remove(words[i])
                visited[i] = false
            }
        }
    }

    backtrack(0, 0)
    result.sorted().forEach { str ->
        if (str.count { gat.contains(it) } >= 1 && str.count { !(gat.contains(it)) } >= 2) {
            println(str)
        }
    }
}
