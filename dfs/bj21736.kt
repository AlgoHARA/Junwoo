const val PEOPLE = 'P'
const val DO_YEON ='I'
const val WALL ='X'

fun main() {

    val (n, m) = readln().split(" ").map { it.toInt() }


    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    var count = 0

    val graph = Array(n) { CharArray(m) }
    val visited = Array(n) { BooleanArray(m) }

    var x = 0
    var y = 0
    repeat(n) { col ->
        readln().forEachIndexed { row, c ->
            graph[col][row] = c
            if (c == DO_YEON) {
                x = row
                y = col
            }
        }
    }


    fun dfs(row: Int, col: Int) {
        visited[col][row] = true
        if(graph[col][row] == PEOPLE) count++

        for(i in 0 until 4){
            val dx = dx[i] + row
            val dy = dy[i] + col

            if(dy in 0 until n && dx in 0 until m && graph[dy][dx] != WALL && !visited[dy][dx]){
                dfs(dx,dy)
            }
        }

    }

    dfs(x,y)

    if(count == 0) print("TT")
    else print(count)
}
