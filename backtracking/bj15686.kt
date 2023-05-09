import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 15686 치킨배달
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    var count = 0
    val result = mutableListOf<Int>()
    val chicken = mutableListOf<Pair<Int, Int>>()
    val house = mutableListOf<Pair<Int, Int>>()
    val visited = Array(n) { BooleanArray(n) }

    repeat(n) { col ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { row, i ->
            if (i == 2) {
                count++
                chicken.add(Pair(col, row))
            }
            if (i == 1) {
                house.add(Pair(col, row))
            }
        }
    }

    fun backtrack(chick: Int, start: Int) {
        if (chick == m) {
            // 최대값까지 폐쇄되었으면 브루트포스로 거리계산
            var total = 0
            house.forEach {
                val col = it.first
                val row = it.second
                var temp = Int.MAX_VALUE
                chicken.forEach { chi ->
                    if (!visited[chi.first][chi.second]) temp =
                        (kotlin.math.abs(col - chi.first) + kotlin.math.abs(row - chi.second)).coerceAtMost(temp)
                }
                total += temp
            }
            result.add(total)
            return
        }

        for (i in start until chicken.size) { //start를 통해서 중복 조합의 경우를 제거해준다.
            val col = chicken[i].first
            val row = chicken[i].second
            if (!visited[col][row]) {
                visited[col][row] = true //ture하면 폐쇄처리
                backtrack(chick - 1, i)
                visited[col][row] = false
            }
        }
    }
    backtrack(count, 0)
    println(result.min())

}
