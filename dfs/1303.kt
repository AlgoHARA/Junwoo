fun main() {

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    var countB = 0
    var countW = 0
    var totalDepth = 1

    val (m, n) = readLine()!!.split(" ").map { it.toInt() }

    val graph = Array(n) { CharArray(m) }
    val visited = Array(n) { BooleanArray(m) { false } }
    repeat(n) { n ->
        readLine()!!.forEachIndexed { index, c ->
            graph[n][index] = c
        }
    }

    fun dfs(x: Int, y: Int, type: Char, depth: Int) {
        visited[x][y] = true
        for (i in 0 until 4) {
            val dx = dx[i] + x
            val dy = dy[i] + y
            if (dx in 0 until n && dy in 0 until m) {
                if (!(visited[dx][dy]) && type == graph[dx][dy]) {
                    totalDepth += 1
                    dfs(dx, dy, type, totalDepth)
                }
            }
        }
    }

    graph.forEachIndexed { x, cs ->
        cs.forEachIndexed { y, c ->
            if (!visited[x][y]) {
                totalDepth = 1
                dfs(x, y, graph[x][y], totalDepth)
                if (graph[x][y] == 'B') countB += totalDepth * totalDepth
                else countW += totalDepth * totalDepth
            }
        }
    }
    print("$countW $countB")

}
