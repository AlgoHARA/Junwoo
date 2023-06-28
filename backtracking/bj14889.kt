import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import kotlin.math.min

/*
* bj14889 스타트와 링크
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val map = Array(n) { IntArray(n) }
    var result = mutableListOf<Int>()
    val visited = BooleanArray(n)
    repeat(n) { col ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { row, i ->
            map[col][row] = i
        }
    }

    fun backtrack(depth: Int,start : Int) {
        if(depth > n/2) return
        if (depth == n / 2) {
            var start = 0
            var link = 0
            val startEntry = mutableListOf<Int>()
            val linkEntry = mutableListOf<Int>()
            visited.forEachIndexed { index, b ->
                if (b) startEntry.add(index)
                else linkEntry.add(index)
            }
            for(i in 0 until  n/2){
                for(j in i until n/2){
                    start += map[startEntry[i]][startEntry[j]]
                    start += map[startEntry[j]][startEntry[i]]
                    link += map[linkEntry[j]][linkEntry[i]]
                    link += map[linkEntry[i]][linkEntry[j]]
                }
            }
            result.add(abs(start - link))
            return
        }

        for (i in start until n) {
            if(!visited[i]){
                visited[i] = true
                backtrack(depth + 1, i)
                visited[i] = false
            }
        }
        return
    }

    backtrack(0,0)
    print(result.min())
}
// 백트래킹 할때 순열과 조합 차이 확실히 구분하여 실행시간을 줄이자~!
