fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    val x = readln().toInt()
    list.removeIf { it > x }
    list.sort()

    var start = 0
    var end = list.size - 1
    var sum = 0
    var count = 0

    while (start < end) {
        sum = list[start] + list[end]
        if (sum == x) count++

        if (sum >= x) end--
        else start++
    }

    print(count)
}
