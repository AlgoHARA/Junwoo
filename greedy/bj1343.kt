import java.io.BufferedReader
import java.io.InputStreamReader

/*
1343 폴리오미노
*/


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var board = readLine()
    board = board.replace("XXXX", "AAAA").replace("XX", "BB")

    if (board.contains("X")) print(-1)
    else print(board)
}
