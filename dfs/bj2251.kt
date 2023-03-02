import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/*
* 백준 2251 물통
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bottles = readLine().split(" ").map { it.toInt() }
    val visited = Array(201) { BooleanArray(201) }
    val sb = StringBuilder()
    val result = mutableSetOf<Int>()

    fun dfs(a: Int, b: Int, c: Int) {
        if (visited[a][b]) return
        else visited[a][b] = true

        if (a == 0) result.add(c)

        if (a + b > bottles[0]) dfs(bottles[0], a + b - bottles[0], c)
        else dfs(a + b, 0, c)

        if (b + a > bottles[1]) dfs(a + b - bottles[1], bottles[1], c)
        else dfs(0, a + b, c)

        if (a + c > bottles[0]) dfs(bottles[0], b, a + c - bottles[0])
        else dfs(a + c, b, 0)

        if (b + c > bottles[1]) dfs(a, bottles[1], b + c - bottles[1])
        else dfs(a, b + c, 0)

        if (a + c > bottles[2]) dfs(a + c - bottles[2], b, bottles[2])
        else dfs(0, b, a + c)

        if (b + c > bottles[2]) dfs(a, b + c - bottles[2], bottles[2])
        else dfs(a, 0, b + c)

        dfs(0, b, a + c)


    }
    dfs(0, 0, bottles[2])
    result.sorted().forEach {
        sb.append("$it ")
    }
    print(sb)
}
