import java.io.BufferedReader
import java.io.InputStreamReader
/*
15903 카드 합체 놀이
*/
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val cards = mutableListOf<Long>()
    readLine().split(" ").map { cards.add(it.toLong()) }

    repeat(m) {
        cards.sort()
        val temp = cards.subList(0, 2).sum()
        cards[0] = temp
        cards[1] = temp
    }
    print(cards.sum())
}
