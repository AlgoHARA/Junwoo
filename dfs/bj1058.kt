import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 친구
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val friend = Array(n) { ArrayList<Int>() }
    val visited = BooleanArray(n)
    var twoFriend = mutableSetOf<Int>()
    var result = ArrayList<Int>(n)

    repeat(n) {
        readLine().forEachIndexed { index, c ->
            if (c == 'Y') friend[it].add(index)
        }
    }

    fun dfs(start: Int, depth: Int) {
        if (depth == 2) return
        visited[start] = true
        friend[start].forEach {
            if (!visited[it]) {
                twoFriend.add(it)
                dfs(it, depth + 1)
            }
        }
    }

    repeat(n) {
        dfs(it, 0)
        result.add(twoFriend.size)
        visited.fill(false)
        twoFriend.clear()
    }
    print(result.max())
}
