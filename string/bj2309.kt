import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dwarf = mutableListOf<Int>()
    var one = 0
    var two = 1
    repeat(9) {
        dwarf.add(readLine().toInt())
    }
    while (true) {
        if (two == 9) {
            one += 1
            two = one + 1
        }
        if ((dwarf.sum() - dwarf[one] - dwarf[two]) == 100) {
            dwarf.removeAll(listOf(dwarf[one], dwarf[two]))
            break
        }
        two++
    }
    dwarf.sorted().forEach {
        println(it)
    }
}
