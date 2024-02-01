fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val prefix = mutableListOf<Int>()
    var max = Int.MIN_VALUE
    prefix.add(0)
    prefix.add(list[0])

    for (i in 2..list.size) {
        prefix.add(prefix[i - 1] + list[i - 1])
    }

    for (i in k..list.size) {
        val cur = prefix[i] - prefix[i - k]
        if (max < cur) {
            max = cur
        }
    }
    print(max)
} //O(n)
