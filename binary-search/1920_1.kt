fun main() {
    val n = readLine()!!.toInt()
    val num = readLine()!!.split(" ").map { it.toBigInteger() }.toMutableSet()
    val m = readLine()!!.toInt()
    val diff = readLine()!!.split(" ").map { it.toBigInteger() }

    for(i in diff){
        if(num.contains(i)) println(1)
        else println(0)
    }
}
