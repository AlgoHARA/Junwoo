import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 10026 
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val pic = Array(n) { CharArray(n) }
    var normal = 0
    var weakness = 0
    val visited = Array(n) { BooleanArray(n) }


    repeat(n) { col ->
        readLine().forEachIndexed { row, color ->
            pic[col][row] = color
        }
    }


    fun dfsNormal(col: Int, row: Int, color: Char) {
        visited[col][row] = true
        if (col - 1 >= 0) {
            if (pic[col - 1][row] == color && !(visited[col - 1][row])) dfsNormal(col - 1, row, color)
        }
        if (col + 1 < n) {
            if (pic[col + 1][row] == color && !(visited[col + 1][row])) dfsNormal(col + 1, row, color)
        }
        if (row - 1 >= 0) {
            if (pic[col][row - 1] == color && !(visited[col][row - 1])) dfsNormal(col, row - 1, color)
        }
        if (row + 1 < n) {
            if (pic[col][row + 1] == color && !(visited[col][row + 1])) dfsNormal(col, row + 1, color)
        }
    }


    for (col in 0 until n) {
        for (row in 0 until n) {
            if (!visited[col][row]) {
                dfsNormal(col, row, pic[col][row])
                normal++
            }
        }
    }

    visited.forEach {
        it.fill(false)
    }

    pic.forEachIndexed { col, chars ->
        chars.forEachIndexed { row, c ->
            if (c == 'R')
                pic[col][row] = 'G'
        }
    }

    for (col in 0 until n) {
        for (row in 0 until n) {
            if (!visited[col][row]) {
                dfsNormal(col, row, pic[col][row])
                weakness++
            }
        }
    }

    print("$normal $weakness")

}
