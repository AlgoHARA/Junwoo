import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj21610 마법사 상어와 비바라기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val dx = listOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val dy = listOf(0, -1, -1, -1, 0, 1, 1, 1)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(n) }
    val prevCloud = Array(n) { BooleanArray(n) { false } }
    prevCloud[n - 1][0] = true
    prevCloud[n - 1][1] = true
    prevCloud[n - 2][0] = true
    prevCloud[n - 2][1] = true
    val tempCloud = Array(n) { BooleanArray(n) { false } }
    
    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            map[it][index] = i
        }
    }

    repeat(m) {

        val (d, s) = readLine().split(" ").map { it.toInt() }

        prevCloud.forEachIndexed { row, booleans ->
            booleans.forEachIndexed { col, b ->
                if (b) {
                    var x = col + (dx[d - 1] * s) % n
                    if (x <= -1) x += n
                    else if (x >= n) x -= n

                    var y = row + (dy[d - 1] * s) % n
                    if (y <= -1) y += n
                    else if (y >= n) y -= n

                    map[y][x] += 1
                    tempCloud[y][x] = true
                }
            }
        }//비내림

        tempCloud.forEachIndexed { row, booleans ->
            booleans.forEachIndexed { col, b ->
                if (b) {
                    for (i in 1 until 8 step (2)) {
                        if (col + dx[i] in 0 until n && row + dy[i] in 0 until n) {
                            if (map[row + dy[i]][col + dx[i]] != 0) map[row][col] += 1
                        }
                    }
                }
            }
        }
        prevCloud.forEach {
            it.fill(false)
        }
        
        repeat(n) { row ->
            repeat(n) { col ->
                if (!tempCloud[row][col]) {
                    if (map[row][col] >= 2) {
                        map[row][col] -= 2
                        prevCloud[row][col] = true
                    }
                }
            }
        }
        tempCloud.forEach {
            it.fill(false)
        }
    }

    var result = 0

    map.forEach {
        it.forEach { water ->
            result += water
        }
    }
    print(result)
}


/*
시간 초과 버전 : MutableList와 Pair로 인해서 속도가 느려짐
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val dx = listOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val dy = listOf(0, -1, -1, -1, 0, 1, 1, 1)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(n) }
    val prevCloud = mutableListOf(Pair(n - 1, 0), Pair(n - 1, 1), Pair(n - 2, 0), Pair(n - 2, 1)) // 초기 구름
    val tempCloud = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            map[it][index] = i
        }
    }

    repeat(m) {

        val (d, s) = readLine().split(" ").map { it.toInt() }

        prevCloud.forEach {
            var x = it.second + (dx[d - 1] * s) % n
            if (x <= -1) x += n
            else if (x >= n) x -= n

            var y = it.first + (dy[d - 1] * s) % n
            if (y <= -1) y += n
            else if (y >= n) y -= n

            map[y][x] += 1
            tempCloud.add(Pair(y, x))
        } // 비내림

        tempCloud.forEach {
            val x = it.second
            val y = it.first
            for (i in 1 until 8 step (2)) {
                if (x + dx[i] in 0 until n && y + dy[i] in 0 until n) {
                    if (map[y + dy[i]][x + dx[i]] != 0) map[y][x] += 1
                }
            }
        } // 물복사
        prevCloud.clear()
        repeat(n) { row ->
            repeat(n) { col ->
                if (!tempCloud.contains(Pair(row, col))) {
                    if (map[row][col] >= 2) {
                        map[row][col] -= 2
                        prevCloud.add(Pair(row, col))
                    }
                }
            }
        }
        tempCloud.clear()
    }

    var result = 0

    map.forEach {
        it.forEach { water ->
            result += water
        }
    }
    print(result)
}

*/
