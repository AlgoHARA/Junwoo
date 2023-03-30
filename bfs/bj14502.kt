import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.LinkedList

/*
14502 연구소

// row = n = y = r = [][]에서 첫번째 오는 거
// col = m = x = c = [][]에서 두번째 오는 거

 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val lab = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }
    val vi = LinkedList<Pair<Int, Int>>()
    var count = 0
    val temp = Array(n) { IntArray(m) } // 벽이 세워지는 경우의 수를 넣어주는 경우
    val queue = LinkedList<Pair<Int, Int>>()
    var result = 0
    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            lab[it][index] = i
            if (i == 2) queue.add(Pair(it, index)) // 최초 바이러스의 시작점들을 
        }
    }

    fun bfs(virus: LinkedList<Pair<Int, Int>>) {
        while (virus.isNotEmpty()) {
            val size = virus.size
            repeat(size) {// 최초 시작점만큼 퍼뜨리기 위해서 bfs
                val head = virus.poll()
                val row = head.first
                val col = head.second
                if (row + 1 < n) {
                    if (temp[row + 1][col] == 0) {
                        temp[row + 1][col] = 2
                        virus.offer(Pair(row + 1, col))
                    }
                }
                if (row - 1 >= 0) {
                    if (temp[row - 1][col] == 0) {
                        temp[row - 1][col] = 2
                        virus.offer(Pair(row - 1, col))
                    }

                }
                if (col + 1 < m) {
                    if (temp[row][col + 1] == 0) {
                        temp[row][col + 1] = 2
                        virus.offer(Pair(row, col + 1))
                    }

                }
                if (col - 1 >= 0) {
                    if (temp[row][col - 1] == 0) {
                        temp[row][col - 1] = 2
                        virus.offer(Pair(row, col - 1))
                    }
                }
            }
        }
    }


    fun backtrack(depth: Int) {
        if (depth == 3) {
            lab.forEachIndexed { col, rows ->
                rows.forEachIndexed { row, i ->
                    temp[col][row] = i
                }
            } // 원본 연구실의 배치를 가져옴
            visited.forEachIndexed { col, rows ->
                rows.forEachIndexed { row, b ->
                    if (b) temp[col][row] = 1
                }
            }// 백트래킹을 통해서 벽을 3개 세운 경우를 복사본 연구실에 적용
            queue.forEach {
                vi.add(it) //최초 시작점 넘겨주기 위함
            }
            bfs(vi)
            count = 0
            temp.forEach {
                count += it.count { it == 0 } // 0의 갯수를 세서 결과값에 갱신
            }
            result = max(result, count)
            return
        }

        //조합을 위한 백트래킹
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (lab[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true
                    backtrack(depth + 1)
                    visited[i][j] = false
                }
            }
        }
    }
    backtrack(0)
    print(result)

}
