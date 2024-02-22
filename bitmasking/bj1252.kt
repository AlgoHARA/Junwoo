fun main() {
    val (x, y) = readLine()!!.split(" ").map { it.toBigInteger(2) }
    print((x + y).toString(2))
}
