fun main() {

    val (n, x) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val prefix = mutableListOf<Int>()

    var max = 0
    var count = 1

    prefix.add(0)
    prefix.add(list[0])
    for (i in 2 .. list.size) {
        prefix.add(prefix[i - 1] + list[i - 1])
    }

    for (i in x .. list.size) {
        val cur = prefix[i] - prefix[i - x]
        if (max <= cur) {
            if (max == cur) count++
            else {
                count = 1
                max = cur
            }
        }

    }


    if (max == 0) print("SAD")
    else {
        println(max)
        print(count)
    }

}
