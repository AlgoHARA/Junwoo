fun main() {

    val (n, k, b) = readLine()!!.split(" ").map { it.toInt() }
    val traffic = MutableList(n) { 0 }
    val prefix = MutableList(n + 1) { 0 }
    var sum = Int.MAX_VALUE
    var cur = 0
    repeat(b) {
        traffic[readln().toInt() - 1] = 1
    }
    prefix[0] = 0
    prefix[1] = traffic[0]
    for (i in 2..n) {
        prefix[i] = prefix[i - 1] + traffic[i - 1]
    }

    for (i in k..n) {
        cur = prefix[i] - prefix[i - k]
        if (sum > cur) sum = cur
    }

    print(sum)
}
