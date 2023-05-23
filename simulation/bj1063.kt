import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj1063 킹
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`)))  {
    val directions = listOf("R", "L", "B", "T", "RT", "LT", "RB", "LB")
    val dx = intArrayOf(1, -1, 0, 0, 1, -1, 1, -1)
    val dy = intArrayOf(0, 0, -1, 1, 1, 1, -1, -1)

    val input = readLine().split(" ")
    var kingX = input[0][0] - 'A'
    var kingY = input[0][1].toString().toInt()
    var stoneX = input[1][0] - 'A'
    var stoneY = input[1][1].toString().toInt()
    val n = input[2].toInt()

    repeat(n) {
        val command = readLine()
        var kingNextX = kingX
        var kingNextY = kingY

        when (command) {
            "R" -> {
                kingNextX += dx[0]
                kingNextY += dy[0]
            }
            "L" -> {
                kingNextX += dx[1]
                kingNextY += dy[1]
            }
            "B" -> {
                kingNextX += dx[2]
                kingNextY += dy[2]
            }
            "T" -> {
                kingNextX += dx[3]
                kingNextY += dy[3]
            }
            "RT" -> {
                kingNextX += dx[4]
                kingNextY += dy[4]
            }
            "LT" -> {
                kingNextX += dx[5]
                kingNextY += dy[5]
            }
            "RB" -> {
                kingNextX += dx[6]
                kingNextY += dy[6]
            }
            "LB" -> {
                kingNextX += dx[7]
                kingNextY += dy[7]
            }
        }

        if (kingNextX < 0 || kingNextX >= 8 || kingNextY < 1 || kingNextY > 8) {
            return@repeat
        }

        if (kingNextX == stoneX && kingNextY == stoneY) {
            var stoneNextX = stoneX
            var stoneNextY = stoneY

            stoneNextX += dx[directions.indexOf(command)]
            stoneNextY += dy[directions.indexOf(command)]

            if (stoneNextX < 0 || stoneNextX >= 8 || stoneNextY < 1 || stoneNextY > 8) {
                return@repeat
            }

            kingX = kingNextX
            kingY = kingNextY
            stoneX = stoneNextX
            stoneY = stoneNextY
        } else {
            kingX = kingNextX
            kingY = kingNextY
        }
    }

    val kingPosition = "${('A'.toInt() + kingX).toChar()}$kingY"
    val stonePosition = "${('A'.toInt() + stoneX).toChar()}$stoneY"

    println(kingPosition)
    println(stonePosition)
}
